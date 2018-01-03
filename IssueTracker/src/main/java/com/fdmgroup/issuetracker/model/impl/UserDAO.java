
package com.fdmgroup.issuetracker.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public void addUser(User user) {

		int userId = user.getUserId();
		Department department_id = user.getDepartment();
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();

		EntityManager em = factory.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
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
	 * Removes a user with the passed in parameter of username
	 */

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
				modifyUser.setPassword(user.getPassword());
				modifyUser.setEmail(user.getEmail());
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



}
