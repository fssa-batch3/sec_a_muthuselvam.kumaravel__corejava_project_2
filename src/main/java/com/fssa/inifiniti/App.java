package com.fssa.inifiniti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class App {
	
	public static Connection getConnection() throws SQLException{

		Connection connect = null ;
//		String dbUrl;
//		String dbUser;
//		String dbPassword;
//
//		if (System.getenv("CI") != null) {
//			dbUrl = System.getenv("dbUrl");
//			dbUser = System.getenv("dbUser");
//			dbPassword = System.getenv("dbPassword");
//		} else {
//			Dotenv env = Dotenv.load();
//			dbUrl = env.get("dbUrl");
//			dbUser = env.get("dbUser");
//			dbPassword = env.get("dbPassword");
//		}
        try {
        	String passWord = "123456";
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inifiniti","root", passWord);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Unable to connect to the database");
        }
        return  connect ;                          
	}
	
}


	