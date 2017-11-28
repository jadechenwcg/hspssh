<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	<h1>Admin Login</h1>
	<form action="/hspssh/login.do?flag=login" method="post">
		id  :<input type="text" name="id"/><br/>
		pw :<input type="password" name="pwd" /><br/>
		<input type="submit" value="De Lu" />
		<input type="reset" value="Set It Again" />		
	</form>
</body>
</html>