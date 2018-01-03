package com.fdmgroup.issuetracker.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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
		try{
			use = type.setParameter("username",username).getSingleResult();
			return use;
		}catch(NoResultException e){
			return null;
		}
		
	}
	public List<User> listUsers(){
		TypedQuery<User> type = getEntityManager().createNamedQuery("User.findAll", User.class);
		return type.getResultList();
	}
	public boolean updateUser(User use){
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User foundUser = getUser(use.getUsername());
		
		try{
			
			if(foundUser != null){
				User newUser = em.find(User.class, use.getUserId());
				et.begin();
				newUser.setPassword(use.getPassword());
				newUser.setEmail(use.getEmail());
				et.commit();
				return true;
			}
		}finally{
			em.clear();
		}
		return false;
		
	}
}
