package ws;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import business.UsuarioBusinessLocal;
import dt.DtUsuario;
import exception.RegistroUsuarioException;

@WebService
public class UsuarioSoap {
	
	@EJB
    UsuarioBusinessLocal usuarioBusiness;

	@WebMethod
    public void agregarUsuario(DtUsuario usuario) throws RegistroUsuarioException {
    	usuarioBusiness.agregarUsuario(usuario);
    }
    
	@WebMethod
    public List<DtUsuario> obtenerUsuarios(){
		return usuarioBusiness.obtenerUsuarios();
    }
    
	@WebMethod
    public DtUsuario obtenerUsuario(int cedula) throws RegistroUsuarioException {
		return usuarioBusiness.obtenerUsuario(cedula);
    		
    }

	@WebMethod
	public void borrarUsuario(int cedula) throws RegistroUsuarioException {
		usuarioBusiness.borrarUsuario(cedula);		
	}

	@WebMethod
	public void editarUsuario(DtUsuario usuario) throws RegistroUsuarioException {
		usuarioBusiness.editarUsuario(usuario);
	}

}
