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
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		if (!existeUsuario(usuario.getCedula())) {
			em.persist(usuario);
		}		
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		if (!datosCargados)
			agregarDatos();
		Query query = em.createQuery("SELECT u FROM Usuario u");
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	@Override
	public Usuario obtenerUsuario(int cedula) {
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
	public void editarUsuario(Usuario usuario) {
		if (existeUsuario(usuario.getCedula())) {
			Usuario aux = obtenerUsuario(usuario.getCedula());
			aux.setNombre(usuario.getNombre());
			aux.setApellido(usuario.getApellido());	
			em.persist(aux);
		}
	}

	

	
}
