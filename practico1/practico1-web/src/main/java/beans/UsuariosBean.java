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
import exception.RegistroUsuarioException;

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
		DtUsuario usuarioEncontrado;
		try {
			usuarioEncontrado = usuarioBusiness.obtenerUsuario(cedula);
			usuario.setCedula(usuarioEncontrado.getCedula());
			usuario.setNombre(usuarioEncontrado.getNombre());
			usuario.setApellido(usuarioEncontrado.getApellido());	
			mensaje=null;
			
		} catch (RegistroUsuarioException e) {
			usuario.setCedula(0);
			usuario.setNombre("");
			usuario.setApellido("");
			mensaje = e.getMessage();
			e.printStackTrace();
		}
	
	}
	
	public void agregarUsuario() {					
			try {
				usuarioBusiness.agregarUsuario(usuario);
				mensaje="El usuario con cédula "+ usuario.getCedula() + " fue creado exitosamente";	

			} catch (RegistroUsuarioException e) {
				mensaje = e.getMessage();
				e.printStackTrace();
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
