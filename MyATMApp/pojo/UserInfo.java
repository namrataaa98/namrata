package pojo;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	
	private String email;
	private String password;
	private String color;
	private String bankAmount;
	public double tempAmount;
	
	
	
	public double depositAmount(double amt)
	{
		double doubleBankAmount = 0.0;		
		doubleBankAmount = Double.valueOf(bankAmount);
		doubleBankAmount += amt; 
		return doubleBankAmount;
	}
	
	
	public double withdrawAmount(double amt)
	{
		double doubleBankAmount = 0.0;		
		doubleBankAmount = Double.valueOf(bankAmount);
		doubleBankAmount -= amt;
		return doubleBankAmount;
	}
	
	private static String DefaultEmail = "xyz@gmail.com";
	

	public String getEmail() {
		return email;
	}
	
	
	public UserInfo(String email, String password, String color, String bankAmount) {
	//super();
	this.email = email;
	this.password = password;
	this.color = color;
	this.bankAmount = bankAmount;
	}
	
	public UserInfo() {
		return;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return email + "," + password + "," + color + "," + bankAmount;
	}

	public String getDefaultEmail() {
		return DefaultEmail;
	}

	public void setDefaultEmail(String defaultEmail) {
		this.DefaultEmail = defaultEmail;
	}

	public String getBankAmount() {
		return bankAmount;
	}

	public void setBankAmount(String bankAmount) {
		bankAmount = bankAmount;
	}

	public double getTempAmount() {
		return tempAmount;
	}

	public void setTempAmount(double tempAmount) {
		this.tempAmount = tempAmount;
	}
	
	

}
