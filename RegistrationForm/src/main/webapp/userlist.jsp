<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.dao.User" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<style>
table { 
	        border-collapse: collapse; 
	        width: 80%; 
	        margin: 20px auto; 
        }
        th, td {
	         border: 1px solid #333; 
	         padding: 8px; 
	         text-align: center; 
         }
        th {
         	background-color: #f2f2f2; 
         }
         #logout{
         text-align:center;
         }
    </style>
</head>
<body>
	<h2>Registered User</h2>
	<table>
		<tr>
			 <th>Username</th>
            <th>Password</th> <!-- ⚠ Not recommended, better hide -->
            <th>Email</th>
            <th>Contact</th>
            <th>Gender</th>
            <th>Joining Date</th>
            <th>Address</th>
		</tr>
		<%
			List<User> userList =(List<User>)request.getAttribute("userList");
			if(userList != null){
				for(User u: userList){
		%>
		<tr>
			<td><%= u.getUsername() %></td>
			<td><%= u.getPassword() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getContact() %></td>
            <td><%= u.getGender() %></td>
            <td><%= u.getJoiningDate() %></td>
            <td><%= u.getAddress() %></td>
		</tr>
		<% 		}
			}
		%>
	</table>
	<p id="logout">you can <a href="logout.jsp" style=text-decoration:none>LOGOUT</a> securely</p>
</body>
</html>