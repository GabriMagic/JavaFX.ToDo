package dad.todo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import dad.todo.items.EventoItem;

@Entity
@Table(name = "Evento")
public class EventoEntity {

	@Id
	private Long id;

	private String titulo;

	private LocalDate fecha;

	private Long duracion;

	private boolean realizado;

	public EventoEntity() {

	}

	public EventoItem totitem() {

		return null;
	}

	public final EventoEntity fromItem(EventoItem item) {

		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

}
