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
			getConnection();
			//con = MyConnection.prepareConnection();
			
			//comment
//			String query = "INSERT INTO employees ("
//				    + " empID,"
//				    + " password,"
//				    + " name,"
//				    + " dateOfBirth "
//				    + " ) VALUES ("
//				    + "?, ?, ?, ?)";
//			
//				st = con.prepareStatement(query);
			
			    st = con.prepareStatement("INSERT INTO employees (empID, password, name, dateOfBirth) values (?,?,?,?)");
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
		
		//end of comment
		    
	
		
	}

	@Override
	public void updateEmp(Employee eRef) {
		
		 
			
			try {
				
				//con = MyConnection.prepareConnection();
				//String query = "UPDATE employees SET password = ?, name = ? where empID = ?";
				getConnection();
				    //st = con.prepareStatement(query);
				    st = con.prepareStatement("UPDATE employees SET password = ?, name = ? where empID = ?");
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
	public List<Employee> getEmpList()  {
		
		List<Employee> empList = new ArrayList<Employee>();
		
		//con = MyConnection.prepareConnection();

		try {

			//String query = "SELECT empID, password, name, dateOfBirth FROM employees";
			getConnection();
			//st = con.prepareStatement(query);
			 st = con.prepareStatement("SELECT empID, password, name, dateOfBirth FROM employees");
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
	public void getEmpByID(int ID){
		
		try {
			getConnection();
			String query = "SELECT * FROM employees where empID = '" + ID + "'";
			
			    st = con.prepareStatement(query);
			//st = con.prepareStatement("SELECT * FROM employees where empID = ? ");
			
			   // st.setInt(1, eRef.getEmpID());
			    ResultSet rs;
			    rs = st.executeQuery(query);

			   while(rs.next()) {
					Employee eRef = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				    System.out.println(eRef);

			   }

			  
;			    
			
			    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return; 
		
	}

	@Override
	public void removeEmp(Employee eRef) {
		
		//System.out.println("Employee Records:");
		//System.out.println(empList());
		
		try {
			getConnection();
			//con = MyConnection.prepareConnection();
			//String query = "DELETE FROM employees where empID = ?";
			
			    //st = con.prepareStatement(query);
			
			st = con.prepareStatement("DELETE FROM employees where empID = ?");
			    st.setInt(1, eRef.getEmpID());
			    
			   
			    st.executeUpdate();
			    //System.out.println(eRef.getPassword());
			    System.out.println("Record Deleted Successfully");
			    System.out.println(getEmpList());
			    
			   
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		
		
		
	}

}
