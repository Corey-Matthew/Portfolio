package com.fdmgroup.issuetracker.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;
import com.fdmgroup.issuetracker.utils.Validation;

@Controller
public class LoginController {
	
/**
 * Return to the login page
 * @param req
 * @param model
 * @return
 */
	@RequestMapping(value="/login")
	public String displayLogin(HttpServletRequest req, Model model)
	{
		ApplicationContext conx = (ApplicationContext)req.getSession().getServletContext().getAttribute("conx");
		model.addAttribute("user", conx.getBean("user"));
		return "login";
	}

/**
 * Deal with login requests
 * Need to get role of every user
 * @param request
 * @param model
 * @param username
 * @param password
 * @return path
 */
   @RequestMapping(value="/LoginServlet", method=RequestMethod.POST)
   public String login(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password)

   {
    UserDAO dao = (UserDAO)request.getSession().getServletContext().getAttribute("dao");
    User user = dao.getUser(username);
    String path;
	if (user == null) {
		path = "login";
		model.addAttribute("notfound", true);
	}
	if (Validation.compare(dao, username, password)){
		if (user.getRole().equals("employee")){
			request.getSession().setAttribute("employee", user);
			path = "homepage";
		}
		else if (user.getRole().getRoleName.equals("superAdmin")){
			request.getSession().setAttribute("superAdmin", user);
			path= "homepage";
		}
		else if (user.getRole().equals("deptAdmin")){
			request.getSession().setAttribute("deptAdmin", user);
			path = "homepage";
		}
	}
	else {
		model.addAttribute("notmatch", true);
		path = "login";
	}
		return path;
	}

}
