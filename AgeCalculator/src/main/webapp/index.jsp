<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Age calculator</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="container">
			<h1>Age Calculator</h1>
			<form action="ageCalculator" method="post">
				<div class="form-group">
					<label for="birthdate">Enter birthdate:</label>
					<input type="date" name="dob" value="<%= request.getParameter("dob")!= null ? request.getParameter("dob"):"" %>" placeholder="DD-MM-YYYY" required>
				</div>
				<div class="form-group">
					<button type="submit">Calculate Age</button>
					<a href="index.jsp">Reset</a>				
				</div>
			</form>
			<%
				String result = (String) request.getAttribute("ageResult");
				if(result != null){
			
			%>
				<div class="result-container">
					<div class="result" id="result">
						<div class="result-item">
							<h3>Result:</h3>
							<p><%= result %></p>
						</div>
					</div>
					
				</div>
			
				
				<%
					}
				%>
				
	</div>
	
	
	
</body>
</html>