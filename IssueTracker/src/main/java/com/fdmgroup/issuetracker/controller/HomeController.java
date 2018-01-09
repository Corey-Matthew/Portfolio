package com.fdmgroup.issuetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	/**
	 * This would return to the home page
	 * @return
	 */
	@RequestMapping(value="/")
	public String goHome(){
		return "index";
	}
	
}
