package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean isValidUser(String username, String password) {
		String query = "SELECT * FROM users where username=? and password=?;";
		try(Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			ps.setString(1,username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			return rs.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addUser(User user) {
		String query = "INSERT INTO users(username,password,email) VALUES (?,?,?);";
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(query)){
				System.out.println("get connection");
				ps.setString(1,user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				
				int rowsAffected = ps.executeUpdate();
				return rowsAffected > 0;
				
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
