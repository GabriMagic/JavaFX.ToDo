package dad.todo.services;

import java.util.ResourceBundle;

public class ServiceFactory {
	private static EventoService eventoService;
	private static UsuarioService usuarioService;

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("META-INF/services");

	private static Object instanceService(String propertyName) {
		try {
			Class<?> clazz = Class.forName(BUNDLE.getString(propertyName));
			return clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Error al instanciar servicio", e);
		}
	}

	public static EventoService getAgendaService() {
		if (eventoService == null) {
			eventoService = (EventoService) instanceService("service.agenda");
		}
		return eventoService;
	}

	public static UsuarioService getLoginService() {
		if (usuarioService == null) {
			usuarioService = (UsuarioService) instanceService("service.login");
		}
		return usuarioService;
	}

}
