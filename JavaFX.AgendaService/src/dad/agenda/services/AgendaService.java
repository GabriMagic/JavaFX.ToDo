package dad.agenda.services;

import java.util.List;

import dad.agenda.services.items.PersonaItem;
import dad.agenda.services.items.PersonaListItem;

public interface AgendaService {

	public List<PersonaListItem> findPersonas(String nombre, String apellidos) throws ServiceException;
	public List<PersonaListItem> getPersonas() throws ServiceException;
	public PersonaItem getPersona(long id) throws ServiceException;
	public void addPersona(PersonaItem persona) throws ServiceException;
	public void deletePersona(PersonaItem persona) throws ServiceException;
	public void updatePersona(PersonaItem persona) throws ServiceException;
	
}
