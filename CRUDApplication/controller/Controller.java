package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import pojo.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class Controller {
	
	
	public void mainController() throws ClassNotFoundException, SQLException {
		
		CRUDoperations();
		
		
	}
	
	
	public void CRUDoperations() throws ClassNotFoundException, SQLException {
		
		int ID, no;
		
		String password, name, dateOfBirth;
		
		List<Employee> empList = new ArrayList<Employee>();
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		
		
		EmployeeService empService = new EmployeeServiceImpl();
		
		
		System.out.println("Press 1 to Register, 2 to Login, and 3 to retrieve list of employees, 4 to get emp by ID");
		no = sc.nextInt();
		
		
		//Add Employee
		if (no == 1) {
		System.out.println("--Register--");
		System.out.println("Enter EmpID: ");
		
		ID = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter password: ");
		password = sc.next();
		
		System.out.println("Enter your name ");
		name = sc.next();
		System.out.println("Enter your date of birth: ");
		dateOfBirth = sc.next();
		
		Employee emp = new Employee(ID, password, name, dateOfBirth);
		
		empList.add(emp);
		System.out.println(empList);
		
		empService.callAddEmp(emp);
		
		}
		//End of Add Employee
		
		
		//Update employee password
		else if (no == 2){
		
		System.out.println("--Login--");
		System.out.println("Enter your ID: ");
		
		ID = sc.nextInt();
		
		
	
		for(int i=0; i<empService.callGetEmpList().size(); i++) {
			
			if (empService.callGetEmpList().get(i).getEmpID() == ID) {
				
				Employee emp = empService.callGetEmpList().get(i);
				
				System.out.println("Update Password");
				String newPass = sc.next(); 
				System.out.println(newPass);
				
				emp.setPassword(newPass);
				empService.callUpdateEmp(emp);
				
			}
		}
		
	}
		//end of Update emp password
		
		
		
		//delete employee
		else if (no == 3){
			
		
		
		System.out.println("Employee Records:");
		System.out.println(empDAO.getEmpList());
		
		System.out.println("Enter ID of the employee record which you wish to delete:");
		
		ID = sc.nextInt();
		
		for(int i=0; i<empService.callGetEmpList().size(); i++) {
			
			if (empService.callGetEmpList().get(i).getEmpID() == ID) {
				
				Employee emp = empService.callGetEmpList().get(i);
				
				System.out.println(emp);
				System.out.println("Are you sure you want to delete this record?(y/n)");
				String yesno = sc.next();
				
				if (yesno.equals("y")) {
					System.out.println();
					empService.callRemoveEmp(emp);
				}
				
				
			}
		}
		
		}
		
		//End of delete employee
		else {
			
		//Get emp by ID
		System.out.println("Enter the ID of the particular employee's record which you would like to see: ");
		ID = sc.nextInt();
		
		for(int i=0; i<empService.callGetEmpList().size(); i++) {
			
			if (empService.callGetEmpList().get(i).getEmpID() == ID) {
				
				empService.callGetEmpByID(ID);
				//break;
				
			}
		}
		
       // empDAO.getEmpByID(ID);
		//End of get emp by ID
		}
		
}

}
