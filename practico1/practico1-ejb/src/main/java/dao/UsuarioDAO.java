package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import entity.Usuario;


@Singleton
@LocalBean
public class UsuarioDAO implements UsuarioDAORemote, UsuarioDAOLocal {
	
	List<Usuario> usuarios = new ArrayList<Usuario>();

   
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
	public List<Usuario> obtenerUsuarios() {
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

	@Override
	public void agregarDatos() {
		Usuario user1 = new Usuario(33333333, "Juan", "Perez");
		Usuario user2 = new Usuario (55555555, "Maria", "Ines");
		Usuario user3 = new Usuario (50446656, "Agustina", "Corvo");
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
	}

	@Override
	public void borrarUsuario(int cedula) {
		if (existeUsuario(cedula)) {
			Usuario aux = obtenerUsuario(cedula);
			usuarios.remove(aux);
		}		
	}

	@Override
	public void editarUsuario(int cedula, String nombre, String apellido) {
		if (existeUsuario(cedula)) {
			Usuario aux = obtenerUsuario(cedula);
			aux.setNombre(nombre);
			aux.setApellido(apellido);		
		}		
	}

	

	
}
