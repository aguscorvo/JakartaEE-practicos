package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UsuarioBusinessLocal;
import dt.DtUsuario;


@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    UsuarioBusinessLocal usuarioBusiness;
    
    private List<DtUsuario> usuarios;
    
    public UsuarioServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuarioBusiness.agregarDatos();
		usuarios = usuarioBusiness.obtenerUsuarios();
		//request.setAttribute("usuarios", usuarios);
		
		for(int i=0; i<usuarios.size();i++) {
			System.out.println(usuarios.get(i));
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuarios.jsp");
		request.setAttribute("usuarios", usuarios);
		dispatcher.forward(request, response);
		//request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
