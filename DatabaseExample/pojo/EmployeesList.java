package pojo;

import java.util.ArrayList;
import java.util.List;

public class EmployeesList {
	
	List<Employee> empList = new ArrayList<Employee>();

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public EmployeesList(List<Employee> empList) {
		super();
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "EmployeesList [empList=" + empList + "]";
	}
	
	

}
