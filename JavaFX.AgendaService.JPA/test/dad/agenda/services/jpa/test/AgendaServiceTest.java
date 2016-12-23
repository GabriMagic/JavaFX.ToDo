package dad.agenda.services.jpa.test;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dad.agenda.services.ServiceException;
import dad.agenda.services.ServiceFactory;
import dad.agenda.services.items.PersonaItem;
import dad.agenda.services.items.TelefonoItem;
import dad.agenda.services.jpa.utils.JPAUtil;

public class AgendaServiceTest {
	
	@BeforeClass
	public static void init() {
		// elimina el fichero de la base de datos
		new File("db/agenda.sqlite").delete();
		// inicializa el manager factory con la unidad de persistencia "agenda"
		// (esto crea el fichero "agenda.sqlite")
		JPAUtil.initEntityManagerFactory("agenda");
	}
	
	@AfterClass
	public static void finish() {
		// cierra la conexión con la base de datos
		JPAUtil.closeEntityManagerFactory();
	}

	@Test
	public void testAddAndGetPersona() {
		try {		
			PersonaItem p1 = new PersonaItem("Perico", "Delgado");
			p1.getTelefonos().add(new TelefonoItem(12345678L));
			p1.getTelefonos().add(new TelefonoItem(87654321L));
			ServiceFactory.getAgendaService().addPersona(p1);

			Assert.assertNotNull("El ID de la persona añadida es nulo", p1.getId());

			PersonaItem p2 = ServiceFactory.getAgendaService().getPersona(p1.getId());

			Assert.assertNotNull("La persona NO se encuentra en la base de datos", p2);
			Assert.assertEquals("Los nombres de las personas no coinciden", p1.getNombre(), p2.getNombre());
			Assert.assertEquals("Los apellidos  de las personas no coinciden", p1.getApellidos(), p2.getApellidos());
			Assert.assertEquals("La cantidad de teléfnos no coinciden", p1.getTelefonos().size(), p2.getTelefonos().size());
			
		} catch (ServiceException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test(expected = ServiceException.class)
	public void testAddPersonaSinNombre() throws ServiceException {
		PersonaItem p1 = new PersonaItem(null, "Delgado");
		p1.getTelefonos().add(new TelefonoItem(12345678L));
		p1.getTelefonos().add(new TelefonoItem(87654321L));
		ServiceFactory.getAgendaService().addPersona(p1);
	}

	@Test
	public void testEliminarPersona() {
		try {		
			PersonaItem p1 = new PersonaItem("Me Van A", "Eliminar");
			p1.getTelefonos().add(new TelefonoItem(12345678L));
			p1.getTelefonos().add(new TelefonoItem(87654321L));
			ServiceFactory.getAgendaService().addPersona(p1);

			PersonaItem p2 = ServiceFactory.getAgendaService().getPersona(p1.getId());

			Assert.assertNotNull("La persona NO se encuentra en la base de datos", p2);
			
			ServiceFactory.getAgendaService().deletePersona(p2);

			PersonaItem p3 = ServiceFactory.getAgendaService().getPersona(p1.getId());

			Assert.assertNull("Se ha recuperado la persona eliminada de la base de datos", p3);
			
		} catch (ServiceException e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testActualizarPersona() {
		try {		
			PersonaItem p1 = new PersonaItem("Me Van A", "Actualizar");
			p1.getTelefonos().add(new TelefonoItem(12345678L));
			p1.getTelefonos().add(new TelefonoItem(87654321L));
			ServiceFactory.getAgendaService().addPersona(p1);

			PersonaItem p2 = ServiceFactory.getAgendaService().getPersona(p1.getId());
			p2.setNombre("Perico");
			p2.setApellidos("Palotes");
			
			ServiceFactory.getAgendaService().updatePersona(p2);

			PersonaItem p3 = ServiceFactory.getAgendaService().getPersona(p1.getId());

			Assert.assertEquals("No ha cambiado el nombre", "Perico", p3.getNombre());
			Assert.assertEquals("No han cambiado los apellidos", "Palotes", p3.getApellidos());
			
		} catch (ServiceException e) {
			fail(e.getMessage());
		}	
	}


}
