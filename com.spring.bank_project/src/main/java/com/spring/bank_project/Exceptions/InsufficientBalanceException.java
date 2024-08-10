package com.spring.bank_project.Exceptions;

public class InsufficientBalanceException extends Exception 
{

	public InsufficientBalanceException() 
	{
		super();
	}

	public InsufficientBalanceException(String message) {
		super(message);
		
	}
	
}
