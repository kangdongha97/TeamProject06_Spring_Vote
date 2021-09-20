<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
<style>

</style>
</head>
<body>
	<h1><center>대통령 선거</center></h1>
	<form action="checkInfo">
		<table border="3"  width ="400" height="200" align = "center" >
			<tr>
				<td>이름:</td>
				<td><input type="text" name=uname value='강동하'></td>
			</tr>
			<tr>
				<td>휴대폰 번호:</td>
				<td><input type="text" name=utel value=01011112222></td>
			</tr>
			<tr align='center'>
				<td colspan='2' align='center'><input type="submit" value="제출">
				</td>
			</tr>
		</table>
		
	</form>
</body>
