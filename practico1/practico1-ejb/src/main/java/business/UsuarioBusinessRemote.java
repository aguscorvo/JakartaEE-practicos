package business;

import java.util.List;

import javax.ejb.Remote;

import dt.DtUsuario;
import exception.RegistroUsuarioException;

@Remote
public interface UsuarioBusinessRemote {
	public void agregarUsuario(DtUsuario usuario) throws RegistroUsuarioException;
    public List<DtUsuario> obtenerUsuarios();
    public DtUsuario obtenerUsuario(int cedula) throws RegistroUsuarioException;
    public void borrarUsuario(int cedula) throws RegistroUsuarioException;
    public void editarUsuario(DtUsuario usuario) throws RegistroUsuarioException;
}
