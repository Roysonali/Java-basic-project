package com.servlet;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	private static UserDao userDao = new UserDaoImpl();
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		if(userDao.addUser(user)) {
			res.sendRedirect("login.jsp?registration=success");
		}else {
			res.sendRedirect("login.jsp?registration=error");
		}
		
		
		
	}
}
