package dad.agenda.services.items;

import java.util.ArrayList;
import java.util.List;

public class PersonaItem {
	private Long id;
	private String nombre;
	private String apellidos;
	private List<TelefonoItem> telefonos = new ArrayList<>();

	public PersonaItem() {
	}

	public PersonaItem(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	public List<TelefonoItem> getTelefonos() {
		return telefonos;
	}
	
	@Override
	public String toString() {
		return "id=" + getId() + "/nombre=" + getNombre() + "/apellidos=" + getApellidos() + "/telefonos=" + getTelefonos().size();
	}

}
