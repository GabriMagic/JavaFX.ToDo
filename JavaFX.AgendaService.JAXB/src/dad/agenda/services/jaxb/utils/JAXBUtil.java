package dad.agenda.services.jaxb.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import dad.agenda.services.jaxb.model.Agenda;

public class JAXBUtil {
	
	private static Agenda agenda;

	public static Agenda getAgenda() {
		if (agenda == null) {
			try {
				agenda = load(Agenda.class, new File("agenda.xml"));
			} catch (UnmarshalException e) {
				e.printStackTrace();
				agenda = new Agenda();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error al cargar 'agenda.xml'.", e);
			}
		}
		return agenda;
	}
	
	public static void close() {
		if (agenda != null) {
			try {
				save(agenda, new File("agenda.xml"));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage(), e);
			}
		}
	}
	
	private static void save(Object rootObject, File target) throws Exception {
		JAXBContext context = JAXBContext.newInstance(rootObject.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(rootObject, target);
	}

	private static <T> T load(Class<T> rootClass, File source) throws Exception {
		JAXBContext context = JAXBContext.newInstance(rootClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return rootClass.cast(unmarshaller.unmarshal(source));
	}		
	
}
