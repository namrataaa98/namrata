package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import dao.LoginDAO2;
import dao.LoginDAOImpl2;
import pojo.UserInfo;
import pojo.Users;
import service.LoginService2;
import service.LoginServiceImpl2;



public class LoginController2 {
	//List<UserInfo> usersList = new ArrayList<UserInfo>();
	//Users users = new Users();
	LoginService2 loginService = new LoginServiceImpl2();
	Scanner s = new Scanner(System.in);
	
	public void userLoginController(Users users)
	{
		loginUserInput(users);
	}
	
	void loginUserInput(Users users)
	{
		
		String loginID, loginPw;
		boolean success = true;
		UserInfo loggedin = null;
		
		//loginService.readFromFileUsers(users);
		loginService.callReadFromFileUsers(users);
		
		//LoginDAO2 loginDAO = new LoginDAOImpl2();
		
		System.out.println(users.getUsersList());
					
		
		int temp = 1;
		
		do {
	    System.out.println("Username: ");
	    loginID = s.nextLine();
	    System.out.println("Password: ");
	    loginPw = s.nextLine();
	   
	    
	    success = loginService.callUserLoggedIn(loginID, loginPw, users);
	    
	   
		if (success == false){
			System.out.println("The username or password you have entered is incorrect.");
			if (temp < 3) {
				System.out.println("Please try again.");
			} else {
				System.out.println("Quitting...");
			}
			temp++;
	    	
	    }
	    else {
	    
	    	for (int i=0; i<users.getUsersList().size(); i++) {
				if (loginID.equals(users.getUsersList().get(i).getEmail())){
					loggedin = users.getUsersList().get(i);
					
				}
		    }
			
			   break;
	    }
		
		}while (temp <= 3);
		
		if (success == true) {
			System.out.println("Welcome User " + loggedin.getEmail());
			loginService.callPrintBankLoginMenu(loggedin, users);
			
		}
		
	}

	
	

}
