<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
	<h1>Login</h1>
		<form action="LoginServlet" method="post">
		<label>Username</label><br>
		<input type="text" name="username"><br>
		<label>Password</label><br>
		<input type="password" name="password"><br><br>
		<button type="Submit" value="submit">Submit</button>
		</form>
		<p><a href="index.html">Back to Home</a></p>
	</div>
	
	<% String error = request.getParameter("error"); 
		if(error!=null && error.equals("1")){%>
		<p style="color: red">Invalid username or password.please try again</p>
			
	<% } %>
	
	
</body>
</html>