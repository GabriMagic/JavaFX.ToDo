package dad.todo.services;

import java.time.LocalDate;

import dad.todo.items.EventoItem;

public interface EventoService {

	public void crear(EventoItem evento) throws ServiceException;

	public void eliminar(Long id) throws ServiceException;

	public void actualizar(Long id) throws ServiceException;

	public EventoItem[] getEventos() throws ServiceException;

	public EventoItem[] buscarEventosPorFecha(LocalDate fecha) throws ServiceException;
}