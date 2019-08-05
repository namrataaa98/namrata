package ATMApp;

import java.util.Scanner;

public class HomePage 
{
	
	public static void main(String[] args) 
	{	
		TryCatch();
		
	}
	
	public static void TryCatch() {
		int choice = 0;
		UserInfo userRef = new UserInfo();
		Scanner s = new Scanner(System.in);
		MessagePrint msg = new MessagePrint();
		ChoiceOption choiceObj = new ChoiceOption();
		
		while(true) //true means continue forever till there's a break
		{
			try 
			{
				msg.message();
				choice = s.nextInt();
				userRef.setChoice(choice);
				choiceObj.option(userRef,msg);
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

}
