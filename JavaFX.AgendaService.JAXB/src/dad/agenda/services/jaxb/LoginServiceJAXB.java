package dad.agenda.services.jaxb;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

import dad.agenda.services.LoginService;
import dad.agenda.services.jaxb.model.Usuario;
import dad.agenda.services.jaxb.utils.JAXBUtil;

public class LoginServiceJAXB implements LoginService {

	@Override
	public boolean login(String username, String password) {
		final String encryptedPassword = encryptPassword(password);
        Usuario usuario = findUsuario(username);
        if (usuario == null) return false; 
		return usuario.getPassword().equals(encryptedPassword);
	}

	@Override
	public void registerUser(String username, String password) {
		Usuario u = findUsuario(username);
		if (u != null) throw new RuntimeException("El usuario '" + username + "' ya existe.");
		u = new Usuario();
		u.setUsername(username);
		u.setPassword(encryptPassword(password));
		JAXBUtil.getAgenda().getUsuarios().add(u);
	}

	@Override
	public void deleteUser(String username) {
		Usuario u = findUsuario(username);
		if (u == null) throw new RuntimeException("El usuario '" + username + "' no existe.");
		JAXBUtil.getAgenda().getUsuarios().remove(u);
	}

	@Override
	public void changePassword(String username, String oldpassword, String newpassword) {
		Usuario u = findUsuario(username);
		if (u == null) throw new RuntimeException("El usuario '" + username + "' no existe.");
		if (u.getPassword().equals(encryptPassword(oldpassword))) {
			u.setPassword(encryptPassword(newpassword));
		} else {
			throw new RuntimeException("El password anterior no es válido.");
		}
	}

	private Usuario findUsuario(String username) {
        Optional<Usuario> usuario =JAXBUtil.getAgenda().getUsuarios().stream()
            	.filter(u -> u.getUsername().equals(username))
            	.findFirst();
        return (usuario.isPresent() ? usuario.get() : null);
	}
	
	private String encryptPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte [] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			return new String(Base64.getEncoder().encode(hash));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Error encriptando contraseña", e);
		}
	}
	
}
