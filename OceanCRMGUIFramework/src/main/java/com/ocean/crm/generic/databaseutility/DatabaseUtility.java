package com.ocean.crm.generic.databaseutility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 


public class DatabaseUtility {
	Connection con;
	public void getDbconnection(String url, String username, String password) throws SQLException {
		try {
		con=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("Exception");
			
		}	
	}
	public void getDbconnection() throws SQLException {
		try {
		con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		}catch(Exception e) {
			System.out.println("Exception");
		}
	}
	public void closeDbconnection() throws SQLException {
	try {
		con.close();
	}catch(Exception e) {
		System.out.println("Exception");
	}
	
	}
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement smt = con.createStatement();
		 result= smt.executeQuery(query);
		}catch(Exception e) {
			System.out.println("Exception");
			
		}
		return result;
	}
	public int executeNonselectQuery(String query) {
		int result=0;
		try {
			Statement smt = con.createStatement();
			result= smt.executeUpdate(query);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
