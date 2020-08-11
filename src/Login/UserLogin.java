package Login;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import MyUtilities.MyConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File.*;

public class UserLogin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 
		SelecttblLogin();
		
	}
	
	
//Select tblLogin Table and Check for Valid UserName and Password
	
	public static void SelecttblLogin() throws IOException
	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyy hh.mm.ss.S aa");
		String formattedDate = dateFormat.format(new Date()).toString();
		//System.out.println(formattedDate);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name: ");
		String userName = sc.next();
		
		System.out.println("Enter Password: ");
		String userPassword = sc.next();
		
		//System.out.println("You have Enter: "+userName+"||"+userPassword);
		
		Statement stmt;
		PreparedStatement ps;
		ResultSet rs;
		try {
			FileWriter fw = new FileWriter("UserLogin logFile.txt",true);
			
			
			stmt = MyConnection.getConnection().createStatement();
			String query ="SELECT userName, userPassword FROM tbllogin WHERE userName=? AND userPassword=?";

			ps=MyConnection.getConnection().prepareStatement(query);
			ps.setString(1,userName);
			ps.setString(2,userPassword);
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("--------------------------------------------");
				System.out.println("Login Successfully!! Welcome to BRS System");
				System.out.println("--------------------------------------------");
				fw.write("\n"+formattedDate+" : "+"Login Sucess!"+" : "+"Login by - "+userName);
				fw.close();
			}
			else 
			{
				System.out.println("------------------------------------");
				System.out.println("Login Fail!! Try Again...");
				System.out.println("------------------------------------");
				fw.write("\n"+formattedDate+" : "+"Login Fail!"+" : "+"Attempt to Login as - "+userName);
				fw.close();
			}
			
		MyConnection.getConnection().close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  		  	 
		
	}

}
