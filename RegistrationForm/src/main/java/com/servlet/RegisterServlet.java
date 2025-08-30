package com.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.User;
import com.dao.UserDao;
import com.dao.UserDaoImplement;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	private static UserDao userDao = new UserDaoImplement();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username= req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String gender = req.getParameter("gender");
		String joiningDate = req.getParameter("joiningDate");
		String address = req.getParameter("address");
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setContact(contact);
		user.setGender(gender);
		user.setJoiningDate(Date.valueOf(joiningDate));
		user.setAddress(address);
		
		
		try {
			if(userDao.addUser(user)) {
				if(username.equals("admin")) {
					HttpSession session = req.getSession();
					session.setAttribute("username",username);			
					res.sendRedirect("UserListServlet");
				}
				else if(userDao.isValid(username,password)) {
					HttpSession session = req.getSession();
					session.setAttribute("username",username);			
					res.sendRedirect("Welcome.jsp");
					
				}else {
					res.sendRedirect("login.jsp?error=1");
					System.out.println("error occured");
				}
//				res.sendRedirect("Welcome.jsp?registration=success");
			}else {
				res.sendRedirect("Welcome.jsp?registration=error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
