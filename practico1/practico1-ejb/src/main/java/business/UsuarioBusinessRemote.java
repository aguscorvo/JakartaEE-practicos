package business;

import java.util.ArrayList;

import javax.ejb.Remote;

import dt.DtUsuario;

@Remote
public interface UsuarioBusinessRemote {
	public void agregarUsuario(DtUsuario usuario);
    public ArrayList<DtUsuario> obtenerUsuarios();
    public DtUsuario obtenerUsuario(int cedula);

}
