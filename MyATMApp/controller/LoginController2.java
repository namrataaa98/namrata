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
	List<UserInfo> usersList = new ArrayList<UserInfo>();
	LoginService2 loginService = new LoginServiceImpl2();
	Scanner s = new Scanner(System.in);
	
	public void userLoginController()
	{
		loginUserInput();
	}
	
	void loginUserInput()
	{
		
		String loginID, loginPw;
		boolean success = true;
		UserInfo loggedin = null;
		
		loginService.readFromFileUsers(usersList);
		
		//read from file to compare user logged in ID

//		FileReader fr;
//		BufferedReader br;
//		
//		try {
//			fr = new FileReader("User1.csv");
//			br = new BufferedReader(fr);
//			String var = br.readLine();
//			
//			
//			while(var != null) {
//	
//				String[] record = var.split(",");            
//				
//	           // UserInfo user1 = new UserInfo(record[0], record[1], record[2], Double.value`Of(record[3]));
//				UserInfo user1 = new UserInfo(record[0], record[1], record[2], record[3]);
//	            
//	            usersList.add(user1);
//	           
//	            var = br.readLine();
//			}
//			
//		    br.close();
//		    fr.close();
//		    		    
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//			
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
		//end of read from file to compare user logged in ID		
		
		
		int temp = 1;
		
		do {
	    System.out.println("Username: ");
	    loginID = s.nextLine();
	    System.out.println("Password: ");
	    loginPw = s.nextLine();
	   
	    LoginDAO2 loginDAO = new LoginDAOImpl2(usersList);
	    
	    success = loginDAO.userLoggedIn(loginID, loginPw);
	    
	   
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
	    
	    	for (int i=0; i<usersList.size(); i++) {
				if (loginID.equals(usersList.get(i).getEmail())){
					loggedin = usersList.get(i);
					
				}
		    }
			
			   break;
	    }
		
		}while (temp <= 3);
		
		if (success == true) {
			System.out.println("Welcome User " + loggedin.getEmail());
			loginService.printBankLoginMenu(loggedin);
			
		}
		
	}

	
	

}
