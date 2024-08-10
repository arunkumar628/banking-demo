package com.spring.bank_project.service;

import com.spring.bank_project.Exceptions.InsufficientBalanceException;
import com.spring.bank_project.Exceptions.InvalidInputException;
import com.spring.bank_project.Exceptions.InvalidPasswordException;
import com.spring.bank_project.Exceptions.InvalidUsernameException;

public interface LogicalOperationService 
{
	public void deposite(double amount)throws InvalidInputException;
	 public void withdraw(double amount)throws InvalidInputException,InsufficientBalanceException;
	 public void checkBalance(String username, String password)throws InvalidUsernameException,InvalidPasswordException;
	 public String[] viewDetail(String username, String password)throws InvalidUsernameException,InvalidPasswordException;

}
