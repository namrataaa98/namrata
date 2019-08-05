package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import connection.MyConnection;


import java.sql.PreparedStatement;

import pojo.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	
	
	Connection con; 
	PreparedStatement st;
	
	void getConnection() {
		con = DBConnection.myConnection();
	}

	@Override
	public void addEmp(Employee eRef){
		
		
		 
		try {
			//getConnection();
			con = MyConnection.prepareConnection();
			String query = "INSERT INTO Employees ("
				    + " empID,"
				    + " password,"
				    + " name,"
				    + " dateOfBirth "
				    + " ) VALUES ("
				    + "?, ?, ?, ?)";
			
				st = con.prepareStatement(query);
			    st.setInt(1, eRef.getEmpID());
			    st.setString(2, eRef.getPassword());
			    st.setString(3, eRef.getEmpName());
			    st.setString(4, eRef.getDateOfBirth());
			
			    st.executeUpdate();
			  //  st.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	
		
	}

	@Override
	public void updateEmp(Employee eRef) {
		
		 
			
			try {
				//getConnection();
				con = MyConnection.prepareConnection();
				String query = "UPDATE employees SET password = ?, name = ? where empID = ?";
				
				    st = con.prepareStatement(query);
				
				    st.setString(1, eRef.getPassword());
				    st.setString(2, eRef.getEmpName());
				    st.setInt(3, eRef.getEmpID());
				    
				   
				    st.executeUpdate();
				    st.close();
				    System.out.println(eRef.getPassword());
				    System.out.println("Record Modified Successfully");
				   
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
				
		
	}

	@Override
	public List<Employee> empList()  {
		
		List<Employee> empList = new ArrayList<Employee>();
		//getConnection();
		con = MyConnection.prepareConnection();

		try {

			String query = "SELECT empID, password, name, dateOfBirth FROM employees";
			st = con.prepareStatement(query);
			ResultSet rs;
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				empList.add(emp);
				
				
			
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} // to print 
		
		return empList;
		
		}
		
		
	

	@Override
	public Employee getEmpByID(int ID){
		//Employee eRef = new Employee();
		
		
		try {
			//getConnection();
			con = MyConnection.prepareConnection();
			String query = "SELECT * FROM employees where empID = ?";
			
			    st = con.prepareStatement(query);
			    st.setInt(1, eRef.getEmpID());
			    ResultSet rs;
			    rs = st.executeQuery(query);

				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

				System.out.println(emp);
				

			   // st.executeUpdate();
			    //System.out.println(eRef.getPassword());
			    System.out.println("Return ID: ");
			    
			  //  System.out.println(empList());
			    
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return eRef; 
		
	}

	@Override
	public void removeEmp(Employee eRef) {
		
		//System.out.println("Employee Records:");
		//System.out.println(empList());
		
		try {
			//getConnection();
			con = MyConnection.prepareConnection();
			String query = "DELETE FROM employees where empID = ?";
			
			    st = con.prepareStatement(query);
			    st.setInt(1, eRef.getEmpID());
			    
			   
			    st.executeUpdate();
			    //System.out.println(eRef.getPassword());
			    System.out.println("Record Deleted Successfully");
			    System.out.println(empList());
			    
			   
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		
		
		
	}

}
