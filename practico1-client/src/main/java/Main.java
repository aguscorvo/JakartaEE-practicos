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
	
	public static void main(String[] args) throws NamingException {
		
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");  
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		props.put(Context.PROVIDER_URL,"remote+http://localhost:8080"); 
		
		Context ctx  = new InitialContext(props);
		String jndiName = "ejb:practico1/practico1-ejb/UsuarioBusiness!business.UsuarioBusinessRemote";
		
		UsuarioBusinessRemote usuarioBusiness = (UsuarioBusinessRemote)ctx.lookup(jndiName);
		
		
		int opcion = 1;
		Scanner entrada = new Scanner(System.in);
		
//		try {
//			final UsuarioBusinessRemote usuarioBusiness = invocarUsuarioBusinessRemote();
			
			while(opcion!=0) {
				System.out.print("\n\n/////// VACUNAS.UY - USUARIOS /////// \n\n"
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
						System.out.print("\nAgregar usuario\n");
						//metodo
						break;
					case 2:
						System.out.print("\nListar usuarios\n");
						listarUsuarios(usuarioBusiness);
						break;
					case 3: 
						System.out.print("\nBuscar usuario\n");
						//metodo
						break;
					case 4: 
						System.out.print("\nCargar datos\n");
						cargarDatos(usuarioBusiness);
						break;
					default:
						System.out.print("\nOpción incorrecta. Vuelva a intentarlo.\n");
						break;
				}
				
			}	
//		}catch(NamingException e) {
//			e.printStackTrace();
//		}	

	}
	
//	private static UsuarioBusinessRemote invocarUsuarioBusinessRemote() throws NamingException {
//        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
//        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//        jndiProperties.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
//        final Context context = new InitialContext(jndiProperties);
//        return (UsuarioBusinessRemote) context.lookup("ejb:practico1/practico1-ejb/UsuarioBusiness!business.UsuarioBusinessRemote");
//    }

	
	// Agregar usuarios
	private static void agregarUsuarios(UsuarioBusinessRemote business) {}
	
	// Listar usuarios
	private static void listarUsuarios(UsuarioBusinessRemote business) {
		ArrayList<DtUsuario> usuarios = business.obtenerUsuarios();
		if (usuarios.isEmpty()) {
			System.out.print("No existen usuarios registrados en el sistema.\n");
		}else {
			for(DtUsuario u: usuarios) {
				System.out.print("Cedula: " + u.getCedula() + "/ Nombre: " + u.getNombre() + "/ Apellido: " + u.getApellido() + "\n");
			}
		}
	}
	
	// Buscar usuario
	private static void buscarUsuario(UsuarioBusinessRemote business) {}

	
	// Cargar datos
	private static void cargarDatos(UsuarioBusinessRemote business) {
		business.print();
		System.out.print("Despues de print().\n");
		business.agregarDatos();
		System.out.print("Datos cargados.\n");
	}

}
