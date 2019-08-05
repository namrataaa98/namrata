package ATMApp;

public class UserInfo 
{
	private static int choice;
	private static double bankAmount;
	private String email,password,color;
	
	public static void depositAmount(double amt)
	{
		bankAmount += amt; 
	}
	
	public static void withdrawAmount(double amt)
	{
		bankAmount -= amt;
	}
	
	private static String DefaultEmail = "xyz@gmail.com";
	
	public void setDefaultEmail(String defaultEmail) 
	{
		DefaultEmail = defaultEmail;
	}
	
	public static String getDefaultEmail() 
	{
		return DefaultEmail;
	}
	
	
	public static int getChoice() 
	{
		return choice;
	}
	
	public void setChoice(int choice) 
	{
		this.choice = choice;
	}
	
	
	public String getEmail() {
		return email;
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

	public static double getBankAmount() {
		return bankAmount;
	}
	
	public static void setBankAmount(double bankAmount) {
		UserInfo.bankAmount = bankAmount;
	}


	
}
