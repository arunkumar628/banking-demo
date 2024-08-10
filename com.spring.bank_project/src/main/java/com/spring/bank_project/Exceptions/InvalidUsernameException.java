package com.spring.bank_project.Exceptions;
public class InvalidUsernameException extends Exception {

	public InvalidUsernameException() {
		super();
	}

	public InvalidUsernameException(String message) {
		super(message);
		
	}	
}
