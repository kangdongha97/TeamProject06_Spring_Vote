<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="Pack01.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표화면</title>
</head>
<body>
	<jsp:useBean id="user" class="Pack01.User" scope="page"/>
	<jsp:setProperty name="user" property="*" />
	<h1>
		<center>대통령 선거</center>
	</h1>
	<form action="voting">

		<table class="sty" border='3' width="400" height="200" align="center">
			<tr>
				<td colspan='3'><label><input type="radio" name="num"
						value='1'> 1. 홍길동 </label><br /> <label><input
						type="radio" name="num" value='2'> 2. 강감찬 </label><br /> <label><input
						type="radio" name="num" value='3'> 3. 이순신 </label></td>
				<br />
			</tr>
			<tr align='center'>
				<td colspan='3'><input type="submit" value="투표"> <input
					type="submit" value="취소" onClick="location.href='redirect:index.jsp'"></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" value="<%= user.getUname()%>" name="uname">
					<input type="hidden" value="<%= user.getUtel()%>" name="utel">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>