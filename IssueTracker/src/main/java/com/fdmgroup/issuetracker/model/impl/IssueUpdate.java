package com.fdmgroup.issuetracker.model.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IssueUpdates")
public class IssueUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Issue_Update_Id")
	private int issueUpdateId;
	
	@ManyToOne
	@JoinColumn(name="issue_id")
	private Issue issue;
	
	@Column(name = "submitted_by")
	private int submittedBy;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="update_comment")
	private String updateComment;

	public int getIssueUpdateId() {
		return issueUpdateId;
	}

	public void setIssueUpdateId(int issueUpdateId) {
		this.issueUpdateId = issueUpdateId;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public int getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(int submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateComment() {
		return updateComment;
	}

	public void setUpdateComment(String updateComment) {
		this.updateComment = updateComment;
	}


}
