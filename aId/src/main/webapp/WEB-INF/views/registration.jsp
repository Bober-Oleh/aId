<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration of new user</title>
<style>
body {
	background: #808080 url(C:/Users/Ирина/Desktop/Олег/eclipse/aId/images/balloons.jpg);
	color: #fff; 
	background-attachment: fixed;
	background-repeat: repeat-x;
	background-size: 100%;
}
</style>
</head>
<body>
	<div align="center" style="padding-top: 10%">
		<p>Registration</p>
	</div>

	<div align="center" style="padding-top: 20px">
		<form action="/aId/registration" method="POST">
			<p>
				<input type="text" name="firstName" placeholder="Your firstName" />
			</p>
			<p>
				<input type="text" name="lastName" placeholder="Your lastName" />
			</p>
			<p>
				<input type="text" name="dateBirthday"
					placeholder="Your dateBirthday" />
			</p>
			<p>
				<input type="text" name="email" placeholder="Your email" />
			</p>
			<p>
				<input type="password" name="userPassword"
					placeholder="Your password" />
			</p>
			<p>
				<input type="text" name="idRole" placeholder="Your idRole" />
			</p>
			<p>
				<input type="text" name="toursNumber" placeholder="Your toursNumber" />
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