package com.fdmgroup.issuetracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.issuetracker.model.impl.Department;
import com.fdmgroup.issuetracker.model.impl.Role;
import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;

//we are creating new bean for department and role => new user requires those 
//if we do that twice, then the SQL fails, because dept and role already exist
//we need to pass reference, but do we need DAO for role and dept for that?

/**
 * RegisterController for registering...
 *
 */
@Controller
public class RegisterController {
	
	/**
	 * Returns to Register page
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register")
	public String goToRegister(HttpServletRequest req, Model model)	{

		return "register";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String confirmedPassword, @RequestParam String userType, @RequestParam String department) {
		
		ApplicationContext ac = (ApplicationContext) request.getSession().getServletContext().getAttribute("ctx");
		
		UserDAO dao = (UserDAO) ac.getBean("UserDAO");

		if (username.trim().equals("")
				|| email.trim().equals("")
				|| password.trim().equals("")
				|| confirmedPassword.trim().equals(""))
		{
			model.addAttribute("emptyField", true);
			return "register";
		}
		
		User user = dao.getUser(username);
		
		if (user != null) {
			model.addAttribute("userexist", true);
			return "register";
		} 
		
		if (!password.equals(confirmedPassword)) {
			model.addAttribute("passwordNoMatch", true);
			return "register";
		}
		
		User newUser = (User) ac.getBean("newUser");
		Role newRole = (Role) ac.getBean("newRole");
		Department newDept = (Department) ac.getBean("newDept");
		
		if (userType.equals("user")) {
			newRole.setUser();
		} else if (userType.equals("admin")) {
			newRole.setAdmin();
			
		} else if (userType.equals("departmentAdmin")) {
			newRole.setDeptAdmin();
		}
		
		newDept.setDepartmentName(department);
		
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setRole(newRole);
		newUser.setDepartment(newDept);
		
		dao.addUser(newUser);
		model.addAttribute("registered", true);
		return ("login");
				
	}
}
