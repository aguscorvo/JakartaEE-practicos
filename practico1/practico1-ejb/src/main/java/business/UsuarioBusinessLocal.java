package business;

import java.util.List;

import javax.ejb.Local;

import dt.DtUsuario;
import exception.RegistroUsuarioException;

@Local
public interface UsuarioBusinessLocal {
	public void agregarUsuario(DtUsuario usuario) throws RegistroUsuarioException;
    public List<DtUsuario> obtenerUsuarios();
    public DtUsuario obtenerUsuario(int cedula) throws RegistroUsuarioException;
    public void borrarUsuario(int cedula) throws RegistroUsuarioException;
    public void editarUsuario(int cedula, String nombre, String apellido) throws RegistroUsuarioException;
}
