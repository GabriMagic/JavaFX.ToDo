package dad.agenda.services.jaxb.model;

import javax.xml.bind.annotation.XmlType;

import dad.agenda.services.items.TelefonoItem;

@XmlType
public class Telefono {
	
	private Long numero;
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (numero != null && obj != null && obj instanceof Telefono) {
			Telefono telefono = (Telefono) obj;
			return numero.equals(telefono.getNumero());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "" + getNumero();
	}
	
	public TelefonoItem toItem() {
		TelefonoItem item = new TelefonoItem();
		item.setNumero(getNumero());
		return item;
	}
	
	public static Telefono fromItem(TelefonoItem item) {
		Telefono t = new Telefono();
		t.setNumero(item.getNumero());
		return t;
	}

}
