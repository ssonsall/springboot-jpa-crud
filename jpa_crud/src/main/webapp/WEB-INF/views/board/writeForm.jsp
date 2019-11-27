<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="/board/write" method="post">
		<table>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Content</td>
				<td>
					<textarea rows="5" cols="40" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글쓰기완료"></td>
			</tr>
		</table>
	</form>


</body>

</html>