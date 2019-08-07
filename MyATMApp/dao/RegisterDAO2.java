package dao;

public interface RegisterDAO2 {
	
	public boolean validateEmail(String email);
	public boolean validatePassword(String password, String pass2);

}
