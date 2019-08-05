package service;

import java.util.List;

import pojo.UserInfo;
import pojo.Users;

public interface LoginService2 {
	
	public void printBankLoginMenu(UserInfo logInfo);
	public void transactionFunction(int choice, UserInfo logInfo);
	public void continueTransaction(UserInfo logInfo);
	public void printWrongInput(UserInfo logInfo);
	public void readFromFileUsers(List<UserInfo> usersList);
	public void writeToFile(UserInfo LogInfo);

}
