package com.fdmgroup.issuetracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;

@Controller
public class UsersController {
	
	@RequestMapping(value = "/listusers")
	public String listUsers(Model model, HttpServletRequest req){
		
		ApplicationContext ctx = (ApplicationContext) req.getSession().getAttribute("ctx");
//		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
		
		List<User> userList = userDAO.listUsers();
		
		model.addAttribute("users",userList );
		
		return "listusers";
	}
	
	


}
