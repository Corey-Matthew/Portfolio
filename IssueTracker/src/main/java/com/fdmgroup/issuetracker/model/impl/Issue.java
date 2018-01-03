package com.fdmgroup.issuetracker.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Issue")
public class Issue {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int issueId;
	private String title;
	private String userDescription;
	private String adminComment;
	private User assignedTo;
	private User sumbmittedBy;
	
	private Status status = Status.UNASSIGNED;
}
