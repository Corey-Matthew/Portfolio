package com.fdmgroup.userregistrationproject;

public class UserRegistrationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5070706384561035988L;

	public UserRegistrationException() {
		super();
		
	}

	public UserRegistrationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserRegistrationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserRegistrationException(Throwable cause) {
		super(cause);
		
	}

	public UserRegistrationException(String message){
		super(message);
	}
}
