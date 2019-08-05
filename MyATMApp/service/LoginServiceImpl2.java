package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import pojo.UserInfo;
import pojo.Users;
import controller.RegisterController;

public class LoginServiceImpl2 implements LoginService2 {
    RegisterController regController;
    Scanner s = new Scanner(System.in);
    List<UserInfo> usersList = new ArrayList<UserInfo>();
   
    @Override
	public void printBankLoginMenu(UserInfo logInfo) {
		System.out.println("Type 1 : Check Available Bank Balance ");
		System.out.println("Type 2 : Deposit Amount ");
		System.out.println("Type 3 : Withdraw Amount ");
		int choice = s.nextInt();
		transactionFunction(choice, logInfo);
		
	}

	@Override
	public void transactionFunction(int choice, UserInfo logInfo) {
		
		double temp;
		double amount = 0;
		String strTemp = "";
		
		switch(choice)
		{
		case 1 : readFromFileUsers(usersList);
			     System.out.println("Available Balance  : $"+ logInfo.getBankAmount());
                 continueTransaction(logInfo);
                 break;
                 
		case 2 : System.out.println("Enter Amount : ");
				 temp = s.nextDouble();
				 if(temp<=0.0)
					{
						System.out.println("Amount can't be negative!!");
						//this.transactionFunction();	
					}
					System.out.println("$"+temp+" dollars deposited successfully!!");
					
					amount += logInfo.depositAmount(temp);
					strTemp += Double.toString(amount);
					
					//writing amount to file
					
					FileWriter fw;
					BufferedWriter bw;
				
					UserInfo user = new UserInfo(logInfo.getEmail(), logInfo.getPassword(), logInfo.getColor(), strTemp);
					usersList.add(user);
					
					try {
						fw = new FileWriter("User1.csv", true);
						bw = new BufferedWriter(fw);
						
						bw.write(user.toString() + "\n");
						
						bw.close();
						fw.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} //opens file in append mode
					
					//end of writing amount to file
					
					//readFromFileUsers(usersList);
					
					continueTransaction(logInfo);
					break;
					
		case 3 : System.out.println("Enter Amount : ");
				 temp = s.nextDouble();
		
					if(temp<=0)
					{
						System.out.println("Amount can't be negative!!");
						System.out.println("Enter Amount : ");
						temp = s.nextDouble();
					}
					else if(temp>Double.valueOf(logInfo.getBankAmount()))
					{
						System.out.println("Sorry!! insufficient balance");
						continueTransaction(logInfo);
					}
						logInfo.withdrawAmount(temp);
						System.out.println("Transaction Successful!!");
						continueTransaction(logInfo);
						break;
		}
					
		
	}

	@Override
	public void continueTransaction(UserInfo logInfo) {
		regController = new RegisterController();
		
		String ans;
		System.out.println("Wish to Continue? (y/n) : ");
		ans = s.next();
		if(ans.equalsIgnoreCase("y"))
		{
			printBankLoginMenu(logInfo);	
		}
		else if(ans.equalsIgnoreCase("n"))
		{
			System.out.println("Thanks for Banking with Us !!!\n");
			regController.userRegController();
		}
		else
		{
			printWrongInput(logInfo);
		}
		
	}

	@Override
	public void printWrongInput(UserInfo logInfo) {
		
		System.out.println("Choice not available, please try again!");
		continueTransaction(logInfo);
		
	}

	@Override
	public void readFromFileUsers(List<UserInfo> usersList) {
		
		FileReader fr;
		BufferedReader br;
		
		try {
			
			fr = new FileReader("User1.csv");
			br = new BufferedReader(fr);
			String var = br.readLine();
			
			while(var != null) {
	
				String[] record = var.split(",");            
				
	           // UserInfo user1 = new UserInfo(record[0], record[1], record[2], Double.value`Of(record[3]));
				UserInfo user1 = new UserInfo(record[0], record[1], record[2], record[3]);
	            
				
	            usersList.add(user1);
	           
	            var = br.readLine();
			}
			
		    br.close();
		    fr.close();
		    		    
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void writeToFile(UserInfo logInfo) {
		
		
		FileWriter fw;
		BufferedWriter bw;
	
		UserInfo user = new UserInfo(logInfo.getEmail(), logInfo.getPassword(), logInfo.getColor(), logInfo.getBankAmount());
		usersList.add(user);
		
		try {
			fw = new FileWriter("User1.csv", true);
			bw = new BufferedWriter(fw);
			
			bw.write(user.toString() + "\n");
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //opens file in append mode
		
	}
	

}
