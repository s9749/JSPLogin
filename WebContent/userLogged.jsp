<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.jsplogin.service.BeanUser" %> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
 <html> 
 <head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
 <title> Zalogowano </title> 
 </head> 
 <body> 

<jsp:useBean id="currentUser" class="org.jsplogin.service.BeanUser" scope="session">
	<jsp:setProperty property="*" name="currentUser" />
</jsp:useBean>
 	<center> 
 		Witaj <jsp:getProperty property="firstName" name="currentUser"/>
 	</center>
 </body> 
 </html>