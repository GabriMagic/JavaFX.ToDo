package dad.agenda.services.jpa;

import java.util.List;
import java.util.stream.Collectors;

import dad.agenda.services.AgendaService;
import dad.agenda.services.ServiceException;
import dad.agenda.services.items.PersonaItem;
import dad.agenda.services.items.PersonaListItem;
import dad.agenda.services.jpa.dao.DAOFactory;
import dad.agenda.services.jpa.entities.PersonaEntity;

public class AgendaServiceJPA implements AgendaService {

	@Override
	public List<PersonaListItem> getPersonas() throws ServiceException {
		try {
			List<PersonaEntity> entities = DAOFactory.getPersonaDAO().getAll();
			return entities.stream().map(PersonaEntity::toListItem).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException("Error al recuperar todas las personas de la agenda", e);
		}
	}

	@Override
	public PersonaItem getPersona(long id) throws ServiceException {
		try {
			PersonaEntity entity = DAOFactory.getPersonaDAO().findById(id);
			PersonaItem item = (entity != null) ? entity.toItem() : null;
			return item;
		} catch (Exception e) {
			throw new ServiceException("Error al recuperar la persona con id '" + id + "' de la agenda", e);
		}
	}

	@Override
	public void addPersona(PersonaItem persona) throws ServiceException {
		try {
			PersonaEntity entity = PersonaEntity.fromItem(persona);
			DAOFactory.getPersonaDAO().create(entity);
			persona.setId(entity.getId());
		} catch (Exception e) {
			throw new ServiceException("Error al añadir la persona: [" + persona + "] a la agenda", e);
		}
	}

	@Override
	public void deletePersona(PersonaItem persona) throws ServiceException {
		try {
			DAOFactory.getPersonaDAO().delete(persona.getId());
		} catch (Exception e) {
			throw new ServiceException("Error al eliminar la persona: [" + persona + "] de la agenda", e);
		}
	}

	@Override
	public void updatePersona(PersonaItem persona) throws ServiceException {
		try {
			DAOFactory.getPersonaDAO().update(PersonaEntity.fromItem(persona));
		} catch (Exception e) {
			throw new ServiceException("Error al actualizar la persona: [" + persona+ "] en la agenda", e);
		}
	}

	@Override
	public List<PersonaListItem> findPersonas(String nombre, String apellidos) throws ServiceException {
		try {
			List<PersonaEntity> entities = DAOFactory.getPersonaDAO().find(nombre, apellidos);
			return entities.stream().map(PersonaEntity::toListItem).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException("Error al buscar personas en la agenda", e);
		}
	}

}
