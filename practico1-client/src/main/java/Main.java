import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import business.UsuarioBusinessRemote;
import dt.DtUsuario;

public class Main {
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) throws NamingException {
		
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");  
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		props.put(Context.PROVIDER_URL,"remote+http://localhost:8080"); 
		
		Context ctx  = new InitialContext(props);
		String jndiName = "ejb:practico1/practico1-ejb/UsuarioBusiness!business.UsuarioBusinessRemote";
		
		UsuarioBusinessRemote usuarioBusiness = (UsuarioBusinessRemote)ctx.lookup(jndiName);
		
		int opcion = 1;
			
		while(opcion!=0) {
			System.out.print("\n/////// VACUNAS.UY - USUARIOS /////// \n\n"
					+ "1- Agregar usuario \n"
					+ "2- Listar usuarios\n"
					+ "3- Buscar usuario\n"
					+ "4- Cargar datos\n"
					+ "0- Salir\n\n");
			
			opcion = entrada.nextInt();
			
			switch(opcion) {
				case 0:
					System.exit(0);
					break;
				case 1: 
					System.out.print("\n\nAGREGAR USUARIO\n\n");
					agregarUsuario(usuarioBusiness);
					break;
				case 2:
					System.out.print("\n\nLISTAR USUARIOS\n\n");
					listarUsuarios(usuarioBusiness);
					break;
				case 3: 
					System.out.print("\n\nBUSCAR USUARIO\n\n");
					buscarUsuario(usuarioBusiness);
					break;
				case 4: 
					System.out.print("\nCARGAR DATOS\n");
					cargarDatos(usuarioBusiness);
					break;
				default:
					System.out.print("\nOpción incorrecta. Vuelva a intentarlo.\n");
					break;
			}
			
		}	
		
	}
	

	public static void subMenu () {
		int opcion=1;
		while (opcion!=0) {
			System.out.print("\n1- Volver al menú principal \n"
					+ "0- Salir\n\n");
			
			opcion = entrada.nextInt();
			
			switch(opcion) {
				case 0:
					System.exit(0);
					break;
				case 1:  
					return;
				default:
					System.out.print("\nOpción incorrecta. Vuelva a intentarlo.\n");
					break;
			}
		}		
	}
	
	
	// Agregar usuarios
	private static void agregarUsuario(UsuarioBusinessRemote business) {
		int cedula;
		String nombre, apellido;
		System.out.print("Cédula: ");
		cedula = entrada.nextInt();
		System.out.print("\nNombre: ");
		nombre = entrada.next();
		System.out.print("\nApellido: ");
		apellido = entrada.next();
		DtUsuario u = new DtUsuario (cedula, nombre, apellido);
		business.agregarUsuario(u);		
		subMenu ();
	}
	
	// Listar usuarios
	private static void listarUsuarios(UsuarioBusinessRemote business) {
		ArrayList<DtUsuario> usuarios = business.obtenerUsuarios();
		if (usuarios.isEmpty()) {
			System.out.print("No existen usuarios registrados en el sistema.\n");
		}else {
			for(DtUsuario u: usuarios) {
				System.out.print("Cedula: " + u.getCedula() + " / Nombre: " + u.getNombre() + " / Apellido: " + u.getApellido() + "\n");
			}
		}
		subMenu ();
	}
	
	// Buscar usuario
	private static void buscarUsuario(UsuarioBusinessRemote business) {
		System.out.print("Cédula: ");
		int cedula;
		cedula= entrada.nextInt();
		DtUsuario u = business.obtenerUsuario(cedula);
		System.out.print("Cedula: " + u.getCedula() + "/ Nombre: " + u.getNombre() + "/ Apellido: " + u.getApellido() + "\n");
		subMenu ();
	}

	
	// Cargar datos
	private static void cargarDatos(UsuarioBusinessRemote business) {
		business.agregarDatos();
		subMenu ();
	}
	
	

}
