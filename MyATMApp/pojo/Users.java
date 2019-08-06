package pojo;

import java.util.ArrayList;
import java.util.List;

public class Users {
	
	public List<UserInfo> usersList = new ArrayList<UserInfo>();
	
	public List<UserInfo> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserInfo> usersList) {
		this.usersList = usersList;
	}
	

//	public Users(List<UserInfo> usersList) {
//		this.usersList = usersList;
//	}
	
	@Override
	public String toString() {
		return "LoginDAOImpl2 [usersList=" + usersList + "]";
	}

	
	


}
