<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar usuarios</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>Cédula</th>
				<th>Nombre</th>
				<th>Apellido</th>
			</tr>
		</thead>
		
		<c:forEach items="${usuarios}" var="usuario">
		<tr>
			<td>${usuario.cedula}</td>
			<td>${usuario.nombre}</td>
			<td>${usuario.apellido}</td>			
		</tr>
		</c:forEach>
			
	</table>

</body>
</html>