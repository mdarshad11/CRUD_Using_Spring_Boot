<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome Home user!!</h1>
	<form action="signup" method="post">
		Enter Student Id:<input type="text" name="id"><br> Enter
		Students Name:<input type="text" name="name"> <br> Enter
		Student Password:<input type="text" name="password"> <br>
		Submit: <input type="submit">
	</form>
	<hr>
	<hr>
	<hr>
	<form action="passwordupdate" method="post">
		Enter f Id:<input type="text" name="id"><br> Enter Price:<input
			type="text" name="password"> <br> Submit: <input
			type="submit">
	</form>
	<hr>
	<hr>
	<hr>
	<form action="deleteObj">
		Enter first Id:<input type="text" name="id"><br> Submit:
		<input type="submit">
	</form>
	<hr>
	<hr>
	<hr>
	<form action="readObj">
		Enter first Id:<input type="text" name="id"><br> Submit:
		<input type="submit">
	</form>
</body>
</html>