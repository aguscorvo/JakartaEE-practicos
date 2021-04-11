package dao;

import java.util.ArrayList;

import javax.ejb.Local;

import entity.Usuario;

@Local
public interface UsuarioDAOLocal {
	public void agregarUsuario(Usuario usuario);
    public ArrayList<Usuario> obtenerUsuarios();
    public Usuario obtenerUsuario(int cedula);
    public void agregarDatos();

}
