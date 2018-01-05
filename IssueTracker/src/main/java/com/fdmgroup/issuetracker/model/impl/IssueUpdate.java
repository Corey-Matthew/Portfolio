package com.fdmgroup.issuetracker.model.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IssueUpdate")
public class IssueUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "update_id")
	private int update_id;
	private String dateOfComment;
	private String commentAuthor;
	private String comment;
	//@ManyToOne(mappedBy="issueupdate",cascade=CascadeType.ALL)
	private Issue issue;
	public IssueUpdate() {
		super();
	}

	public IssueUpdate(String dateOfComment, String commentAuthor, String comment) {
		super();
		this.dateOfComment = dateOfComment;
		this.commentAuthor = commentAuthor;
		this.comment = comment;
	}

}
