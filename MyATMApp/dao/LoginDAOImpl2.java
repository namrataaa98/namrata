package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.RegisterController;
import pojo.UserInfo;
import pojo.Users;

public class LoginDAOImpl2 implements LoginDAO2{
	
   
   @Override
	public boolean userLoggedIn(String loginID, String password, Users users) {
		boolean success = false;
		
		for(int i=0; i<users.getUsersList().size(); i++) {
				
			if(loginID.equals(users.getUsersList().get(i).getEmail()) &&
					password.equals(users.getUsersList().get(i).getPassword())) {
				System.out.println("Login Success");
				success = true;
				break;
			}
		}
		return success;
	}
   
   
   
   RegisterController regController;
   Scanner s = new Scanner(System.in);
   //List<UserInfo> usersList = new ArrayList<UserInfo>();
  // Users users = new Users();
  
   @Override
	public void printBankLoginMenu(UserInfo logInfo, Users users) {
		System.out.println("Type 1 : Check Available Bank Balance ");
		System.out.println("Type 2 : Deposit Amount ");
		System.out.println("Type 3 : Withdraw Amount ");
		int choice = s.nextInt();
		transactionFunction(choice, logInfo, users);
		
	}

	@Override
	public void transactionFunction(int choice, UserInfo logInfo, Users users) {
		
		double temp;
		double amount = 0;
		String strTemp = "";
		
		switch(choice)
		{
		case 1 : readFromFileUsers(users);
			     System.out.println("Available Balance  : $"+ logInfo.getBankAmount());
                continueTransaction(logInfo, users);
                break;
                
		case 2 : System.out.println("Enter Amount : ");
				 temp = s.nextDouble();
				 if(temp<=0.0)
					{
						System.out.println("Amount can't be negative!!");
						//this.transactionFunction();	
					}
					System.out.println("$"+temp+" dollars deposited successfully!!");
					
					//updateBalance(logInfo, temp);
					
					amount += logInfo.depositAmount(temp);
					strTemp += Double.toString(amount);
					
					updateBalance(logInfo, strTemp, users);
					
					
					
					continueTransaction(logInfo, users);
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
						continueTransaction(logInfo, users);
					}
						
						amount += logInfo.withdrawAmount(temp);
						strTemp += Double.toString(amount);
						updateBalance(logInfo, strTemp, users);
						System.out.println("Transaction Successful!!");
						continueTransaction(logInfo, users);
						break;
		}
					
		
	}


	@Override
	public void continueTransaction(UserInfo logInfo, Users users) {
		regController = new RegisterController();
		
		String ans;
		System.out.println("Wish to Continue? (y/n) : ");
		ans = s.next();
		if(ans.equalsIgnoreCase("y"))
		{
			printBankLoginMenu(logInfo, users);	
		}
		else if(ans.equalsIgnoreCase("n"))
		{
			System.out.println("Thanks for Banking with Us !!!\n");
			regController.userRegController();
		}
		else
		{
			printWrongInput(logInfo, users);
		}
		
	}

	@Override
	public void printWrongInput(UserInfo logInfo, Users users) {
		
		System.out.println("Choice not available, please try again!");
		continueTransaction(logInfo, users);
		
	}

	@Override
	public void readFromFileUsers(Users users) {

		FileReader fr;
		BufferedReader br;
		
		try {
			
			fr = new FileReader("UsersNew.csv");
			br = new BufferedReader(fr);
			String var = br.readLine();
			
			while(var != null) {
	
				String[] record = var.split(",");            
				
	           // UserInfo user1 = new UserInfo(record[0], record[1], record[2], Double.value`Of(record[3]));
				UserInfo user1 = new UserInfo(record[0], record[1], record[2], record[3]);
	            
				
	            users.getUsersList().add(user1);
	           
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
	public void updateBalance(UserInfo logInfo, String tempAmount, Users users) {
		
		FileWriter fw;
		BufferedWriter bw;
	
		UserInfo user = new UserInfo(logInfo.getEmail(), logInfo.getPassword(), logInfo.getColor(), tempAmount);
		users.getUsersList().add(user);
		
		try {
			fw = new FileWriter("UsersNew.csv", true);
			bw = new BufferedWriter(fw);
			
			bw.write(user.toString() + "\n");
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		
	 }
	}




}
