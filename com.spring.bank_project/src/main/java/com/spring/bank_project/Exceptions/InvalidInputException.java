package com.spring.bank_project.Exceptions;


public class InvalidInputException extends Exception {

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message) {
		super(message);
		
	}	
}