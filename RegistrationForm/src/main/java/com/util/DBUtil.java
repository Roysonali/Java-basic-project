package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static String url ="jdbc:mysql://localhost:3306/form_db";
	private static String username = "root";
	private static String password = "Sonali@123";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}
		}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}

}
