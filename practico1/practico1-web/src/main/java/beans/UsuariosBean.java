package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import business.UsuarioBusinessLocal;
import dt.DtUsuario;

@Named("usuariosView")
@ViewScoped
public class UsuariosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
    UsuarioBusinessLocal usuarioBusiness;
	
    private List<DtUsuario> listaUsuarios;
    private int cedula;
    private DtUsuario usuario;
    private String mensaje;
    
	@PostConstruct
	public void init() {
		listaUsuarios = usuarioBusiness.obtenerUsuarios();
		usuario = new DtUsuario();
		mensaje = null;		
	}
	
	public void buscarUsuario() {
		DtUsuario usuarioEncontrado = usuarioBusiness.obtenerUsuario(cedula);
		if (usuarioEncontrado!=null) {
			usuario.setCedula(usuarioEncontrado.getCedula());
			usuario.setNombre(usuarioEncontrado.getNombre());
			usuario.setApellido(usuarioEncontrado.getApellido());	
			mensaje=null;

		}
		else {
			usuario.setCedula(0);
			usuario.setNombre("");
			usuario.setApellido("");	
			mensaje="Usuario no registrado.";
			
		}
	}
	
	public void agregarUsuario() {
		if ( (!usuario.getNombre().equals(null))
				& (!usuario.getApellido().equals(null))
				& (usuario.getCedula()!=0)) {
			
			usuarioBusiness.agregarUsuario(usuario);
			mensaje="El usuario con cédula "+ usuario.getCedula() + " fue creado exitosamente";	
			
		}else {
			mensaje="Error";	
		}
	}

	public List<DtUsuario> getListaUsuarios() {		
		return listaUsuarios;
	}

	public void setListaUsuarios(List<DtUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void setUsuarioBusiness(UsuarioBusinessLocal usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public DtUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(DtUsuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	

	
}
