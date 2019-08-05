package application;

import java.sql.SQLException;

import controller.Controller;

public class applicationMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Controller controller = new Controller();
		
		controller.mainController();
		

	}

}

