package com.fdmgroup.issuetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for errors and exceptions
 * @author Knight
 *
 */
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
	/**
	 * Method that directs to exception page
	 * @return "exception" (exception.jsp)
	 */
	@RequestMapping(value="/exception")
	public String goToException(){
		return "exception";
	}	
}
