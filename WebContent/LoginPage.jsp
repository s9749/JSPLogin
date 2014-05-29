<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Logowanie</title> 
</head> 
<body> 
	<form method="post" action="LoginServlet"> 
	<input type="text" name="un"/>Podaj login<br> 
	<input type="password" name="pw"/>Podaj hasło<br>
	<input type="submit" value="Zaloguj"> 
	</form> 
</body> 
</html>