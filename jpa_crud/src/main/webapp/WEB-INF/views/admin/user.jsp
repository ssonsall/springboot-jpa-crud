<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin User Page</title>
</head>
<body>
	<form action="/admin/update" method="post">
		<input type="text" value="${user.username}" name="username" readonly><br /> 
		<input type="hidden" value="${user.id}" name="id"/>
		<input type="hidden" value="${user.password}" name="password"/>
		<input type="hidden" value="${user.phone}" name="phone"/>
		<input type="hidden" value="${user.email}" name="email"/>
		<select name="role">
			<option value="user" >user</option>
			<option value="admin" selected>admin</option>
		</select><br/>
		<input type="text" value="변경"/>
	</form>
</body>
</html>