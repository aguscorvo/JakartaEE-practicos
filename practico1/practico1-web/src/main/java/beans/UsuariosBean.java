package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import business.UsuarioBusinessLocal;
import dt.DtUsuario;

@Named("usuariosView")
//@ViewScoped
@RequestScoped
//public class UsuariosBean implements Serializable{
public class UsuariosBean {

	//private static final long serialVersionUID = 1L;
	
	@EJB
    UsuarioBusinessLocal usuarioBusiness;
	
    private List<DtUsuario> listaUsuarios;
    private int cedula;
    private String nombre;
    private String apellido;
    
    public UsuariosBean() {
	}

	@PostConstruct
	public void init() {
		listaUsuarios = usuarioBusiness.obtenerUsuarios();
	}
	
	public void buscarUsuario(int cedula) {
		DtUsuario usuarioEncontrado = usuarioBusiness.obtenerUsuario(cedula);
		if (usuarioEncontrado!=null) {
			nombre = usuarioEncontrado.getNombre();
			apellido = usuarioEncontrado.getApellido();
		}
	}

	public List<DtUsuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<DtUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	

	
}
