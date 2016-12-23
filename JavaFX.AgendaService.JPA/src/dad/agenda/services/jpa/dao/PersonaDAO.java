package dad.agenda.services.jpa.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import dad.agenda.services.jpa.entities.PersonaEntity;
import dad.agenda.services.jpa.utils.CrudDAO;

public class PersonaDAO extends CrudDAO<PersonaEntity> {
	
	public List<PersonaEntity> find(String nombre, String apellidos) throws PersistenceException {
		if (nombre == null) nombre = "";
		if (apellidos == null) apellidos = "";
        return query(PersonaEntity.class, 
        		"from PersonaEntity p " +
        		"where (p.nombre like ?1) and (p.apellidos like ?2) " +
        		"order by p.nombre", 
        		"%" + nombre + "%", "%" + apellidos + "%"
        	);
	}
	
	public List<PersonaEntity> getAll() throws PersistenceException {
        return query(PersonaEntity.class, "from PersonaEntity p order by p.nombre");
	}

	public PersonaEntity findById(long id) {
		return findById(PersonaEntity.class, id);
	}
	
	public void delete(long id) {
		delete(PersonaEntity.class, id);
	}

}
