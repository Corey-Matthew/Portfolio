package com.fdmgroup.issuetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	/**
	 * Method that directs to the error page 
	 * @return "error" (error.jsp)
	 */
	@RequestMapping(value="/error")
	public String goToError(){
		return "error";
	}	

}
