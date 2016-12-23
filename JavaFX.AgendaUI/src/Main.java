

import dad.agenda.services.LoginService;
import dad.agenda.services.ServiceFactory;
import dad.agenda.services.items.PersonaItem;
import dad.agenda.services.items.TelefonoItem;
//import dad.agenda.services.jaxb.utils.JAXBUtil;
import dad.agenda.services.jpa.utils.JPAUtil;

public class Main {

	public static void main(String[] args) {
		JPAUtil.initEntityManagerFactory("agenda");
		
//		agendaServiceTest();
		loginServiceTest();
		
		JPAUtil.closeEntityManagerFactory();
	}

	public static void loginServiceTest() {
		try { 
			LoginService service = ServiceFactory.getLoginService();
//			service.registerUser("Fran", "Vargas");
			System.out.println(service.login("chuck", "norris"));
			service.changePassword("chuck", "norris", "patada");		
			System.out.println(service.login("perico", "palotes"));
//			System.out.println(service.login("perico", "pelotazos"));
//			service.deleteUser("perico");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static void agendaServiceTest() {
		try {
			PersonaItem p1 = new PersonaItem("Charles", "Bronson");
			p1.getTelefonos().add(new TelefonoItem(666111333L));
			p1.getTelefonos().add(new TelefonoItem(922102030L));
			ServiceFactory.getAgendaService().addPersona(p1);
				
//			PersonaItem p2 = new PersonaItem("Juan", "Sánchez");
//			p2.getTelefonos().add(new TelefonoItem(666111333L));
//			p2.getTelefonos().add(new TelefonoItem(922102030L));
//			ServiceFactory.getAgendaService().addPersona(p2);
				
//			ServiceFactory.getAgendaService().addPersona(new PersonaItem("Perico", "Palotes"));
//			System.out.println(ServiceFactory.getAgendaService().getPersonas());
//			System.out.println(ServiceFactory.getAgendaService().getPersona(1));
//			System.out.println(ServiceFactory.getAgendaService().getPersona(2));
				
//			PersonaItem p = new PersonaItem();
//			p.setId(1L);
//			ServiceFactory.getAgendaService().deletePersona(p);
				
//			PersonaItem p = ServiceFactory.getAgendaService().getPersona(2);
//			p.getTelefonos().get(0).setNumero(123456789L);
//			p.getTelefonos().remove(1);
//			ServiceFactory.getAgendaService().updatePersona(p);
			
			System.out.println(ServiceFactory.getAgendaService().getPersonas());
			
//			System.out.println(ServiceFactory.getAgendaService().findPersonas("ito", null));
//			System.out.println(ServiceFactory.getAgendaService().findPersonas("charli", null));
//			System.out.println(ServiceFactory.getAgendaService().findPersonas("", ""));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
