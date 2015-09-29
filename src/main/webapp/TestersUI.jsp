<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       
       
<%@page import = "com.franconnect.baseutils.ABC"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Interface</title>

</head>
<body>
<h1>Manage AutoProject</h1>

<form name="tester-ui">
<table border=1>
<tr>
	<td><b>Enter Package Name</b></td>
	<td><input type="text" name = "package-name"></td>
</tr>

<tr>
	<td><b>Enter Class Name</b></td>
	<td><input type="text" name = "class-name"></td>
</tr>

<tr>
	<td><b>Enter Method Name</b></td>
	<td><input type="text" name = "method-name"></td>
</tr>

<tr>
	<td></td>
	<td>
	<button onclick="add()">Click me</button></td>
</tr>

<% 
	out.println("Your IP address is "+request.getRemoteAddr()); 
%>

<% 
	out.println("Current Date: "+new java.util.Date()); 
%>


</table>

</form>

</body>
</html>