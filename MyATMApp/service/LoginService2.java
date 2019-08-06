package service;

import java.util.List;

import pojo.UserInfo;
import pojo.Users;

public interface LoginService2 {
	
	public boolean callUserLoggedIn(String loginID, String password, Users users);
	
	public void callPrintBankLoginMenu(UserInfo logInfo, Users users);
	public void callTransactionFunction(int choice, UserInfo logInfo, Users users);
	public void callContinueTransaction(UserInfo logInfo, Users users);
	public void callPrintWrongInput(UserInfo logInfo, Users users);
	public void callReadFromFileUsers(Users users);
	public void callUpdateBalance(UserInfo logInfo, String strTemp, Users users);

}
