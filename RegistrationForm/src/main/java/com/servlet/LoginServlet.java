package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImplement;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	private static UserDao userDao =  new UserDaoImplement();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(userDao.isValid(username,password)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);			
			res.sendRedirect("UserListServlet");
			
		}else {
			res.sendRedirect("login.jsp?error=1");
			System.out.println("error occured");
		}
	
	}
}
