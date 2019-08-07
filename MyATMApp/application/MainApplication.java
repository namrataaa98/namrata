package application;

import controller.RegisterController;

public class MainApplication {
	
	public static void main(String[] args) {
		
		RegisterController registerController = new RegisterController();
		
		registerController.userRegController();
		
	}
	

}



