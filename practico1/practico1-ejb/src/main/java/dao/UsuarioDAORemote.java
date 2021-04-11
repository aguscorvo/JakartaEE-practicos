package dao;

import java.util.ArrayList;

import javax.ejb.Remote;

import entity.Usuario;

@Remote
public interface UsuarioDAORemote {
	public void agregarUsuario(Usuario usuario);
    public ArrayList<Usuario> obtenerUsuarios();
    public Usuario obtenerUsuario(int cedula);
    public void agregarDatos();


}
