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
public class RegisterController {
	
/**
 * Return to the login page
 * @param req
 * @param model
 * @return
 */
	@RequestMapping(value="/register")
	public String displayLogin(HttpServletRequest req, Model model)
	{

		return "register";
	}


}
