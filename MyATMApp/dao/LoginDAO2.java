package dao;

import pojo.UserInfo;
import pojo.Users;

public interface LoginDAO2 {

	public boolean userLoggedIn(String loginID, String password, Users users);
	
	public void printBankLoginMenu(UserInfo logInfo, Users users);
	public void transactionFunction(int choice, UserInfo logInfo, Users users);
	public void continueTransaction(UserInfo logInfo, Users users);
	public void printWrongInput(UserInfo logInfo, Users users);
	public void readFromFileUsers(Users users);
	public void updateBalance(UserInfo logInfo, String strTemp, Users users);
	
}
