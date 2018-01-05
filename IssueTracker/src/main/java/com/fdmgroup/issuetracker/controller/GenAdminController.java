package com.fdmgroup.issuetracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.issuetracker.model.impl.Issue;
import com.fdmgroup.issuetracker.model.impl.IssueDAO;
import com.fdmgroup.issuetracker.model.impl.Status;
import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;
import com.fdmgroup.issuetracker.utils.Validation;


public class GenAdminController {

	private ApplicationContext ctx;
	private IssueDAO issueDAO;
	
	@RequestMapping(value="/assign")
	public String assignIssue(HttpServletRequest req, Model model, @RequestParam int issueId, @RequestParam int assignedTo,@RequestParam Status status){
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		issueDAO = (IssueDAO) ctx.getBean("issueDAO");
		List<Issue> issues = (List<Issue>) session.getAttribute("issues");
		
		
		if(Validation.compare(issueDAO, issueId)){
			for(Issue issue:issues){
				if(issue.getIssueId() == issueId){
					issue.setAssignedTo(assignedTo);
					issue.setStatus(status);
				}
			}
			
			
			
		}
		else{
			model.addAttribute("not found", true);
		}
		return "issues";
	}
}
