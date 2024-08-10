package com.spring.bank_project.pojo;


public class UserNameAndPwd 
{
	private String UserName;
	  private String password;
	  
		
		  public UserNameAndPwd() {
		  
		  }
		 
	

	public UserNameAndPwd(String userName, String password) {
		super();
		this.UserName = userName;
		this.password = password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return ("\n"+"USERNAME        :" + UserName +
				"\n"+"[PASSWORD       :" + password );
	}
	


}
