
package com.fdmgroup.issuetracker.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.context.ConfigurableApplicationContext;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import com.fdmgroup.issuetracker.model.IUserDAO;

/**
 * Implements UserDAO interfaces to manipulate User table in the database
 *
 */
public class UserDAO  {

	private static final String PERSISTENCE_UNIT_NAME = "IssueTracker";
//	static Logger myLogger = Logger.getLogger("myLogger");
	
	private static EntityManagerFactory factory;

	public UserDAO(){		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);	
	}

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}

	public boolean addUser(User user) {
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
		Role role = getRole(user.getRole().getRoleName());
		if(role != null)
		{
			user.setRole(role);
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
	
	/**
	 * Retrieves a user with the passed in parameter of username
	 */
	public User getUser(String username) {
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByName", User.class);
		User user = null;
		try {
			user = query.setParameter("username", username).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/**
	 * Removes a user with the passed in parameter of username
	 */
	public boolean removeUser(String username) {
		
		EntityManager em = factory.createEntityManager();
		User user = em.find(User.class, username);
		
		try {
			if (user != null) {
					
				em.getTransaction().begin();
				em.remove(user);
				em.getTransaction().commit();
				return true;
			}
		} finally {
			em.close();
		} 
		return false;
	}

	/**
	 * Update a user if the username exist in the database
	 */
	public boolean updateUser(User user) {
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

	/**
	 * Returns a list of users.
	 * SQL query is found in the User class in NamedQueries
	 */
	public List<User> listUsers() {
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	public List<User> listDeptAdmin() {
		Role role = getRole(Role.DEPT_ADMIN);
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByRole", User.class);
		return query.setParameter("role", role).getResultList();
	}
	public Department getDepartment(String name) {
		TypedQuery<Department> query = getEntityManager().createNamedQuery("Department.findByName", Department.class);
		Department department= null;
		try {
			department = query.setParameter("dept_name", name).getSingleResult();
			return department;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Role getRole(String name){
		TypedQuery<Role> query = getEntityManager().createNamedQuery("Role.findByName", Role.class);
		Role role= null;
		try {
			role = query.setParameter("name", name).getSingleResult();
			return role;
		} catch (NoResultException e) {
			return null;
		}
	}
	public boolean addRole(Role role) {
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
	
	

}
