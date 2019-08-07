package application;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.MyConnection;




public class Database01 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = MyConnection.prepareConnection();
		
		//Execute a query
		System.out.println("Creating table in given database...");
		Statement st = con.createStatement();
		
		//create table 
		String sql = "CREATE TABLE Customers " + 
		"(ID INTEGER not NULL, " + 
		"Name VARCHAR(25), " + 
		"Age INTEGER, " +
		"Address VARCHAR(25), " +
		"Salary decimal, " +
		"PRIMARY KEY (ID))";
		st.executeUpdate(sql); // for saving purpose
		System.out.println("Created table in given database..."); 
		
		//Insert record
//		String sql = "INSERT INTO students99 " + 
//					"VALUES (637423736, 'Sally', 'sally@gmail.com')";
//		
//		st.executeUpdate(sql); //method to update any modifications 
//		
//		System.out.println("Data Inserted Successfully");
		
		//all this logic is to be written in daO
		
		
		//edit a record 
//		String sql = "UPDATE students99 " +
//						"SET name = 'Supatra' WHERE mobile in (637423736)";
//		st.executeUpdate(sql);
//		System.out.println("Record Modified Successfully...");
		
		//delete a record 
//		String sql = "DELETE FROM students99 " +
//		"WHERE mobile = 637475736";
//		st.executeUpdate(sql);
//		System.out.println("Record Deleted from table Successfully..");
		
		//Retrieve Data from Table 
//		String sql = "SELECT mobile, name, email FROM students99";
//		ResultSet rs = st.executeQuery(sql); // to print 
//		
//		//STEP 5: Extract data from result set
//		
//		System.out.println("\n\n");
//		System.out.println("Mobile\t\t" + "Name" + "\t\t" + "Email");
//		System.out.println("=================================================================");
//		
//		
//		while(rs.next()) {
//			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
//		}
		
		
		
		
		
		
		
		
	}

}
