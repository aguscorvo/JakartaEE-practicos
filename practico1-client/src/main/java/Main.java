import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	
	public static void main(String[] args) throws NamingException {
		
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");  
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		props.put(Context.PROVIDER_URL,"remote+http://localhost:8080"); 
		
		Context ctx  = new InitialContext(props);
		String jndiName = "ejb:practico1/practico1-ejb/UsuarioBusiness!business.UsuarioBusinessRemote";
		
		UsuarioBusinessRemote usuarioBusiness = (UsuarioBusinessRemote)ctx.lookup(jndiName);
		
		//menu

	}

}
