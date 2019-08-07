package dao;

public class RegisterDAO2Impl implements RegisterDAO2{

	@Override
	public boolean validateEmail(String email) { //function that validates email during user registration
	boolean status;
		
		if(email.equals("xyz@gmail.com"))
		{
			System.out.println("Email already exists.");
			status = false;
		}
		else
		{
			status = true;
		}
		
		return status;
	}
	

	@Override
	public boolean validatePassword(String password, String pass2) { //function that validates password during user registration
		boolean status;
		
		if(!(password.equals(pass2)))
		{
			System.out.println("Passwords do not match");
			status = false;
			//success = false;
		}
		else
		{
			
			status = true;
		}
		
		return status;
	}

	
	

}
