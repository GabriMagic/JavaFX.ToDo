package dad.agenda.services.jaxb;

import java.util.List;
import java.util.stream.Collectors;

import dad.agenda.services.AgendaService;
import dad.agenda.services.ServiceException;
import dad.agenda.services.items.PersonaItem;
import dad.agenda.services.items.PersonaListItem;
import dad.agenda.services.jaxb.model.Persona;
import dad.agenda.services.jaxb.utils.JAXBUtil;

public class AgendaServiceJAXB implements AgendaService {
	
	@Override
	public List<PersonaListItem> getPersonas() throws ServiceException{
        return JAXBUtil.getAgenda().getContactos().stream().map(Persona::toListItem).collect(Collectors.toList());
	}

	@Override
	public PersonaItem getPersona(long id) {
		return JAXBUtil.getAgenda().getContactos().stream().filter(p -> p.getId().equals("" + id)).findFirst().get().toItem();
	}

	@Override
	public void addPersona(PersonaItem persona) {
		Persona p = Persona.fromItem(persona);
		p.setId(JAXBUtil.getAgenda().getGenerator().nextID());
		JAXBUtil.getAgenda().getContactos().add(p);
	}

	@Override
	public void deletePersona(PersonaItem persona) {
		Persona pe = JAXBUtil.getAgenda().getContactos().stream().filter(p -> p.equals(persona)).findFirst().get();
		JAXBUtil.getAgenda().getContactos().remove(pe);
	}

	@Override
	public void updatePersona(PersonaItem persona) {
		Persona viejo = JAXBUtil.getAgenda().getContactos().stream().filter(p -> p.equals(persona)).findFirst().get();
		Persona nuevo = Persona.fromItem(persona);
		int index = JAXBUtil.getAgenda().getContactos().indexOf(viejo);
		JAXBUtil.getAgenda().getContactos().remove(viejo);
		JAXBUtil.getAgenda().getContactos().add(index, nuevo);
	}

	@Override
	public List<PersonaListItem> findPersonas(String nombre, String apellidos) {
		return JAXBUtil.getAgenda().getContactos().stream()
				.filter(p ->
						(nombre == null || nombre.isEmpty() || p.getNombre().contains(nombre)) &&
						(apellidos == null || apellidos.isEmpty() || p.getApellidos().contains(apellidos)))
				.map(Persona::toListItem)
				.collect(Collectors.toList());
	}


}
