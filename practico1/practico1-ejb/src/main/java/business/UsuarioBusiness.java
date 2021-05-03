package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.UsuarioDAOLocal;
import dt.DtUsuario;
import entity.Usuario;
import exception.RegistroUsuarioException;


@Stateless
@LocalBean
public class UsuarioBusiness implements UsuarioBusinessRemote, UsuarioBusinessLocal {

	@EJB
	UsuarioDAOLocal usuarioDAO;
    
    public UsuarioBusiness() {}
    
    @Override
    public void agregarUsuario(DtUsuario usuario) throws RegistroUsuarioException {
    	Usuario aux = usuarioDAO.obtenerUsuario(usuario.getCedula());
    	if (aux!=null) {
    		throw new RegistroUsuarioException("ERROR: Ya existe un usuario registrado con cédula " 
    				+ usuario.getCedula(), RegistroUsuarioException.USUARIO_REGISTRADO );
    	}else {
    	
	    	Usuario nuevoUsuario = new Usuario (usuario.getCedula(), usuario.getNombre(), usuario.getApellido());
	    	usuarioDAO.agregarUsuario(nuevoUsuario);
    	}
    }
    
	@Override
    public List<DtUsuario> obtenerUsuarios(){
    	List<Usuario> usuarios= usuarioDAO.obtenerUsuarios();
    	List<DtUsuario> aDevolver = new ArrayList<DtUsuario>();
    	DtUsuario aux;
    	for(Usuario u: usuarios) {
    		aux = new DtUsuario (u.getCedula(), u.getNombre(), u.getApellido());
    		aDevolver.add(aux);
    	}
    	return aDevolver;
    }
    
    @Override
    public DtUsuario obtenerUsuario(int cedula) throws RegistroUsuarioException {
    	Usuario aux = usuarioDAO.obtenerUsuario(cedula);
    	DtUsuario aDevolver =null;

    	if (aux==null) {
    		throw new RegistroUsuarioException("ERROR: No existe un usuario registrado con cédula " 
    				+ cedula, RegistroUsuarioException.USUARIO_NO_REGISTRADO );
    	}else {
        	aDevolver = new DtUsuario (aux.getCedula(), aux.getNombre(), aux.getApellido());    		
    	}
    	
    	return aDevolver;
    		
    }

	@Override
	public void borrarUsuario(int cedula) throws RegistroUsuarioException {
		Usuario aux = usuarioDAO.obtenerUsuario(cedula);

    	if (aux==null) {
    		throw new RegistroUsuarioException("ERROR: No existe un usuario registrado con cédula " 
    				+ cedula, RegistroUsuarioException.USUARIO_NO_REGISTRADO );
    	}else {
    		usuarioDAO.borrarUsuario(cedula);
    	}
		
	}

	@Override
	public void editarUsuario(DtUsuario usuario) throws RegistroUsuarioException {
		Usuario aux = usuarioDAO.obtenerUsuario(usuario.getCedula());
		
		if (aux==null) {
    		throw new RegistroUsuarioException("ERROR: No existe un usuario registrado con cédula " 
    				+ usuario.getCedula(), RegistroUsuarioException.USUARIO_NO_REGISTRADO );
    	}else {
    		Usuario usuarioModificado = new Usuario (usuario.getCedula(), usuario.getNombre(), 
    				usuario.getApellido());
//    		aux.setNombre(usuario.getNombre());
//    		aux.setApellido(usuario.getApellido());
    		usuarioDAO.editarUsuario(usuarioModificado);
    	}
	}
    

}
