<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Interface</title>

</head>
<body>
<h1>Manage AutoProject</h1>

<form>
<table style="width:40%" border=1>
<tr>
	<td><b>Enter Package Name</b></td>
	<td><input type="text" name = "classname"></td>
</tr>

<tr>
	<td><b>Enter Class Name</b></td>
	<td><input type="text" name = "classname"></td>
</tr>

<tr>
	<td><b>Enter Method Name</b></td>
	<td><input type="text" name = "methodname"></td>
</tr>

<tr>
	<td></td>
	<td><input type="button" name="Submit" value= "Create"></td>
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