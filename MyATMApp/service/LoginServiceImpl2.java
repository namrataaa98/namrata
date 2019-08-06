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
import dao.LoginDAO2;
import dao.LoginDAOImpl2;

public class LoginServiceImpl2 implements LoginService2 {
	
	LoginDAO2 loginDAO = new LoginDAOImpl2();

	@Override
	public void callPrintBankLoginMenu(UserInfo logInfo, Users users) {
		
		loginDAO.printBankLoginMenu(logInfo, users);
	}

	@Override
	public void callTransactionFunction(int choice, UserInfo logInfo, Users users) {
		loginDAO.transactionFunction(choice, logInfo, users);
		
	}

	@Override
	public void callContinueTransaction(UserInfo logInfo, Users users) {
		loginDAO.continueTransaction(logInfo, users);
		
	}

	@Override
	public void callPrintWrongInput(UserInfo logInfo, Users users) {
		loginDAO.printWrongInput(logInfo, users);
		
	}

	@Override
	public void callReadFromFileUsers(Users users) {
		loginDAO.readFromFileUsers(users);
		
	}

	@Override
	public void callUpdateBalance(UserInfo logInfo, String strTemp, Users users) {
		loginDAO.updateBalance(logInfo, strTemp, users);
		
	}

	@Override
	public boolean callUserLoggedIn(String loginID, String password, Users users) {
		return loginDAO.userLoggedIn(loginID, password, users);
		
	}
   
}

	


