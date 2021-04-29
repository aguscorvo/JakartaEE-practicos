package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.UsuarioBusinessLocal;


@WebServlet("/CargarDatosServlet")
public class CargarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
    UsuarioBusinessLocal usuarioBusiness;
    
    public CargarDatosServlet() {
        super();
   }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		usuarioBusiness.agregarDatos();
		request.getRequestDispatcher("JSP.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
