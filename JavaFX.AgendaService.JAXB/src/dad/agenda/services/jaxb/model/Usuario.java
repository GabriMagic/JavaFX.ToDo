package dad.agenda.services.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Usuario {

	private String username;
	private String password;

	@XmlID
	@XmlAttribute
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlAttribute
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return getUsername();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getUsername() == null) return false;
		if (obj instanceof Usuario) {
			Usuario u = (Usuario) obj;
			return getUsername().equals(u.getUsername());
		}
		return false;
	}
	
}
