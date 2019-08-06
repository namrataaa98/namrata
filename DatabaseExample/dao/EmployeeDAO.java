package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Employee;

public interface EmployeeDAO {

	public void addEmp(Employee eRef) ;
	public void updateEmp(Employee eRef);
	public List<Employee> getEmpList() ;
	public void getEmpByID(int ID) ;
	public void removeEmp(Employee eRef) ;
	
}
