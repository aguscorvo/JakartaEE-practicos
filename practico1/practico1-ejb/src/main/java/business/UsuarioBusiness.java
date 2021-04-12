package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UsuarioDAOLocal;
import dt.DtUsuario;
import entity.Usuario;


@Stateless
@LocalBean
public class UsuarioBusiness implements UsuarioBusinessRemote, UsuarioBusinessLocal {

	@EJB
	UsuarioDAOLocal usuarioDAO;
    
    public UsuarioBusiness() {}
    
    @Override
    public void agregarUsuario(DtUsuario usuario) {
    	Usuario nuevoUsuario = new Usuario (usuario.getCedula(), usuario.getNombre(), usuario.getApellido());
    	usuarioDAO.agregarUsuario(nuevoUsuario);
    }
    
	@Override
    public ArrayList<DtUsuario> obtenerUsuarios(){
    	ArrayList<Usuario> usuarios= usuarioDAO.obtenerUsuarios();
    	ArrayList<DtUsuario> aDevolver = new ArrayList<DtUsuario>();
    	DtUsuario aux;
    	for(Usuario u: usuarios) {
    		aux = new DtUsuario (u.getCedula(), u.getNombre(), u.getApellido());
    		aDevolver.add(aux);
    	}
    	return aDevolver;
    }
    
    @Override
    public DtUsuario obtenerUsuario(int cedula) {
    	Usuario aux = usuarioDAO.obtenerUsuario(cedula);
    	DtUsuario aDevolver = new DtUsuario (aux.getCedula(), aux.getNombre(), aux.getApellido());
    	return aDevolver;
    }

	@Override
	public void agregarDatos() {
		usuarioDAO.agregarDatos();
	}

	@Override
	public void borrarUsuario(int cedula) {
		usuarioDAO.borrarUsuario(cedula);
	}

	@Override
	public void editarUsuario(int cedula, String nombre, String apellido) {
		usuarioDAO.editarUsuario(cedula, nombre, apellido);
	}
    

}
