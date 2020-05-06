package com.example.demo.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
public Connection getDbConnection() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdemo", "kaji","W0rk@hard");
	} catch(Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
