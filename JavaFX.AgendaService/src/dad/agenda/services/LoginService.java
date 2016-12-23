package dad.agenda.services;

public interface LoginService {
	
	public boolean login(String username, String password) throws ServiceException;
	public void registerUser(String username, String password) throws ServiceException;
	public void deleteUser(String username) throws ServiceException;
	public void changePassword(String username, String oldpassword, String newpassword) throws ServiceException;

}
