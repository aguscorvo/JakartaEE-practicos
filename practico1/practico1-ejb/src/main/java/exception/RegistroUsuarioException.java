package exception;

import java.io.Serializable;

public class RegistroUsuarioException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final int USUARIO_REGISTRADO = 1;
	public static final int USUARIO_NO_REGISTRADO = 0;
	
	@SuppressWarnings("unused")
	private final int code;
	
	
	public RegistroUsuarioException(int code) {
		super();
		this.code = code;
	}

	public RegistroUsuarioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace, int code) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;	

	}

	public RegistroUsuarioException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;	
	}

	public RegistroUsuarioException(String message, int code) {
		super(message);
		this.code = code;	
	}

	public RegistroUsuarioException(Throwable cause, int code) {
		super(cause);
		this.code = code;	
	}
	

}
