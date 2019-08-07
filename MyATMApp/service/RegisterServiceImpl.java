package service;

import dao.RegisterDAO2;
import dao.RegisterDAO2Impl;

public class RegisterServiceImpl implements RegisterService{
	
	RegisterDAO2 registerDAO = new RegisterDAO2Impl();
	
	@Override
	public boolean callValidateEmail(String email) {
		return registerDAO.validateEmail(email);
		
	}

	@Override
	public boolean callValidatePassword(String password, String pass2) {
		return registerDAO.validatePassword(password, pass2);
		
	}


}
