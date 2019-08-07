package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import pojo.UserInfo;
import pojo.Users;
import service.LoginServiceImpl2;
import service.RegisterService;
import service.RegisterServiceImpl;

public class RegisterController {
	
	LoginServiceImpl2 loginService;
	UserInfo user; 
	Scanner s = new Scanner(System.in);
	Users users = new Users();
	RegisterService registerService;
	PasswordController passwordController = new PasswordController();
	
	public void userRegController()
	{
		mainMenu();
		//regUserInput();
	}
	
	public void mainMenu() {
		
		int choice = 0;
		
		while(true) 
		{
			try 
			{
				Message();
				choice = s.nextInt();
				mainUserInput(choice, users);
			} 
			catch (Exception e) 
			{
				System.out.println("Invalid input, try again");
				s.next(); 
				continue;  
			}
			break;
		}
	}
	
	
	public void mainUserInput(int choice, Users users)
	{
		LoginController2 loginController = new LoginController2();
		try 
		{
			switch(choice)
			{
			case 1 : regUserInput();
					break;
			case 2 : loginController.userLoginController(users);
					break;
			case 3 : passwordController.forgotPasswordController(users);
					break;
			case 4 : System.out.println("Exiting..");
			         System.exit(0);
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
		registerService = new RegisterServiceImpl();
		
		String email, password = "", color = "";
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("Enter email");
		email = sc.next();
		
		if(registerService.callValidateEmail(email) == true) 
		{
	
			do {
				System.out.println("Enter password:");
				password = sc.next();
				System.out.println("Re-type password: ");
				String pass2 = sc.next();
			if (registerService.callValidatePassword(password, pass2)== true) {
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
		
		System.out.println("Registration successful");
		//System.out.println(users.getUsersList());
		
		mainMenu();
		
	}
	


}
