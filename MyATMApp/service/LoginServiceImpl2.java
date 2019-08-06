package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
					
					//updateBalance(logInfo, temp);
					
					amount += logInfo.depositAmount(temp);
					strTemp += Double.toString(amount);
					
					updateBalance(logInfo, strTemp);
					
					
					
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
						
						amount += logInfo.withdrawAmount(temp);
						strTemp += Double.toString(amount);
						updateBalance(logInfo, strTemp);
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
		
//		//test code
//		
//		FileReader fr = new FileReader("User2.csv");
//		BufferedReader br = new BufferedReader(fr);
//		String var = br.readLine();
//		
//		while(var != null)
//		{ 
//			var = var.trim(); // remove leading and trailing whitespace
//		    if (!var.equals("")) // don't write out blank lines
//		    {
//		        fw.write(var, 0, var.length());
//		    }
//		}
//		
//		//end of test code
		
		try {
			
			fr = new FileReader("User2.csv");
			br = new BufferedReader(fr);
			String var = br.readLine();
			String out="";
			
			FileWriter fw = new FileWriter("User2.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//File.WriteAllLines(filepath,File.ReadAllLines(filepath).Where(l => !string.IsNullOrWhiteSpace(l)));
			
			//while ((line = br.readLine()) != null && !"".equals(line = br.readLine().trim()))
			
			//while(var != null && !"".equals(var.trim())) {
			
			while(var != null) {
				
				var = var.trim(); // remove leading and trailing whitespace
			    if (!var.equals("")) // don't write out blank lines
			    {
			        fw.write(var, 0, var.length());
			    }
				
				// line = line.trim();
				
//				if (var.replace(",", "").equals(null) || var.replace(",", "").equals("")) {
//				   var.replace(",", "");
//				    break;
//				}
				
				br.lines().filter(line -> line.matches("(\\d+)(,\\s*\\d+)*"));
				
				String[] record = var.split(",");            
				
	           // UserInfo user1 = new UserInfo(record[0], record[1], record[2], Double.value`Of(record[3]));
				UserInfo user1 = new UserInfo(record[0], record[1], record[2], record[3]);
	            
				
	            usersList.add(user1);
	           
	            var = br.readLine();
	            
	            //continue;
	            
				//}
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
			fw = new FileWriter("User2.csv", true);
			bw = new BufferedWriter(fw);
			
			bw.write(user.toString() + "\n");
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //opens file in append mode
		
	}

	@Override
	public void updateBalance(UserInfo logInfo, String tempAmount) {
		
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter pw;
		
		String filepath = "User2.csv";
		String tempFile = "temp2.csv";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String email="", password ="", color="", balance="";
		
		
	
		//UserInfo user = new UserInfo(logInfo.getEmail(), logInfo.getPassword(), logInfo.getColor(), tempAmount);
		//usersList.add(user);
		
		try {
			fw = new FileWriter(tempFile, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			Scanner x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]"); 
			
			
		
			//File.WriteAllLines(filepath,File.ReadAllLines(filepath).Where(l => !string.IsNullOrWhiteSpace(l)));
			
			
			
			while(x.hasNext()) {
				
				email = x.next();
				password = x.next();
				color = x.next();
				balance = x.next();
				
				if(email.equals(logInfo.getEmail()))
				{
					//pw.println(email + "," + logInfo.getPassword() + "," + logInfo.getColor() + "," + tempAmount);
					UserInfo user = new UserInfo(logInfo.getEmail(), logInfo.getPassword(), logInfo.getColor(), tempAmount);
					usersList.add(user);
					pw.println(user.toString() + "\n");
					
				}
				
				else {
					
					pw.println(email + "," + password + "," + color + "," + balance);
					
				}
				
				
			
		    } 
			
			x.close();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
			
			
			
			
			
			bw.close();
			fw.close();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
	


