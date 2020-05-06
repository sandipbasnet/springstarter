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
	
	public boolean registerUser(String username, String dob, String gender, String email, String password) {
		boolean isSaved = false;
		Connection conn = new DBConnection().getDbConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users_tbl(username, email, password, gender, dob) VALUES (?,?,?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, gender);
			pstmt.setString(5, dob);
			int i = pstmt.executeUpdate();
			if(i>0) {
				isSaved = true;
			}
			
		}catch(Exception e) {
			System.err.println("Exception during new user registration");
		}
		return isSaved;
	}

}
