<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>

<head>
<title>메인 페이지</title>
</head>
<body>
	<h1>대통령 선거</h1>
	<form method="post" action="checkInfo">
	
		<table>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="uname" value='tiger'></td>
			</tr>
			<tr>
				<td>휴대폰 번호:</td>
				<td><input type="text" name="utel" value='01011112222'></td>
			</tr>
			<tr align='center'>
				<td colspan='2' align='center'>
					<input type="submit" value="제출">
				</td>
			</tr>
		</table>
	</form>
</body>