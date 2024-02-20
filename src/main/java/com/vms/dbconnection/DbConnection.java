package com.vms.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Database connection code
 */
public class DbConnection {
	static Connection connection=null;
	static String className="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/vms";
	static String root="root";
	// static String password="Javaraj@007";
	static String password="Historaj@007";

	public static Connection getConnection() throws ClassNotFoundException , SQLException{
		try{		
		Class.forName(className);
		connection=(Connection) DriverManager.getConnection(url,root,password);
		return connection;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return connection;	
	}

	}


