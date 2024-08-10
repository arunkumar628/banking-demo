package com.spring.bank_project;

import java.awt.desktop.ScreenSleepEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bank_project.Exceptions.InsufficientBalanceException;
import com.spring.bank_project.Exceptions.InvalidInputException;
import com.spring.bank_project.Exceptions.InvalidPasswordException;
import com.spring.bank_project.Exceptions.InvalidUsernameException;
import com.spring.bank_project.pojo.UserInfo;
import com.spring.bank_project.pojo.UserNameAndPwd;
import com.spring.bank_project.serviceImpl.LogicalOperationServiceImpl;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("configu.xml");

		UserInfo info = null;
		UserNameAndPwd identity = null;
		LogicalOperationServiceImpl account = null;
		ArrayList<Double> depositDetails = new ArrayList<>();
		ArrayList<Double> withdrawDetails = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		System.out.println("--- WELCOME ---");

		try
		{
		while (true) {
			

			System.out.println("---------------------------");
			System.out.println("Press 1 for creating the account");
			System.out.println("Press 2 for performing deposit operation");
			System.out.println("Press 3 for performing wihtdraw operation");
			System.out.println("Press 4 for view the balance");
			System.out.println("Press 5 for view the account details ");
			System.out.println("Press 6 for Deposit information");
			System.out.println("Press 7 for withdraw information");
			System.out.println("Press 8 for exit");
			System.out.println("----------------------------");
			
			System.out.println("Enter the option to perform operation");
			int option = sc.nextInt();
			sc.nextLine();
			if (option == 1) {
				if (flag == false) {
					System.out.println("-----------------------------------");
					System.out.println("Enter the Customer name");
					String customer_Name = sc.next();
					System.out.println("Enter the username for account");
					String uname = sc.next();
					System.out.println("Enter the password for account");
					String password = sc.next();
					
					/*
					 * System.out.println("Enter the Customer adhar Number"); String adhar_No =
					 * sc.next(); System.out.println("Enter the Customer mobile Number"); String
					 * mobile_No = sc.next();
					 */
					
					System.out.println("Deposit minimum 1000 to create account");
					
					System.out.println("Enter the balance for creating the account");
					double balance = sc.nextDouble();
					System.out.println("--------------------------------------");
					
					if(balance<1000)
					{
						
						System.err.println("1000 b nahi hai GAREEB");
					}else {
					
					//info = new UserInfo(customer_Name, adhar_No, mobile_No, balance);
					info =(UserInfo) context.getBean("userInfoBean");
					info.setCustomer_Name(customer_Name);
					/*
					 * info.setCustomer_MobileNo(mobile_No); info.setCustomer_adharNo(adhar_No);
					 */
					info.setBalance(balance);
					
					//identity = new UserNameAndPwd(uname, password);
					identity=(UserNameAndPwd) context.getBean("userNameAndPwdBean");
					identity.setUserName(uname);
					identity.setPassword(password);
					
					//account = new LogicalOperationServiceImpl(info, identity);
					account = (LogicalOperationServiceImpl) context.getBean("logicalOperationServiceImplBean");
					account.setInfo(info);
					account.setIdentity(identity);
					flag = true;
					System.out.println("ACCOUNT CREATED!!!!");
					}
				} else {
					System.out.println("You already created the account");
				}
			} else if (option == 2) {
				if (flag == true) {
					try {
					System.out.println("------------------------");
					System.out.println("Enter the amount to be added in the account");
					double amount = sc.nextDouble();
					
						account.deposite(amount);
						depositDetails.add(amount);
					}  catch (InvalidInputException e) {
						System.err.println(e.getMessage());
					}

				} else {
					System.err.println("CREATE THE ACCOUNT");
				}
				System.out.println("------------------------");
			} else if (option == 3) {
				if (flag == true) {
					System.out.println("------------------------");
					System.out.println("Enter the amount to withdraw from the account");
					double amount = sc.nextDouble();
					try {
						account.withdraw(amount);
						withdrawDetails.add(amount);
					} catch (InvalidInputException | InsufficientBalanceException e) {
						System.err.println(e.getMessage());
					}
				} else {
					System.err.println("CREATE THE ACCOUNT");
				}
				System.out.println("------------------------");
			} else if (option == 4) {
				if (flag == true) {
					System.out.println("---------------------------");
					System.out.println("Enter the username to see the balance");
					String uname = sc.next();
					System.out.println("Enter the password to see the balance");
					String password = sc.next();
					try {
						account.checkBalance(uname, password);
					} catch (InvalidUsernameException e) {
						System.err.println(e.getMessage());
					} catch (InvalidPasswordException e) {
						System.err.println(e.getMessage());
					}

				} else {
					System.err.println("CREATE THE ACCOUNT");
				}
			} else if (option == 5) {
				if (flag == true) {
					
					System.out.println("---------------------------");

					System.out.println("Enter the username to see the balance");
					String uname = sc.next();
					System.out.println("Enter the password to see the balance");
					String password = sc.next();
					try {
						String acc[] = account.viewDetail(uname, password);
						System.out.println(Arrays.toString(acc));
						
						Thread.sleep(5000);
						
					} catch (InvalidUsernameException | InvalidPasswordException e) {
						System.err.println(e.getMessage());
					}

				} else {
					System.err.println("CREATE ACCOUNT");
				}
			} else if (option == 6) {
				if (flag == true) {
					System.out.println("------------------------");
					System.out.println("Total deposit information");
					System.out.println("+" + depositDetails);

				} else {
					System.err.println("CREATE THE ACCOUNT");
				}

			} else if (option == 7) {
				if (flag == true) {
					System.out.println("------------------------");
					System.out.println("------------------------");
					System.out.println("Total withdraw information");
					System.out.println("-" + withdrawDetails);

				} else {
					System.err.println("CREATE THE ACCOUNT");
				}

			} else if (option == 8) {
				System.out.println("Thank you!!!!");
				System.exit(1);
			} else {
				System.out.println("Invalid Input");
			}
		}
		}catch(Exception e) {
			
			e.printStackTrace();
		}

	}
	
}
