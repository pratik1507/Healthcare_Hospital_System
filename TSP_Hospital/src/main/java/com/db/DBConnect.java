package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;
	public static Connection getConn() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Enter your Database name , mysql username and password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_name", "Enter your mysql username", "Enter your mysql password");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return conn;
	}

}
