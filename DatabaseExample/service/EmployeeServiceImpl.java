package service;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import pojo.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void callAddEmployee(Employee refEmp) {
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		switch(choice) {
		case 1: empDAO.addEmp(refEmp);
		case 2: empDAO.
		}
		
	}

}
