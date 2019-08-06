package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import pojo.UserInfo;
import service.LoginServiceImpl2;

public class RegisterController {
	
	LoginServiceImpl2 loginService; // LoginService is an interface
	UserInfo user; 
	Scanner s = new Scanner(System.in);
	List<UserInfo> usersList = new ArrayList<UserInfo>();
	
	public void userRegController()
	{
		mainMenu();
		//regUserInput();
	}
	
	public void mainMenu() {
		
		int choice = 0;
		
		while(true) //true means continue forever till there's a break
		{
			try 
			{
				Message();
				choice = s.nextInt();
				mainUserInput(choice);
			} 
			catch (Exception e) 
			{
				System.out.println("Invalid input, try again");
				s.next(); //reset the input
				continue; //When exception is found, break is automatic 
			}
			break;
		}
	}
	
	
	public void mainUserInput(int choice)
	{
		LoginController2 loginController = new LoginController2();
		try 
		{
			switch(choice)
			{
			case 1 : regUserInput();
					break;
			case 2 : loginController.userLoginController();
					break;
			case 3 : System.out.println("Forgot Password");
					break;
			case 4 : System.out.println("Testing la");
			        break;
			default: System.out.println("Wrong input, try again : \n");
			         
			         break;
			}
		} 
			
		catch(Exception e)
		{
			System.out.println("Wrong input, try again : \n");
		}
		
	}
	
	
	
	public void Message() {
		
		System.out.println("User Home Page : ");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Forget Password");
		System.out.println("4. Logout(exit) ");
		System.out.println(" ");
		System.out.println("Enter Your Choice : ");
		
	}
	
	void regUserInput()
	{
		boolean success = false;
		boolean passwordSuccess = false;
		FileWriter fw;
		BufferedWriter bw;
		String bankAmount = "0.0";
		
		String email, password = "", color = "";
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("Enter email");
		email = sc.next();
		
		if(validateEmail(email) == true) 
		{
	
			do {
				System.out.println("Enter password:");
				password = sc.next();
				System.out.println("Re-type password: ");
				String pass2 = sc.next();
			if (validatePassword(password, pass2) == true) {
				success = true;
				break;
			}
			}while(passwordSuccess == false);
			
			System.out.println("What is your favourite color?");
			color = sc.next();
			System.out.println(color + " is your security code in case you forget your password.");
			
		}
		
		} while (success == false);
		
		UserInfo user = new UserInfo(email, password, color, bankAmount);
		usersList.add(user);
		
		try {
			fw = new FileWriter("User2.csv", true);
			bw = new BufferedWriter(fw);
			
			bw.write(user.toString() + "\n");
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //opens file in append mode
		
		
		
		System.out.println("Registration successful");
		
		
		
		System.out.println(usersList);
		
		mainMenu();
		
	}
	
	public static boolean validateEmail(String email) {
		
		boolean status;
		
		if(email.equals("xyz@gmail.com"))
		{
			System.out.println("Email already exists.");
			status = false;
		}
		else
		{
			
			status = true;
		}
		
		return status;
		
	}
	
	public static boolean validatePassword(String password, String pass2) {
		
		boolean status;
		
		if(!(password.equals(pass2)))
		{
			System.out.println("Passwords do not match");
			status = false;
			//success = false;
		}
		else
		{
			
			status = true;
		}
		
		return status;
		
		
	}
	

}
