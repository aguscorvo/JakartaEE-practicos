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

@WebServlet("/BuscarUsuarioServlet")
public class BuscarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    UsuarioBusinessLocal usuarioBusiness;
   
    public BuscarUsuarioServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cedula = Integer.valueOf(request.getParameter("cedula"));
		DtUsuario usuarioEncontrado = usuarioBusiness.obtenerUsuario(cedula);
				
		if(usuarioEncontrado != null) {
			request.setAttribute("cedula", usuarioEncontrado.getCedula());
			request.setAttribute("nombre", usuarioEncontrado.getNombre());
			request.setAttribute("apellido", usuarioEncontrado.getApellido());
		}else {
			request.setAttribute("mensaje", "Usuario no registrado");
		}			
		
		request.getRequestDispatcher("buscarUsuario.jsp").forward(request, response);
		
	}

}
