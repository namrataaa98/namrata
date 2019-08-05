package ATMApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MessagePrint 
{
	public int choice,rand=0;
	public UserInfo userRef = new UserInfo();
	public ChoiceOption refChoice = new ChoiceOption();
	public Scanner s = new Scanner(System.in);
	
	public void message()

	{
				System.out.println("User Home Page : ");
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Forget Password");
				System.out.println("4. Logout(exit) ");
				System.out.println(" ");
				System.out.println("Enter Your Choice : ");
				
	}
	
	public void message2()
	{
		System.out.println("Type 1 : Check Available Bank Balance ");
		System.out.println("Type 2 : Deposit Amount ");
		System.out.println("Type 3 : Withdraw Amount ");
		choice = s.nextInt();
		userRef.setChoice(choice);
		LoginPage.loginOption();
		
	}
	
	public void wishToContinue()
	{
		String ans;
		System.out.println("Wish to Continue? (y/n) : ");
		ans = s.next();
		if(ans.equalsIgnoreCase("y"))
		{
			MessagePrint.message2();	
		}
		else if(ans.equalsIgnoreCase("n"))
		{
			System.out.println("Thanks for Banking with Us !!!\n");
			HomePage.TryCatch();
		}
		else
		{
			wronginput();
		}
	}
	
	public void wronginput()
	{
		System.out.println("Choice not available, please try again!");
		wishToContinue();
	}
	
	
}
