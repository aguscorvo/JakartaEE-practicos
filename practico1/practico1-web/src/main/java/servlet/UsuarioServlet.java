package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
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
    private UsuarioBusinessLocal usuarioBusiness;
    
    private ArrayList<DtUsuario> usuarios;
    
    public UsuarioServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuarioBusiness.agregarDatos();
		usuarios = usuarioBusiness.obtenerUsuarios();
		request.setAttribute("usuarios", usuarios);
		
		request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
