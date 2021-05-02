package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Usuario;


@Singleton
@LocalBean
public class UsuarioDAO implements UsuarioDAORemote, UsuarioDAOLocal {
	
//	List<Usuario> usuarios = new ArrayList<Usuario>();
	boolean datosCargados = false;
	
	@PersistenceContext(name = "tse")
	private EntityManager em;
   
    public UsuarioDAO() {}
    
	public boolean existeUsuario(int cedula) {
		Usuario aux = new Usuario();
		aux = em.find(Usuario.class, cedula);
		if (aux!=null)
			return true;
		return false;
//    	for (Usuario u: usuarios) {
//    		if (u.getCedula() == cedula)
//    			return true;
//    	}
//    	return false;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		if (!existeUsuario(usuario.getCedula())) {
//			usuarios.add(usuario);
			em.persist(usuario);
		}		
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		if (!datosCargados)
			agregarDatos();
//		return usuarios;
		Query query = em.createQuery("SELECT u FROM Usuario u");
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	@Override
	public Usuario obtenerUsuario(int cedula) {
//		if (existeUsuario(cedula)) {
//			for (Usuario u: usuarios) {
//				if (u.getCedula() == cedula)
//					return u;
//			}
//		}
//		return null;
		Usuario aux = new Usuario();
		aux = em.find(Usuario.class, cedula);
		return aux;
	}

	@Override
	public void agregarDatos() {
		Usuario user1 = new Usuario(33333333, "Juan", "Perez");
		Usuario user2 = new Usuario (55555555, "Maria", "Rodriguez");
		Usuario user3 = new Usuario (50446656, "Agustina", "Corvo");
		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
//		usuarios.add(user1);
//		usuarios.add(user2);
//		usuarios.add(user3);
		datosCargados=true;
	}

	@Override
	public void borrarUsuario(int cedula) {
		if (existeUsuario(cedula)) {
			Usuario aux = obtenerUsuario(cedula);
			em.remove(aux);
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
