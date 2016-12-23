package dad.agenda.services.jpa.dao;

public final class DAOFactory {
	
	private static PersonaDAO personaDao;
	private static UsuarioDAO usuarioDao;
	
	private DAOFactory() {}
	
	public static PersonaDAO getPersonaDAO() {
		if (personaDao == null) {
			personaDao = new PersonaDAO();
		}
		return personaDao;
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		if (usuarioDao == null) {
			usuarioDao = new UsuarioDAO();
		}
		return usuarioDao;
	}
}
