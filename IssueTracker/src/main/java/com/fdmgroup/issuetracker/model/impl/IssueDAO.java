package com.fdmgroup.issuetracker.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class IssueDAO {

	private static final String PERSISTENCE_UNIT_NAME = "IssueTracker";

	private static EntityManagerFactory factory;
	private static UserDAO userDAO;

	public IssueDAO() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	}

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public boolean addIssue(Issue issue) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(issue);
			et.commit();
		} catch (Exception e) {
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public Issue getIssue(int id) {
		EntityManager em = getEntityManager();
		Issue issue = em.find(Issue.class, id);
		em.close();
		return issue;
	}

	public List<Issue> listAll() {
		TypedQuery<Issue> query = getEntityManager().createNamedQuery("Issue.findAll", Issue.class);
		return query.getResultList();
		// check that it is admin accessing this
	}

	public List<Issue> listByDept(int deptId) {
		TypedQuery<Issue> query = getEntityManager().createNamedQuery("Issue.listDepts", Issue.class);
		return query.setParameter("assignedTo", deptId).getResultList();
		// access by assigned to
	}

	public List<Issue> listByUser(int userId) {
		TypedQuery<Issue> query = getEntityManager().createNamedQuery("Issue.listUserIssues", Issue.class);
		return query.setParameter("submittedBy", userId).getResultList();
	}

	public boolean updateIssue(Issue issue) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			
			em.merge(issue);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

}
