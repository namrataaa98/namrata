package pojo;

public class Employee {
	
	int empID;
	String password;
	String empName;
	String dateOfBirth;
	
	
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Employee(int empID, String password, String empName, String dateOfBirth) {
		super();
		this.empID = empID;
		this.password = password;
		this.empName = empName;
		this.dateOfBirth = dateOfBirth;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	//public Employee() {
		// TODO Auto-generated constructor stub
	//}
	@Override
	public String toString() {
		return "EmployeeID=" + empID + ", " + "Password=" + password + ", " + "EmployeeName=" + empName + ", " +  "DOB="
				+ dateOfBirth + "\n";
	}
	
	
	
	

}
