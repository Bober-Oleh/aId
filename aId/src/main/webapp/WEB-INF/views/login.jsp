<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: #808080 url(C:/Users/Ирина/Desktop/Олег/eclipse/aId/images/mountain.jpg);
	color: #000; 
	background-attachment: fixed;
	background-repeat: repeat-x;
	background-size: 100%;
}
</style>
</head>
<body>


	<div align="center" style="padding-top: 10%">
		<p>Login</p>
	</div>

	<div align="center" style="padding-top: 20px">
		<form action="/aId/login" method="POST">
			<p>
				<input type="text" name="userEmail" placeholder="Your email" />
			</p>
			<p>
				<input type="password" name="userPassword"
					placeholder="Your password" />
			</p>
			<p>
				<input type="submit" value="Send" />
			</p>
		</form>

	</div>

	  <div align="center" style="padding-top: 20px; color: red">
		${errorMessage }</div>


</body>
</html>