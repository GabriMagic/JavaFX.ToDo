package dad.todo.services;

import dad.todo.items.UsuarioItem;

public interface UsuarioService {

	public boolean login(String username, String Password) throws ServiceException;

	public void alta(UsuarioItem usuario) throws ServiceException;

	public void baja() throws ServiceException;

	public UsuarioItem getLogueado() throws ServiceException;

	public void cambiarPassword(String oldPassword, String newPassword) throws ServiceException;

	public void recuperarPassword() throws ServiceException;

	public void actualizar(UsuarioItem usuario) throws ServiceException;
}
