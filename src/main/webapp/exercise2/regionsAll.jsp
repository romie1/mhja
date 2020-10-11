<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Regions</title>
</head>
<body>
	<h1> All Regions</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Countries</th>
		</tr>
		<c:forEach var="region" items="${regions}">
			<tr>
				<td>${region.name}</td>
				<td><c:forEach var="country" items="${region.countries}">
						<ul>
							<li>Id: ${country.name}
							</li>
						</ul>
					</c:forEach></td>
				
			</tr>
		</c:forEach>
		</table>
		<%@include file="/backHome.html"%>
</body>
</html>