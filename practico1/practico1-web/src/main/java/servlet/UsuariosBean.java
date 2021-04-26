package servlet;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import business.UsuarioBusinessLocal;
import dt.DtUsuario;

@Named("usuarios")
@RequestScoped
public class UsuariosBean {
	
	@EJB
    UsuarioBusinessLocal usuarioBusiness;
    private ArrayList<DtUsuario> usuarios;

	public UsuariosBean() {
	}

	
}
