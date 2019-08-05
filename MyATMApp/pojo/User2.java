package pojo;

import java.util.ArrayList;
import java.util.List;

public class User2{
	
	List<UserInfo> UsersList = new ArrayList<UserInfo>();

	public List<UserInfo> getUsersList() {
		return UsersList;
	}

	public void setUsersList(List<UserInfo> usersList) {
		UsersList = usersList;
	}

	@Override
	public String toString() {
		return "User2 [UsersList=" + UsersList + "]";
	}

	public User2(List<UserInfo> usersList) {
		super();
		UsersList = usersList;
	}

	
	

}
