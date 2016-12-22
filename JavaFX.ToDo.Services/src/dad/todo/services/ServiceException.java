package dad.todo.services;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String mensaje) {
		super(mensaje);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String mensaje, Throwable cause) {
		super(mensaje, cause);
	}

}
