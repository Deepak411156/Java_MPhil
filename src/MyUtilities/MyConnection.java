package MyUtilities;

import java.sql.*;

public class MyConnection {
	
	public static Connection getConnection()
	{
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbNOU","root","bhatta");
			//System.out.println("Succesfully.. Connected to database...");
			
		} catch (Exception e) {
			System.out.println("Connection could not established!! Check the database connection and try again");
		}
		return con;
	}
		
}
