package connection;

import java.sql.*;

public class MyConnection {
		
		public static Connection prepareConnection() {
			//database URL
			// 3306 is the default port for mySQL
			String connectionURL = "jdbc:mysql://localhost:3306/clt6"; //core is database name 
			
			//database credentials 
			String uname = "root";
			String pwd = "admin";
			Connection ref = null;
			
			try {
			//Register JDBC Driver 
				//open a connection
				Class.forName("com.mysql.jdbc.Driver");
				ref = DriverManager.getConnection(connectionURL, uname, pwd);
				return ref;
			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ref;
			
		
		}
	
}
