package org.jsplogin.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager { 
	static Connection con; 
	static String url; 
	
	public static Connection getConnection() { 
		try { 
			String url = "jdbc:hsqldb:mem:."; 
			Class.forName("org.hsqldb.jdbcDriver"); 
			try { 
				con = DriverManager.getConnection(url,"sa","");
			} 
			catch (SQLException ex) { 
				ex.printStackTrace(); 
			} 
		} 
		catch(ClassNotFoundException e) { 
			System.out.println(e); 
		} 
		return con; 
	}
}
