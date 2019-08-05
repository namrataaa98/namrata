package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Employee;

public interface EmployeeDAO {

	public void addEmp(Employee eRef) ;
	public void updateEmp(Employee eRef);
	public List<Employee> empList() ;
	public Employee getEmpByID(int ID) ;
	public void removeEmp(Employee eRef) ;
	
}
