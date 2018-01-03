package com.fdmgroup.issuetracker.model.impl;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class UserRole {

	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	@OneToOne(cascade=CascadeType.ALL)
	private Role role;
}
