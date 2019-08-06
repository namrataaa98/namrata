package service;

import java.util.List;

import pojo.Employee;

public interface EmployeeService {
	
	public void callAddEmp(Employee eRef) ;
	public void callUpdateEmp(Employee eRef);
	public List<Employee> callGetEmpList() ;
	public void callGetEmpByID(int ID) ;
	public void callRemoveEmp(Employee eRef) ;

}
