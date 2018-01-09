package com.fdmgroup.issuetracker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	private ApplicationContext ctx;
	private UserDAO userDAO;

	/**
	 * Return to the login page
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String displayLogin() {
		return "login";
	}

	/**
	 * Deal with login requests Need to get role of every user
	 * 
	 * @param request
	 * @param model
	 * @param username
	 * @param password
	 * @return path
	 */
	@RequestMapping(value = "/LoginServlet", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, 
			@RequestParam String username,
			@RequestParam String password) {
		HttpSession session = request.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		User user = userDAO.getUser(username);
		String path = null;
		if (user == null) {
			path = "login";
			model.addAttribute("notfound", true);
			return path;
		}
		else if (Validation.compare(userDAO, username, password)) {
			request.getSession().setAttribute("user", user);
			path = "index";

		} else {
			model.addAttribute("notmatch", true);
			path = "login";
		}
		return path;
	}
	/**
	 * Logs out a user
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession userSesh = request.getSession();
		userSesh.removeAttribute("user");
		userSesh.invalidate();
		return "index";
	}

}
