<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client</title>
</head>
<body>
	<h2>Hello client ${client.get().name}! Welcome!</h2>

	<%@include file="/backHome.html"%>
</body>
</html>