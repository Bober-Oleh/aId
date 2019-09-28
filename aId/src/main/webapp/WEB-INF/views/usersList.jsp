<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Congrads! You are logged in! ${session.userEmail}
	<p>${loogedInUser.idRole == 0}</p>


	<div>
		<mytag:userList coll = "${users}"></mytag:userList>
	</div>
</body>
</html>