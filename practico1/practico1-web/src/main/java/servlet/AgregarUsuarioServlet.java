package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UsuarioBusinessLocal;
import dt.DtUsuario;
import exception.RegistroUsuarioException;


@WebServlet("/AgregarUsuarioServlet")
public class AgregarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@EJB
    UsuarioBusinessLocal usuarioBusiness;
	
    public AgregarUsuarioServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cedula = Integer.valueOf(request.getParameter("cedula"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		DtUsuario nuevoUsuario = new DtUsuario(cedula, nombre, apellido);
		
		try {
			usuarioBusiness.agregarUsuario(nuevoUsuario);
			String mensaje = "El usuario con cédula "+ cedula + " fue creado exitosamente.";
			request.setAttribute("mensaje", mensaje);
		} catch (RegistroUsuarioException e) {
//			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.getRequestDispatcher("agregarUsuario.jsp").forward(request, response);		

	}

}
