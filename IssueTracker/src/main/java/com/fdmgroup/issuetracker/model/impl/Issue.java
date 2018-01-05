package com.fdmgroup.issuetracker.model.impl;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Issue")
@NamedQueries({
@NamedQuery(name = "Issue.findAll", query = "Select i from Issue i"),
@NamedQuery(name = "Issue.listDepts", query = "Select i from Issue i where i.assignedTo = :assignedTo"),
@NamedQuery(name = "Issue.listUserIssues", query = "Select i from Issue i where i.submittedBy = :submittedBy")
})
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
	
	@Column(name = "assigned_to")
	private int assignedTo;

	@Column(name = "submitted_by")
	private int submittedBy;
	
	
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

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(int submittedBy) {
		this.submittedBy = submittedBy;
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
