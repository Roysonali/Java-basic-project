<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

        
</head>
<body>
	<form action="RegisterServlet" method="post">
		<h1>Register</h1>
		<label>Username</label><br>
		<input type="text" name="username"><br>
		<label>Password</label><br>
		<input type="password" name="password"><br>
		<label>email</label><br>
		<input type="email" name="email"><br>
		<label>Contact</label><br>
		<input type="text" name="contact"><br>
		<p>Select Gender:</p>
		  <input type="radio" id="male" name="gender" value="male">
		  <label for="male">Male</label><br>
		  <input type="radio" id="female" name="gender" value="female">
		  <label for="female">Female</label><br>
		  <input type="radio" id="other" name="gender" value="other">
		  <label for="other">Other</label><br>
		 <label>JoinigDate</label><br>
		 <input type="date" name="joiningDate"><br>
		 <label>Address</label><br>
		 <input type="text" name="address"><br><br>
		<button type="Submit" value="submit">Submit</button>
		<input type="reset" value="reset">
	</form>
	<p><a href="index.html">Back to Home</a></p>
</body>
</html>