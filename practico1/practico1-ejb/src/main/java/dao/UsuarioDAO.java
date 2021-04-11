package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import dt.DtUsuario;
import entity.Usuario;


@Singleton
@LocalBean
public class UsuarioDAO implements UsuarioDAORemote, UsuarioDAOLocal {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

   
    public UsuarioDAO() {}
    
	public boolean existeUsuario(int cedula) {
    	for (Usuario u: usuarios) {
    		if (u.getCedula() == cedula)
    			return true;
    	}
    	return false;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		if (!existeUsuario(usuario.getCedula())) {
			usuarios.add(usuario);
		}		
	}

	@Override
	public ArrayList<Usuario> obtenerUsuarios() {
		return usuarios;
	}

	@Override
	public Usuario obtenerUsuario(int cedula) {
		if (existeUsuario(cedula)) {
			for (Usuario u: usuarios) {
				if (u.getCedula() == cedula)
					return u;
			}
		}
		return null;
	}

	

	
}
