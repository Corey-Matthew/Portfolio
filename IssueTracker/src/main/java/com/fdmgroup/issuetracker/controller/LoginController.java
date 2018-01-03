package com.fdmgroup.issuetracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;

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
    if(user == null)
      {
     	model.addAttribute("notfound", true);
   		path = "login";	
	}
		else if(!user.getPassword().equals(password)){
			model.addAttribute("notmatch", true);
			path = "login";	
		}
		else if (user.getRole().equals("employee"))
		{
			request.getSession().setAttribute("employee", user);
			path = "index";
		}
		else if (user.getRole().equals("superAdmin"))
		{
			request.getSession().setAttribute("superAdmin", user);
			path = "index";
		}
		else if (user.getRole().equals("deptAdmin"))
		{
			request.getSession().setAttribute("deptAdmin", user);
			path = "index";
		}
		return path;
	}

}
