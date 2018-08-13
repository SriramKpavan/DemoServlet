<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="US-ASCII">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="login" method="post">
		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="uname" required>
		</div>
		<div>
			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" required>
		</div>
		<div>
			<label>
				<button type="submit">Login</button>
			</label>
		</div>
		 <%--  <% String i =(String) request.getAttribute("error") ;
                   if(i.equals("1")) {
                          out.println("Give valid inputs"); }
                  else if( i.equals("2")) {
                          out.println("Invalid Username or Password"); } %> --%>
		<div>
			<p>
				<strong>Not a member? Register in a few quick steps</strong>
			</p>
		</div>
	</form>
	<button type="button" onclick='location.href = "Register.jsp"'>Register</button>
</body>
</html>