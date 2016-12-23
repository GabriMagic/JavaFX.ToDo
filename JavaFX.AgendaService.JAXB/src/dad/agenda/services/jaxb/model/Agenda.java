package dad.agenda.services.jaxb.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement
public class Agenda {
	
	private IDGenerator generator = new IDGenerator();
	private List<Persona> contactos = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();
	
	@XmlElement
	public IDGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(IDGenerator generator) {
		this.generator = generator;
	}

	@XmlElement
	public List<Persona> getContactos() {
		return contactos;
	}
	
	@XmlElement
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
