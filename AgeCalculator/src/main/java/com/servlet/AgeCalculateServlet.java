package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ageCalculator")
public class AgeCalculateServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String dob = req.getParameter("dob");
		
		if((dob!=null) &&!(dob.isEmpty())){
			LocalDate birthdate = LocalDate.parse(dob);
			LocalDate currentdate = LocalDate.now();
			
			Period age = Period.between(birthdate, currentdate);
			
			String result = "Your age is: " + age.getYears() + " years, " 
                    + age.getMonths() + " months, and " 
                    + age.getDays() + " days.";
			
			req.setAttribute("ageResult", result);
		}else {
			req.setAttribute("ageResult", "Please enter a valid date of birth!");
			
		}
		req.getRequestDispatcher("index.jsp").forward(req,res);
	}

}
