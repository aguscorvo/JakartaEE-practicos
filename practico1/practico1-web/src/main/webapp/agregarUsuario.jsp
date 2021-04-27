<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar usuario</title>
</head>
<body>
	<h1>VACUNAS.UY - AGREGAR USUARIO</h1>
	<form action="AgregarUsuarioServlet" method="POST">
      <input
            aria-label="Cedula"
            class="input"
            type="number"
            placeholder="Cédula"
            name="cedula"
            required
          />
          <input
            aria-label="Nombre"
            class="input"
            type="text"
            placeholder="Nombre"
            name="nombre"
            required            
          />
          <input
            aria-label="Apellido"
            class="input"
            type="text"
            placeholder="Apellido"
            name="apellido" 
            required           
          />
         <button type="submit">Agregar usuario</button>
    </form>
    <p>${mensaje}</p>
    <p><a href="JSP.jsp">Volver atrás</a></p>		
    

</body>
</html>