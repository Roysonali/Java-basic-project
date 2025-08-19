<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="indexStyle.css">
</head>
<body>

<%
	HttpSession session1 = request.getSession(false);
	String username = null;
	
	if(session1 != null && session1.getAttribute("username") != null){
		username = (String) session1.getAttribute("username");
	
%>
	<div class="container">
		<h1>Welcome, <%= username %>!</h1>
		<h3>I am building this project to enhance my skills and apply all my knowledge at one place.</h3>
		<p>Frontend technologies: HTML, CSS</p>
		<p>Backend technologies: JSP,Servlet, JDBC</p>
		<p>Explore, learn, and connect</p>
		<p>Feel free to Login or Register to get Started!</p>
		<p id="logout">you can <a href="logout.jsp" style=text-decoration:none>LOGOUT</a> securely</p>
	</div>
	
<%} else{
	response.sendRedirect("login.jsp");
}
	
	%>
</body>
</html>