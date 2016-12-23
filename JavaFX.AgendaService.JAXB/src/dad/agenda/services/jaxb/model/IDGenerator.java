package dad.agenda.services.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class IDGenerator {

	private Long lastID = 1L;

	@XmlAttribute
	public Long getLastID() {
		return lastID;
	}

	public void setLastID(Long lastID) {
		this.lastID = lastID;
	}
	
	public String nextID() {
		return "" + lastID++;
	}
	
}
