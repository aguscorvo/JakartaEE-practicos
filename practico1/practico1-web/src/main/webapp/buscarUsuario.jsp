<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar usuario</title>
</head>
<body>
<h1>VACUNAS.UY - BUSCAR USUARIO</h1>

	<form action="BuscarUsuarioServlet" method="POST">
      <input
            aria-label="Cedula"
            class="input"
            type="number"
            placeholder="Cédula"
            name="cedula"
            required
      />          
      <button type="submit">Buscar usuario</button>
    </form>
    
    <p style="color:red">${mensaje}</p>
    
    
    <div style="margin-top: 10px">
	    <table border="1">
			<thead>
				<tr>
					<th>Cédula</th>
					<th>Nombre</th>
					<th>Apellido</th>
				</tr>
			</thead>
			<tr>
				<td>${cedula}</td>
				<td>${nombre}</td>
				<td>${apellido}</td>			
			</tr>			
		</table>
	</div>
	
	<p><a href="JSP.jsp">Volver atrás</a></p>		
	

</body>
</html>