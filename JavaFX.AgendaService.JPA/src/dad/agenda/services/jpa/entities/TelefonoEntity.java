package dad.agenda.services.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import dad.agenda.services.items.TelefonoItem;

@Entity
@Table(name="telefonos")
public class TelefonoEntity {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	private Long numero;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (id != null && obj != null && obj instanceof TelefonoEntity) {
			TelefonoEntity telefono = (TelefonoEntity) obj;
			return id.equals(telefono.getId());
		}
		return false;
	}
	
	public TelefonoItem toItem() {
		TelefonoItem item = new TelefonoItem();
		item.setId(getId());
		item.setNumero(getNumero());
		return item;
	}
	
	public static TelefonoEntity fromItem(TelefonoItem item) {
		TelefonoEntity entity = new TelefonoEntity();
		entity.setId(item.getId());
		entity.setNumero(item.getNumero());
		return entity;
	}

}
