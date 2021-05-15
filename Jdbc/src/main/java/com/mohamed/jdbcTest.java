package com.mohamed;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class jdbcTest {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@acoracle.montgomerycollege.edu:15521:acoradb";
		String user= "cs270229ap";
		String password = "ap";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver is successfuly loaded!!");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt= con.createStatement();  
			ResultSet rs= stmt.executeQuery("select NPI, FIRST_NAME, LAST_NAME, ADDRESS_STATE from NPIREGISTRY WHERE NPI = '1780687996'");
			System.out.println("Connection is successful with  "+ con);
			rs.next();
			System.out.println("This is result returned from query ");
			System.out.println("Npi number: "+ rs.getString("NPI"));
			System.out.println("First name: "+ rs.getInt(1));
			System.out.println("Last name: "+ rs.getString("LAST_NAME"));
			System.out.println("State of residence: "+ rs.getString("ADDRESS_STATE"));

			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("connection not made line 21");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("connection not made line 23");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("not fetching");
			e.printStackTrace();
		}
	}

}
