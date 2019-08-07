package service;

public interface RegisterService {

	
	public boolean callValidateEmail(String email);
	public boolean callValidatePassword(String password, String pass2);

}
