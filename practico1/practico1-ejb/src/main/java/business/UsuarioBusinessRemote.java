package business;

import java.util.ArrayList;

import javax.ejb.Remote;

import dt.DtUsuario;

@Remote
public interface UsuarioBusinessRemote {
	public void agregarUsuario(DtUsuario usuario);
    public ArrayList<DtUsuario> obtenerUsuarios();
    public DtUsuario obtenerUsuario(int cedula);
    public void agregarDatos();
    public void borrarUsuario(int cedula);
    public void editarUsuario(int cedula, String nombre, String apellido);
}
