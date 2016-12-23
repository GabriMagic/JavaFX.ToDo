package dad.agenda.services.jaxb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

import dad.agenda.services.items.PersonaItem;
import dad.agenda.services.items.PersonaListItem;

@XmlType
public class Persona {

	private String id;
	private String nombre;
	private String apellidos;
	private List<Telefono> telefonos;
	
	public Persona() {
		telefonos = new ArrayList<Telefono>();
	}
	
	@XmlID
	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlAttribute
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@XmlElement
	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefono) {
		this.telefonos = telefono;
	}
	
	@Override
	public String toString() {
		return getNombre() + " " + getApellidos() + " " + getTelefonos().size();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getId() == null) return false;
		if (obj instanceof Persona) {
			Persona p = (Persona) obj;
			return getId().equals(p.getId());
		}
		return super.equals(obj);
	}

	public PersonaListItem toListItem() {
		PersonaListItem item = new PersonaListItem();
		item.setId(Long.parseLong(getId()));
		item.setNombre(getNombre());
		item.setApellidos(getApellidos());
		return item;
	}
	
	public PersonaItem toItem() {
		PersonaItem item = new PersonaItem();
		item.setId(Long.parseLong(getId()));
		item.setNombre(getNombre());
		item.setApellidos(getApellidos());
		item.getTelefonos().addAll(getTelefonos().stream().map(Telefono::toItem).collect(Collectors.toList()));
		return item;
	}
	
	public static Persona fromItem(PersonaItem item) {
		Persona p = new Persona();
		p.setId("" + item.getId());
		p.setNombre(item.getNombre());
		p.setApellidos(item.getApellidos());
		p.getTelefonos().addAll(item.getTelefonos().stream().map(Telefono::fromItem).collect(Collectors.toList()));
		return p;
	}
}
