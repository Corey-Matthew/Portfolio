package com.fdmgroup.issuetracker.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.issuetracker.model.impl.Department;
import com.fdmgroup.issuetracker.model.impl.Issue;
import com.fdmgroup.issuetracker.model.impl.IssueDAO;
import com.fdmgroup.issuetracker.model.impl.Role;
import com.fdmgroup.issuetracker.model.impl.User;
import com.fdmgroup.issuetracker.model.impl.UserDAO;

public class Client {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		UserDAO userDAO = (UserDAO) ctx.getBean("UserDAO");
		User trainee = new User();
		Department java = new Department();
		java.setDepartmentName("java");
		trainee.setDepartment(java);
		trainee.setEmail("haha@haha");
		trainee.setUsername("admin1");
		trainee.setPassword("adminpw");
		Role admin = new Role();
		admin.setAdmin();
		trainee.setRole(admin);
		userDAO.addUser(trainee);
		System.out.println("Done adding User");
//		System.out.println("User role name: " + trainee.getRole().getRoleName());
//		User user = getUser("admin");
//		Issue issue = (Issue) ctx.getBean("newIssue");
//		issue.setTitle("different one");
//		issue.setUserDescription("hello");
//		issue.setSubmittedBy(user.getUserId());
//		issue.setDateSubmitted(new Date());
//		IssueDAO issueDAO = new IssueDAO();
//		issueDAO.addIssue(issue);
//		System.out.print("complete");	
//		System.out.println(issue.getIssueId());
		//We should give the issue id to the person who submits it 
		// like in a tracking system
//		IssueDAO issueDAO = new IssueDAO();
		// manually find the issue id related to the issue
//		Issue issue = getIssue(4);
//		System.out.println(issue);
//		issue.setStatus(Status.IN_PROCESS);
//		IssueUpdate issueUpdate = new IssueUpdate();
//		issueUpdate.setIssue(issue);
//		issueUpdate.setUpdateComment("helloitsme");
//		issueUpdate.setUpdateDate(new Date());
//		List<IssueUpdate> listIssueUpdates = issue.getIssueUpdates();
//		listIssueUpdates.add(issueUpdate);
//		System.out.println("before update issue");
//		issueDAO.updateIssue(issue);
//		System.out.println("finished update");
		((ConfigurableApplicationContext)ctx).close();
	}

}
