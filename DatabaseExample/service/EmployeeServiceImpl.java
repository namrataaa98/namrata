package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import pojo.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDAO empDAO = new EmployeeDAOImpl();
	

	@Override
	public void callAddEmp(Employee eRef) {
		empDAO.addEmp(eRef);
		
	}

	@Override
	public void callUpdateEmp(Employee eRef) {
		empDAO.updateEmp(eRef);
		
	}

	@Override
	public List<Employee> callGetEmpList() {
		return empDAO.getEmpList();
		
	}

	@Override
	public void callGetEmpByID(int ID) {
		empDAO.getEmpByID(ID);
		
	}

	@Override
	public void callRemoveEmp(Employee eRef) {
		empDAO.removeEmp(eRef);
		
	}

	

}
