package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Usuario;

@Local
public interface UsuarioDAOLocal {
	public void agregarUsuario(Usuario usuario);
    public List<Usuario> obtenerUsuarios();
    public Usuario obtenerUsuario(int cedula);
    public void agregarDatos();
    public void borrarUsuario(int cedula);
    public void editarUsuario(Usuario usuario);

}
