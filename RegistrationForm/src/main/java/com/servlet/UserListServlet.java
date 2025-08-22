package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.User;
import com.dao.UserDao;
import com.dao.UserDaoImplement;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet{
	private static UserDao userdao = new UserDaoImplement();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<User> users = userdao.getAllUsers();
		
		req.setAttribute("userList", users);
		req.getRequestDispatcher("userlist.jsp").forward(req, res);
		
	}

}
