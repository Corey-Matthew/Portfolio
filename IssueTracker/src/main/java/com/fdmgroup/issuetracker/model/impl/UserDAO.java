package com.fdmgroup.issuetracker.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserDAO{
	private EntityManagerFactory factory;
	private static final String PERSISTENCE_UNIT_NAME = "IssueTracker";
	
	public UserDAO(){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	public EntityManager getEntityManager(){		
		return factory.createEntityManager();	
	}
	
	public User getUser(String username){
		User use;
		TypedQuery<User> type = getEntityManager().createNamedQuery("User.findByName", User.class);
		use = type.setParameter("username",username).getSingleResult();
				
		return use;
	}
	public List<User> listUsers(){
		TypedQuery<User> type = getEntityManager().createNamedQuery("User.findAll", User.class);
		return type.getResultList();
	}
	public void updateUser(){
		
	}
}
