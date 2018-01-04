package com.fdmgroup.issuetracker.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fdmgroup.issuetracker.model.impl.Department;
import com.fdmgroup.issuetracker.model.impl.Issue;
import com.fdmgroup.issuetracker.model.impl.Role;
import com.fdmgroup.issuetracker.model.impl.User;

public class Client {

	private static final String PERSISTENCE_UNIT_NAME = "IssueTracker";
	
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}
	
	public static void main(String[] args) {
		
//		User trainee = new User();
//		Department java = new Department();
//		java.setDepartmentName("java");
//		trainee.setDepartment(java);
//		trainee.setEmail("haha@haha");
//		trainee.setUsername("usernamehere223");
//		trainee.setPassword("passwordhere");
//		addUser(trainee);
//		System.out.println("Done adding User");
//		
//		Role admin = new Role();
//		admin.setDeptAdmin();
//		trainee.setRole(admin);
//		updateUser(trainee);
		
//		addRole(admin);
		User user = getUser("usernamehere223");
		System.out.println(user.getRole().getRoleName());
	}
	
	
	public static boolean updateUser(User user) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User foundUser = getUser(user.getUsername());
		try {
			if (foundUser != null) {
				et.begin();
				User modifyUser = em.find(User.class, foundUser.getUserId());
				modifyUser.setDepartment(user.getDepartment());
				modifyUser.setUsername(user.getUsername());
				modifyUser.setPassword(user.getPassword());
				modifyUser.setEmail(user.getEmail());
				modifyUser.setRole(user.getRole());
				et.commit();
				return true;
			}
		} finally {
			em.close();
		}
		return false;
	}
	
	public static boolean addUser(User user) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User validUser = getUser(user.getUsername());
		if (validUser != null) {
			return false;
		}
		Department dept = getDepartment(user.getDepartment().getDepartmentName());
		if(dept != null)
		{
			user.setDepartment(dept);
		}
		try {
			et.begin();
			em.merge(user);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	public static User getUser(String username) {
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByName", User.class);
		User user = null;
		try {
			user = query.setParameter("username", username).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public static Department getDepartment(String username) {
		TypedQuery<Department> query = getEntityManager().createNamedQuery("Department.findByName", Department.class);
		Department department= null;
		try {
			department = query.setParameter("dept_name", username).getSingleResult();
			return department;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public static boolean addRole(Role role) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(role);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}

}
