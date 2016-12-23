package dad.agenda.services.jpa;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dad.agenda.services.LoginService;
import dad.agenda.services.ServiceException;
import dad.agenda.services.jpa.dao.DAOFactory;
import dad.agenda.services.jpa.entities.UsuarioEntity;

public class LoginServiceJPA implements LoginService {

	@Override
	public boolean login(String username, String password) throws ServiceException {
		try {
			String encryptedPassword = encryptPassword(password);
			UsuarioEntity usuario = DAOFactory.getUsuarioDAO().findByCredentials(username, encryptedPassword);
			return (usuario != null);
		} catch (Exception e) {
			throw new ServiceException("Error intentar iniciar sesión con el usuario '" + username + "'", e);
		}
	}

	@Override
	public void registerUser(String username, String password) throws ServiceException {
		try {
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setUsername(username);
			usuario.setPassword(encryptPassword(password));
			DAOFactory.getUsuarioDAO().create(usuario);
		} catch (Exception e) {
			throw new ServiceException("Error intentar registrar al usuario '" + username + "'", e);
		}
	}

	@Override
	public void deleteUser(String username) throws ServiceException {
		try {
			UsuarioEntity usuario = DAOFactory.getUsuarioDAO().findByUsername(username);
			DAOFactory.getUsuarioDAO().delete(usuario);
		} catch (Exception e) {
			throw new ServiceException("Error intentar eliminar al usuario '" + username + "'", e);
		}
	}

	@Override
	public void changePassword(String username, String oldpassword, String newpassword) throws ServiceException {
		try {
			String encryptedOldPassword = encryptPassword(oldpassword);
			String encryptedNewPassword = encryptPassword(newpassword);
			UsuarioEntity usuario = DAOFactory.getUsuarioDAO().findByUsername(username);
			if (usuario == null) {
				throw new IllegalArgumentException("El usuario indicado no existe.");
			}
			if (usuario.getPassword().equals(encryptedOldPassword)) {
				usuario.setPassword(encryptedNewPassword);
				DAOFactory.getUsuarioDAO().update(usuario);
			} else {
				throw new IllegalArgumentException("La contraseña anterior no coincide");
			}
		} catch (IllegalArgumentException e) {
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			throw new ServiceException("Error al cambiar la contraseña", e);
		}
	}

	private String encryptPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			return new String(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Error encriptando contraseña", e);
		}
	}

}
