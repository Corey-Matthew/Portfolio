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

import com.fdmgroup.issuetracker.model.impl.Department;
import com.fdmgroup.issuetracker.model.impl.Issue;
import com.fdmgroup.issuetracker.model.impl.IssueDAO;
import com.fdmgroup.issuetracker.model.impl.IssueUpdate;
import com.fdmgroup.issuetracker.model.impl.Role;
import com.fdmgroup.issuetracker.model.impl.Status;
import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;
import com.fdmgroup.issuetracker.utils.Validation;

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
				List<Department> depts = issueDAO.listDepts();
				model.addAttribute("depts", depts);
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
		return "addIssue";
	}

	@RequestMapping(value = "/addIssueProc", method = RequestMethod.POST)
	public String addIssueMethod(Model model, HttpServletRequest req, @RequestParam(value = "title") String title,
			@RequestParam(value = "userDescription") String userDescription) {
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
			model.addAttribute("issueAdded", true);
			return listIssues(model, req);
		} else {
			model.addAttribute("addIssueFailed", true);
			return "addIssue";
		}
	}

	@RequestMapping(value="/viewissue")
	public String listUsers(@RequestParam int issueId, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		Issue issue = issueDAO.getIssue(issueId);
		String deptName = issueDAO.getDepartmentById(issue.getAssignedTo()).getDepartmentName();
		model.addAttribute("issue", issue);
		model.addAttribute("deptName", deptName);
		return "issue";
	}
	
	@RequestMapping(value = "/assign", method = RequestMethod.POST)
	public String assignIssue(HttpServletRequest req, Model model, @RequestParam int issueId,
			@RequestParam int deptId) {

		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		

		if (Validation.compare(issueDAO, issueId)) {
			Issue issue = issueDAO.getIssue(issueId);
			issue.setAssignedTo(deptId);
			issue.setStatus(Status.ASSIGNED);
			issueDAO.updateIssue(issue);
			

		} else {
			model.addAttribute("notfound", true);
			return listIssues(model, req);
		}
		return listIssues(model, req);
	}

	@RequestMapping(value = "/viewUserIssues")
	public String viewUserIssues(HttpServletRequest req, Model model, @RequestParam int userId) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		List<Issue> issues = issueDAO.listByUser(userId);
		model.addAttribute("issues", issues);
		return "viewUserIssues";
	}

	@RequestMapping(value="addIssueUpdate", method = RequestMethod.POST)
	public String addIssueUpdate(@RequestParam int issueId, @RequestParam String issueComment,
							HttpServletRequest req, Model model){
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		issueDAO = (IssueDAO) ctx.getBean("IssueDAO");
		Issue issue = issueDAO.getIssue(issueId);
		List<IssueUpdate> issueUpdates = issue.getIssueUpdates();
		IssueUpdate issueUpdate = (IssueUpdate) ctx.getBean("newIssueUpdate");
		issueUpdate.setIssue(issue);
		issueUpdate.setUpdateComment(issueComment);
		issueUpdate.setUpdateDate(new Date());
		issueUpdates.add(issueUpdate);
		issueDAO.updateIssue(issue);
		return listUsers(issueId, model, req);
	}

}
