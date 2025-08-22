package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBUtil;

public class UserDaoImplement implements UserDao{

	@Override
	public boolean addUser(User user) throws SQLException {
		String query = "INSERT INTO users(username,password,email,contact,gender,joiningDate,address)VALUES(?,?,?,?,?,?,?);";
		try(Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1, user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getEmail());
			ps.setString(4, user.getContact());
			ps.setString(5, user.getGender());
			ps.setDate(6, user.getJoiningDate());
			ps.setString(7,user.getAddress());
		
			int rowsAffected = ps.executeUpdate();
			return rowsAffected>0;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean isValid(String username, String password) {
		String query = "select * from users where username=? and password=?";
		
		try(Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1,username);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			return rs.next();
			
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList();
		String query = "SELECT username, password, email, contact, gender, joiningDate, address FROM users";
		
		try(Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query)){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user =new User();
				
				user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setEmail(rs.getString("email"));
	            user.setContact(rs.getString("contact"));
	            user.setGender(rs.getString("gender"));
	            user.setJoiningDate(rs.getDate("joiningDate"));
	            user.setAddress(rs.getString("address"));
	            
	            users.add(user);
			}
			
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		return users;
	}

	
}
