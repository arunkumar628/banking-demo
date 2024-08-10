package com.spring.bank_project.serviceImpl;

import com.spring.bank_project.Exceptions.InsufficientBalanceException;
import com.spring.bank_project.Exceptions.InvalidInputException;
import com.spring.bank_project.Exceptions.InvalidPasswordException;
import com.spring.bank_project.Exceptions.InvalidUsernameException;
import com.spring.bank_project.pojo.UserInfo;
import com.spring.bank_project.pojo.UserNameAndPwd;
import com.spring.bank_project.service.LogicalOperationService;

public class LogicalOperationServiceImpl implements LogicalOperationService
{
	
	private UserInfo info;
	private UserNameAndPwd identity;
	
	public LogicalOperationServiceImpl(UserInfo info, UserNameAndPwd identity) {
		super();
		this.info = info;
		this.identity = identity;
	}
	
	

	public UserInfo getInfo() {
		return info;
	}



	public void setInfo(UserInfo info) {
		this.info = info;
	}



	public UserNameAndPwd getIdentity() {
		return identity;
	}



	public void setIdentity(UserNameAndPwd identity) {
		this.identity = identity;
	}


	

	@Override
	public String toString() {
		return "LogicalOperationServiceImpl [info=" + info + ", identity=" + identity + "]";
	}



	@Override
	public void deposite(double amount) throws InvalidInputException {
		if (amount <= 0) {
			throw new InvalidInputException("can't able to deposite zero or -ve amount create your own bank for this");
		} else {
			info.setBalance(info.getBalance() + amount);
			System.out.println("Money deposited succesfully!!!!!!!");
		}

	}

	@Override
	public void withdraw(double amount) throws InvalidInputException, InsufficientBalanceException {
		if (amount <= 0) {
			throw new InvalidInputException(
					"\"can't able to withdraw zero or -ve amount create your own bank for this");
		}
		
		else if (amount > info.getBalance()) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
		else if((info.getBalance()-amount)<1000)
		{
			throw new InsufficientBalanceException("Maintain minimum balance of RS.1000"+"\n"+"You can withdraw only :"+(info.getBalance()-1000));
		}
		else {
			info.setBalance(info.getBalance() - amount);
			System.out.println("Withdraw Completed!!!!!!!");
		}

	}

	@Override
	public void checkBalance(String username, String password)
			throws InvalidUsernameException, InvalidPasswordException {
		if (identity.getUserName().equalsIgnoreCase(username) && identity.getPassword().equals(password)) {
			System.out.println("------------------------------");
			System.out.println("THE CURRENT BALANCE  :" + info.getBalance());
			System.out.println("------------------------------");
		} else if (!identity.getUserName().equalsIgnoreCase(username)) {
			throw new InvalidUsernameException("wrong username");
		} else if (!identity.getPassword().equals(password)) {
			throw new InvalidPasswordException("Wrong password");
		}

	}

	
	@Override
	public String[] viewDetail(String username, String password)
			throws InvalidUsernameException, InvalidPasswordException {
		String info1=null;
		String identity1=null;
		if (identity.getUserName().equalsIgnoreCase(username) && identity.getPassword().equals(password)) 
		{
			 info1=info.toString();
		     identity1= identity.toString();
			
		} else if (!identity.getUserName().equalsIgnoreCase(username)) {
			throw new InvalidUsernameException("wrong username");
		} else if (!identity.getPassword().equals(password)) {
			throw new InvalidPasswordException("Wrong password");
		}
		
		 return new String[ ] {info1 ,identity1};
	}
	

}
