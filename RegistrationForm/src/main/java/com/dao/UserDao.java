package com.dao;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	public boolean addUser(User user) throws SQLException;
	public boolean isValid(String username, String password);
	public List<User> getAllUsers();
}
