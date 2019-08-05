package ATMApp;

import java.util.Scanner;

public class UserHomePage 
{
	UserInfo refUser = new UserInfo();
	String email,password,color;
	Scanner s = new Scanner(System.in);
	void choiceOne(MessagePrint msg) //Registeration Page
	{
		System.out.println("Enter email address : ");
		email = s.next();
		
		
		if(UserInfo.getDefaultEmail().equalsIgnoreCase(email))
		{
			
			do
			{
				System.out.println("email already exists!!");
				System.out.println("Enter email address again : ");
				email = s.next();
				refUser.setEmail(email);
			}
		     while(refUser.getEmail().equals(email));
		}
		
		else
		{
			refUser.setEmail(email);
		}
		

		
		System.out.println("Enter Password : ");
		password = s.next();
		System.out.println("Re-type Password : ");
		String tempPassword = s.next();
		
		if(!(tempPassword.equals(password)))
		{
			do
			{
				System.out.println("Password doesn't match!!");
				System.out.println("Re-type Password : ");
				tempPassword = s.next();
				refUser.setPassword(password);
				
			}
			while(!(tempPassword.equals(password)));
			
		}
		
		else
		{
			refUser.setPassword(password);
		}
		
		System.out.println("What is your favourite color ? ");
		color = s.next();
		System.out.println(color+" is your security key, in case if you forget your password. ");
		refUser.setColor(color);
		
		System.out.println(" ");
		System.out.println("Registration Successful!!");
		System.out.println("\n");
		HomePage.TryCatch();
	}
	
	void choiceTwo(MessagePrint msg) //Login Page
	{
		System.out.println("Enter User ID : ");
		email = s.next();
		
		if(!(email.equals(refUser.getEmail())))
		{
			System.out.println("No such email found, please register!");
			HomePage.TryCatch();
		}
		
		
			System.out.println("Enter Password : ");
			String pass = s.next();
			System.out.println(refUser.getEmail());
			
			if(!(pass.equals(refUser.getPassword())))
					{
						do
						{
							System.out.println("Wrong Password input!");
							System.out.println("Enter Password again : ");
							pass = s.next();
							
						}while(!(pass.equals(refUser.getPassword())));
						
					}
			
			System.out.println("Login Suceessful!");
			msg.message2();
		
	}
	
	void choiceThree(MessagePrint msg) //Forget Password
	{
		System.out.println("Emter Your ID : ");
		String tempID = s.next();
		if(!(refUser.getEmail().equalsIgnoreCase(tempID)))
		{
			System.out.println("No such ID found!");
			HomePage.TryCatch();
		}
		
		System.out.println("Enter your security key :");
		String tempSecurity = s.next();
		if(!(refUser.getColor().equalsIgnoreCase(tempSecurity)))
		{
			System.out.println("Wrong Security Password, please try again !");
			HomePage.TryCatch();
		}
		
		System.out.println("Enter new password : ");
		String tempNewPass = s.next();
		System.out.println("Retype Password :");
		String tempNewPass2 = s.next();
		
		if(!(tempNewPass.equals(tempNewPass2)))
		{
			System.out.println("Password doesn't match!");
			HomePage.TryCatch();
		}
		
		System.out.println("What is your favourite colour? ");
		color = s.next();
		System.out.println(color+" is your security key, in case if you forget your password. ");
		refUser.setColor(color);
		
		System.out.println("\n Your password has been reset successfully.");
		HomePage.TryCatch();
	}
	
	void choiceFour(MessagePrint msg) //Logout(Exit)
	{
		System.out.println("Logout Successfully!!! \n");
		
	}
	
	
	
}
