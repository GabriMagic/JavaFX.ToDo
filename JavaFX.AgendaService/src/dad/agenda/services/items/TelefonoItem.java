package dad.agenda.services.items;

public class TelefonoItem {
	private Long id;
	private Long numero;

	public TelefonoItem() {
	}

	public TelefonoItem(Long numero) {
		super();
		this.numero = numero;
	}

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
	public String toString() {
		return "id=" + getId() + "/numero=" + getNumero();
	}

}
