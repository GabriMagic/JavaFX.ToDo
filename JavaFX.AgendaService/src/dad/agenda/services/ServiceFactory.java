package dad.agenda.services;

import java.util.ResourceBundle;

public class ServiceFactory {
	private static AgendaService agendaService;
	private static LoginService loginService;
	
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("META-INF/services"); 
	
	private static Object instanceService(String propertyName) {
		try {
			Class<?> clazz = Class.forName(BUNDLE.getString(propertyName));
		    return clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		    throw new RuntimeException("Error al instanciar servicio", e);
		}
	}
	
	public static AgendaService getAgendaService() {
		if (agendaService == null) {
			agendaService = (AgendaService) instanceService("service.agenda");
		}
		return agendaService;
	}
	
	public static LoginService getLoginService() {
		if (loginService == null) {
			loginService = (LoginService) instanceService("service.login");
		}
		return loginService;
	}

}
