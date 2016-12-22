package dad.todo.items;

import java.time.LocalDate;

public class EventoItem {

	private Long idLong;
	private String titulo;
	private LocalDate fecha;
	private String descripcion;
	private Long duracion;
	private Integer realizado;

	public Long getIdLong() {
		return idLong;
	}

	public void setIdLong(Long idLong) {
		this.idLong = idLong;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	public Integer getRealizado() {
		return realizado;
	}

	public void setRealizado(Integer realizado) {
		this.realizado = realizado;
	}

}
