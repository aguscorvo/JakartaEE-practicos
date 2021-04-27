<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar usuarios</title>
</head>
<body>
<h1>VACUNAS.UY - LISTAR USUARIOS</h1>

<table border="1">
	<thead>
		<tr>
			<th>Cédula</th>
			<th>Nombre</th>
			<th>Apellido</th>
		</tr>
	</thead>
		
	<c:forEach items="${asd}" var="usuario">
	<tr>
		<td>${usuario.cedula}</td>
		<td>${usuario.nombre}</td>
		<td>${usuario.apellido}</td>			
	</tr>
	</c:forEach>
</table>
<p><a href="JSP.jsp">Volver atrás</a></p>		


</body>
</html>