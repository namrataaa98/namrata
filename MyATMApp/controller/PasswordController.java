package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import pojo.UserInfo;
import pojo.Users;
import service.LoginService2;
import service.LoginServiceImpl2;

public class PasswordController {
	
	LoginService2 loginService = new LoginServiceImpl2();
	Scanner s = new Scanner(System.in);
	
	public void forgotPasswordController(Users users) {
		
		forgotPasswordMethod(users);
		
	}
	
	
	public void forgotPasswordMethod(Users users) {
		
		
		//function reads file that contains user data for the purpose of validating email 
		loginService.callReadFromFileUsers(users);
		String userID;
		boolean success = true;
		UserInfo loggedin = null;
		String color;
		
		int temp = 1;
		
		do {
		
		System.out.println("Enter User ID: ");
		userID = s.next();
		
		success = currentUser(userID, users);
		
		
		if (success == false){
			System.out.println("Invalid User ID.");
			if (temp < 3) {
				System.out.println("Please try again.");
			} else {
				System.out.println("Quitting...");
			}
			temp++;
	    	
	    }
	    else {
	        //checks if the email entered by users exists in the list and if so, stores the email into the variable 'logged in'
	    	for (int i=0; i<users.getUsersList().size(); i++) {
				if (userID.equals(users.getUsersList().get(i).getEmail())){
					loggedin = users.getUsersList().get(i);
				}
		    }
			
			   break;
	    }
		
		}while (temp <= 3);
		
		if (success == true) {
			System.out.println("Welcome User " + loggedin.getEmail());
			
			do { // loop that runs if the security key entered by the user does not match with the record in the file
			System.out.println("Enter your security key: ");
			color = s.next();
			
			if(color.equals(loggedin.getColor())){
				System.out.println("Change Password: ");
				String password = s.next();
				System.out.println("Re-type password: ");
				String pass2 = s.next();
				
				//updating user password according to the new set password 
				if (password.equals(pass2)) {
					loggedin.setPassword(password);
					updatePassword(loggedin, password, users);
				}
				
			} else {
				System.out.println("The security code you have entered is invalid.");
				System.out.println("Please try again.");
			}
			
			}while(!(color.equals(loggedin.getColor())));
			
			
		}
		
		
		
	}
	
	public boolean currentUser(String loginID, Users users) { //function to validate current user based on user ID 
		boolean success = false;
		
		for(int i=0; i<users.getUsersList().size(); i++) {
				
			if(loginID.equals(users.getUsersList().get(i).getEmail()))
			{
				success = true;
				break;
			}
		}
		return success;
	}
	
	public void updatePassword(UserInfo logInfo, String password, Users users) { //function to update new user password into file 
		
		FileWriter fw;
		BufferedWriter bw;
	
		UserInfo user = new UserInfo(logInfo.getEmail(), password, logInfo.getColor(), logInfo.getBankAmount());
		users.getUsersList().add(user);
		
		try {
			fw = new FileWriter("UsersNew.csv", true);
			bw = new BufferedWriter(fw);
			
			bw.write(user.toString() + "\n");
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();

		
	 }
	}
	
	
	

}
