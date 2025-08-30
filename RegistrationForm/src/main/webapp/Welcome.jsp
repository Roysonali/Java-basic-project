<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<%
		String username = (String)session.getAttribute("username");
	%>
	<div class="container">
		<h1>Welcome <%=username %></h1>
		<h3>I am building this project to enhance my skills and apply all my knowledge at one place.</h3>
		<p>Frontend technologies: HTML, CSS</p>
		<p>Backend technologies: JSP,Servlet, JDBC</p>
		<p>Explore, learn, and connect</p>
		<p>Feel free to Login or Register to get Started!</p>
		<p id="logout">you can <a href="logout.jsp" style=text-decoration:none>LOGOUT</a> securely</p>
	</div>
</body>
</html>