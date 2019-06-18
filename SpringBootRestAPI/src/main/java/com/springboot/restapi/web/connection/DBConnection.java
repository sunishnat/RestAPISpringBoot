package com.springboot.restapi.web.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	static Properties prop = new Properties();
	static FileInputStream fis = null;
	static Connection con = null;
	
	public static Connection getSQLConnection(){
		
		try {
			fis = new FileInputStream("src/main/resources/dbconnection.properties");
			prop.load(fis);
			Class.forName(prop.getProperty("db.sql.class"));
			String url = prop.getProperty("db.sql.url");
			String username = prop.getProperty("db.sql.username");
			String password = prop.getProperty("db.sql.password");
			con = DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
