package ATMApp;

import java.util.Scanner;

public class ChoiceOption 
{
	double temp=0.0;
	Scanner s = new Scanner(System.in);
	public void option(UserInfo userRef, MessagePrint msg)
	
	
	{
		try 
		{
			UserHomePage refChoiceOne = new  UserHomePage();
			switch(UserInfo.getChoice())
			{
			case 1 : refChoiceOne.choiceOne(msg);
					break;
			case 2 : refChoiceOne.choiceTwo(msg);
					break;
			case 3 : refChoiceOne.choiceThree(msg);
					break;
			case 4 : refChoiceOne.choiceFour(msg);
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
	
	
}
	
	

