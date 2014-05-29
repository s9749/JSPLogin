package org.jsplogin.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersDAO { 
	
	static Connection currentCon = null; 
	static ResultSet rs = null; 
	
	public static BeanUser login(BeanUser bean) { 
		Statement stmt = null; 
		String username = bean.getUsername(); 
		String password = bean.getPassword(); 
		String searchQuery = "select * from public.users where username='" + username + "' AND password='" + password + "'"; 

		System.out.println("Your user name is " + username); 
		System.out.println("Your password is " + password); 
		System.out.println("Query: " + searchQuery); 
		
		try { 
			//polaczenie z baza
			currentCon = ConnectionManager.getConnection(); 
			stmt=currentCon.createStatement(); 
			stmt.execute("CREATE TABLE IF NOT EXISTS users (FirstName varchar(50), LastName varchar(50), username varchar(50), password varchar(50))");
			stmt.execute("INSERT INTO users VALUES( 'Administrator', 'Adminski', 'admin', 'pass' )");
			
			rs = stmt.executeQuery(searchQuery); 
			boolean more = rs.next(); 
			
			//jesli w bazie nie ma uzytkownika z podanym haslem (weryfikacja negatywna)
			if (!more) { 
				
				bean.setValid(false); 
			} 
			//jesli jest (weryfikacja pozytywna)
			else if (more) { 
				String firstName = rs.getString("FirstName"); 
				String lastName = rs.getString("LastName"); 
				System.out.println("Welcome " + firstName); 
				bean.setFirstName(firstName); 
				bean.setLastName(lastName); 
				bean.setValid(true); 
			} 
		} 
		catch (Exception ex) { 
			System.out.println("Błąd logowania! Wyjątek: " + ex); 
		} 
		//obsluga bledow polaczenia
		finally { 
			if (rs != null) { 
				try { 
					rs.close(); 
					} 
				catch (Exception e) {} 
				rs = null; 
			}
			if (stmt != null) { 
				try { 
						stmt.close(); 
				} 
				catch (Exception e) {} 
				stmt = null; 
			} 
			if (currentCon != null) { 
				try { 
					currentCon.close(); 
				} 
				catch (Exception e) { } 
				currentCon = null; 
			} 
		}
		return bean; 
	}
}


