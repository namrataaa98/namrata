package ATMApp;

import java.util.Scanner;

public class LoginPage 
{
	static void loginOption()
	{
		double temp;
		Scanner s = new Scanner(System.in);
		switch(UserInfo.getChoice())
		{
		case 1 : System.out.println("Available Balance  : $"+UserInfo.getBankAmount());
                 MessagePrint.wishToContinue();
                 break;
		case 2 : System.out.println("Enter Amount : ");
				 temp = s.nextDouble();
				 if(temp<=0.0)
					{
						System.out.println("Amount can't be negative!!");
						MessagePrint.message2();	
					}
					System.out.println("$"+temp+" dollars deposited successfully!!");
					UserInfo.depositAmount(temp);
					MessagePrint.wishToContinue();
					break;
					
		case 3 : System.out.println("Enter Amount : ");
				 temp = s.nextDouble();
		
					if(temp<=0)
					{
						System.out.println("Amount can't be negative!!");
						System.out.println("Enter Amount : ");
						temp = s.nextDouble();
					}
					else if(temp>UserInfo.getBankAmount())
					{
						System.out.println("Sorry!! insufficient balance");
						MessagePrint.wishToContinue();
					}
						UserInfo.withdrawAmount(temp);
						System.out.println("Transaction Successful!!");
						MessagePrint.wishToContinue();
						break;
		}
					
		
		
		
		
			
		}
}
