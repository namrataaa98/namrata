package dao;

import java.util.ArrayList;
import java.util.List;


import pojo.UserInfo;

public class LoginDAOImpl2 implements LoginDAO2{
	
	public List<UserInfo> usersList = new ArrayList<UserInfo>();
	
	public List<UserInfo> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserInfo> usersList) {
		this.usersList = usersList;
	}
	

	public LoginDAOImpl2(List<UserInfo> usersList) {
		this.usersList = usersList;
	}
	
	@Override
	public String toString() {
		return "LoginDAOImpl2 [usersList=" + usersList + "]";
	}
	

	@Override
	public boolean userLoggedIn(String loginID, String password) {
		boolean success = false;
		
		for(int i=0; i<this.usersList.size(); i++) {
				
			if(loginID.equals(this.usersList.get(i).getEmail()) &&
					password.equals(this.usersList.get(i).getPassword())) {
				System.out.println("Login Success");
				success = true;
				break;
			}
		}
		return success;
	}


}
