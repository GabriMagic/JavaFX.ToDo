package dad.agenda.services.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import dad.agenda.services.items.PersonaItem;
import dad.agenda.services.items.PersonaListItem;

@Entity
@Table(name="personas")
public class PersonaEntity {

	@Id 
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=true)
	private String apellidos;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	@JoinColumn(name="persona_id")
	@OrderBy(value="numero")
	private List<TelefonoEntity> telefonos;
	
	public PersonaEntity() {
		telefonos = new ArrayList<TelefonoEntity>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<TelefonoEntity> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<TelefonoEntity> telefono) {
		this.telefonos = telefono;
	}

	@Override
	public boolean equals(Object obj) {
		if (id != null && obj != null && obj instanceof PersonaEntity) {
			PersonaEntity persona = (PersonaEntity) obj;
			return id.equals(persona.getId());
		}
		return false;
	}
	
	public PersonaListItem toListItem() {
		PersonaListItem item = new PersonaListItem();
		item.setId(getId());
		item.setNombre(getNombre());
		item.setApellidos(getApellidos());
		return item;
	}
	
	public PersonaItem toItem() {
		PersonaItem item = new PersonaItem();
		item.setId(getId());
		item.setNombre(getNombre());
		item.setApellidos(getApellidos());
		item.getTelefonos().addAll(getTelefonos().stream().map(TelefonoEntity::toItem).collect(Collectors.toList()));
		return item;
	}
	
	public static PersonaEntity fromItem(PersonaItem item) {
		PersonaEntity pe = new PersonaEntity();
		pe.setId(item.getId());
		pe.setNombre(item.getNombre());
		pe.setApellidos(item.getApellidos());
		pe.getTelefonos().addAll(item.getTelefonos().stream().map(TelefonoEntity::fromItem).collect(Collectors.toList()));
		return pe;
	}
	
}
