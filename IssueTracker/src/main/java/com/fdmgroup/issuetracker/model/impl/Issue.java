package com.fdmgroup.issuetracker.model.impl;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Issue")
public class Issue {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="issue_id")
	private int issueId;
	private String title;
	@Column(name ="user_description")
	private String userDescription;
	@Column(name = "admin_comment")
	private String adminComment;
	
	@OneToOne
	@Column(name = "assigned_to")
	private User assignedTo;
	
	@OneToOne
	@Column(name = "submitted_by")
	private User sumbmittedBy;
	
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.UNASSIGNED;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_Submitted")
	private Date dateSubmitted;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_Resolved")
	private Date dateResolved;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public User getSumbmittedBy() {
		return sumbmittedBy;
	}

	public void setSumbmittedBy(User sumbmittedBy) {
		this.sumbmittedBy = sumbmittedBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted; 
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}
	
	
}
