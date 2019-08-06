package connection;

import java.io.FileReader; 
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public static Connection myConnection() {
		
		 Connection con = null;
	        FileReader fReader = null; 
	        
	    //Create properties object.
	        Properties propRef = new Properties();
	        
	        try 
	        {
	            fReader = new FileReader("db.properties");
	            // Load jdbc related properties in above files/
	            propRef.load(fReader);
	            //load the driver class
	            Class.forName(propRef.getProperty("db_driver_class")); // this key can be anything
	            //create the connection
	            con = DriverManager.getConnection(
	                    propRef.getProperty("db_url"),
	                    propRef.getProperty("db_username"),
	                    propRef.getProperty("db_password"));
	            
	        } 
	        catch (IOException | ClassNotFoundException | SQLException e) 
	        {
	            System.out.println("DBConnection2 => DB Connection Error..");
	            
	        }
	        
	        //System.out.println("testing");
	        return con;
	    }// end of myConnection()
		
	}


