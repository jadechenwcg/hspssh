<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Go though List Employye Ui</h1>
 <table>
 <tr><td>id</td><td>name</td><td>email</td><td>grade</td><td>salary</td><td>edit</td><td>reset</td></tr>
 <c:forEach items="${emplist}" var="emp" >
 	<tr><td>${emp.id}</td><td>${emp.name}</td><td>${emp.email}</td><td>${emp.grade}</td><td>${emp.salary}</td><td><a href="#">edit</a></td><td><a href="#">reset</a></td></tr>
 </c:forEach>
 </table>
 
 <c:forEach var="i" begin="1" end="${pageCount}">
 	<a href="${pageContext.request.contextPath}/employee.do?flag=goListEmp&pageNow=${i}">${i }</a>
 </c:forEach>
</body>
</html>