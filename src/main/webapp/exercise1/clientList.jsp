<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
</head>
<body>
	<h1>Clients</h1>
    <table>
         <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <c:forEach var="cur" items="${clientList}">
            <tr>
                <td>${cur.id}</td>
                <td>${cur.name}</td>
            </tr>
        </c:forEach>
    </table>

  <%@include file="/backHome.html"%>
</body>
</html>