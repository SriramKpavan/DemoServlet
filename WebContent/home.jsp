<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="US-ASCII">
<title>Home</title>
</head>
<body>
<h1>Home</h1>
<form action = "home" method = "post">
<div><% 	 session = request.getSession();
		String name = (String) session.getAttribute("name");
		out.println("Welcome " + name); %>
</div>
<div>
<button type = "submit" onclick = '<% session.invalidate(); %>'>Logout</button>
</div>
</form>
</body>
</html>