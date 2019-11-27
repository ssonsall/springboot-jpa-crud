<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form:form action="/board/update" method="PUT">
		<input type="hidden" name="id" value="${board.id}">
		<table>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<td>Content</td>
				<td><textarea rows="5" cols="40" name="content">${board.content}</textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정완료" />
	</form:form>
</body>
</html>

	