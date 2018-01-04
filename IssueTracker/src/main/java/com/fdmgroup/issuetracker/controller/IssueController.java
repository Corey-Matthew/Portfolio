package com.fdmgroup.issuetracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.issuetracker.model.impl.Issue;
import com.fdmgroup.issuetracker.model.impl.IssueDAO;
import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;

@Controller
public class IssueController {

	private ApplicationContext ctx;
	private UserDAO userDAO;
	private IssueDAO issueDAO;

	@RequestMapping(value = "/issues")
	public String listIssues(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		User user = (User) session.getAttribute("user");
		if (user != null) {
			List<Issue> issues = issueDAO.listByUser(user.getUserId());
			model.addAttribute("issues", issues);
		}
		return "issues";
	}

	@RequestMapping(value = "/addIssue")
	public String addIssue(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		Issue issue = (Issue) ctx.getBean("newIssue");
		model.addAttribute("issue", issue);
		return "addIssue";
	}

	@RequestMapping(value = "/addIssueProc, method = RequestMethod.POST")
	public String addIssueProc(Model model, @ModelAttribute("issue") Issue issue, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		User sessionUser = (User) session.getAttribute("user");
		issue.setSubmittedBy(sessionUser.getUserId());
		boolean addBool = issueDAO.addIssue(issue);
		if (addBool) {
			model.addAttribute("issueAdded", true);
			return "issues";
		} else {
			model.addAttribute("addIssueFailed", true);
			return "addIssue";
		}
	}

}
