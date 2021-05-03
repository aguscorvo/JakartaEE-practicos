package ws;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.UsuarioBusinessLocal;
import dt.DtUsuario;
import exception.RegistroUsuarioException;

@RequestScoped
@Path("/service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UsuarioRest {

	@EJB
    UsuarioBusinessLocal usuarioBusiness;
	
	public UsuarioRest() throws NamingException{		
	}
	
	@POST
	@Path("/usuarios")
    public void agregarUsuario(DtUsuario usuario) throws RegistroUsuarioException {
    	usuarioBusiness.agregarUsuario(usuario);
    }
    
	@GET
	@Path("/usuarios")
    public List<DtUsuario> obtenerUsuarios(){
		return usuarioBusiness.obtenerUsuarios();
    }
    
	@GET
	@Path("/usuarios/{cedula}")
    public DtUsuario obtenerUsuario(@PathParam("cedula")int cedula) throws RegistroUsuarioException {
		return usuarioBusiness.obtenerUsuario(cedula);
    		
    }

	@DELETE
	@Path("/usuarios/{cedula}")
	public void borrarUsuario(@PathParam("cedula") int cedula) throws RegistroUsuarioException {
		usuarioBusiness.borrarUsuario(cedula);		
	}

	@PUT
	@Path("/usuarios")
	public void editarUsuario(DtUsuario usuario) throws RegistroUsuarioException {
		usuarioBusiness.editarUsuario(usuario);
	}

}
