<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="US-ASCII">
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<form action="register" method="post">
		<div class="container">
			<label for="name"><b>Name</b></label> <input type="text"
				placeholder="Enter Fullname" name="name" required>
		</div>
		<div>
			<label for="num"><b>Phone Number</b></label> <input type="text"
				placeholder="Enter Your phone number" name="num" required>
		</div>
		<div>
			<label for="uname"><b>Create UserName</b></label> <input type="text"
				placeholder="Enter Username" name="uname" required>
		</div>
		<div>
			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" required>
		</div>
		<div>
			<label for="psw1"><b>Confirm Password</b></label> <input
				type="password" placeholder="Re-Enter Password" name="psw1" required>
		</div>
		<%-- <div><% if(request.getParameter(psw).equals(request.getParameter(psw1))) { out.println("Passwords don't match");} %></div> --%>
		<div>
			<button type="submit">Register</button>
		</div>
		<div>
			<button type="button" onclick='location.href = "login.jsp"'>Back
				to Login</button>
		</div>
	</form>
</body>
</html>