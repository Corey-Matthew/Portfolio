package com.fdmgroup.issuetracker.controller;

import java.util.Date;
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
import com.fdmgroup.issuetracker.model.impl.Role;
import com.fdmgroup.issuetracker.model.impl.User;

@Controller
public class IssueController {

	private ApplicationContext ctx;
	private IssueDAO issueDAO;

	@RequestMapping(value = "/issues")
	public String listIssues(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		User user = (User) session.getAttribute("user");
		if (user != null) {
			if (user.getRole().getRoleName().equals(Role.ADMIN)) {
				List<Issue> issues = issueDAO.listAll();
				model.addAttribute("issues", issues);
			} else if (user.getRole().getRoleName().equals(Role.DEPT_ADMIN)) {
				List<Issue> issues = issueDAO.listByDept(user.getDepartment().getDepartmentId());
				model.addAttribute("issues", issues);
			} else {
				List<Issue> issues = issueDAO.listByUser(user.getUserId());
				model.addAttribute("issues", issues);
			}
		}
		return "issues";
	}

	@RequestMapping(value = "/addIssue")
	public String addIssue() {
//	public String addIssue(Model model, HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
//		Issue issue = (Issue) ctx.getBean("newIssue");
//		model.addAttribute("issue", issue);
		return "addIssue";
	}

	@RequestMapping(value = "/addIssueProc", method = RequestMethod.POST)
	public String addIssueMethod(Model model, HttpServletRequest req,
			@RequestParam(value="title") String title, 
			@RequestParam(value="userDescription") String userDescription) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		User sessionUser = (User) session.getAttribute("user");
		Issue issue = (Issue) ctx.getBean("newIssue");
		issue.setTitle(title);
		issue.setUserDescription(userDescription);
		issue.setSubmittedBy(sessionUser.getUserId());
		issue.setDateSubmitted(new Date()); 
		boolean addIssueBool = issueDAO.addIssue(issue);
		if (addIssueBool) {
			model.addAttribute("issueAdded",true);
			return listIssues(model, req);
		} else {
			model.addAttribute("addIssueFailed", true);
			return "addIssue";
		}
	}

}
