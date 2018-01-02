package com.fdmgroup.issuetracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.regisapp.exceptions.DMLException;
import com.fdmgroup.regisapp.model.User;
import com.fdmgroup.regisapp.model.UserDAO;

@Controller
public class LoginController {
	
	
	@RequestMapping(value="/login")
	public String displayLogin(HttpServletRequest req, Model model)
	{
		ApplicationContext conx = (ApplicationContext)req.getSession().getServletContext().getAttribute("conx");
		model.addAttribute("user", conx.getBean("user"));
		return "login";
	}
	
	/**
	 * Register page
	 * @param req the request 
	 * @param model the model used for the form
	 * @return path for registration page
	 */
	@RequestMapping(value="/register")
	public String displayRegister(HttpServletRequest req, Model model)
	{
		ApplicationContext conx = (ApplicationContext)req.getSession().getServletContext().getAttribute("conx");
		model.addAttribute("user", conx.getBean("user"));
		return "register";
	}
	
	/**
	 * Handles the login request 
	 * @param request 
	 * @param model the model for the webpage data
	 * @param username username input to be matched
	 * @param password password input to be matched
	 * @return path to home upon successful login or redirect back to login and sets flags for failures
	 */
	@RequestMapping(value="/LoginServlet", method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password) throws DMLException
	
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
		else
		{
			request.getSession().setAttribute("user", user);
			path = "index";
		}
		return path;
	}

}
