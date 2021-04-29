package business;

import java.util.List;

import javax.ejb.Local;

import dt.DtUsuario;

@Local
public interface UsuarioBusinessLocal {
	public void agregarUsuario(DtUsuario usuario);
    public List<DtUsuario> obtenerUsuarios();
    public DtUsuario obtenerUsuario(int cedula);
//    public void agregarDatos();
    public void borrarUsuario(int cedula);
    public void editarUsuario(int cedula, String nombre, String apellido);
}
