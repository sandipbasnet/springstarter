package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.utility.DBConnection;

public class UserDao {
	public String getPassword(String email) {
		String passFromDb="";
		Connection conn = new DBConnection().getDbConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT password from users_tbl where email=?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				passFromDb = rs.getString("password");
			}
		} catch (SQLException e) {
			System.err.println("Exception during password retrieval" +e.getMessage());
			e.printStackTrace();
		}
		
		return passFromDb;
	}

}
