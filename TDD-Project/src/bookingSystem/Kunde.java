package bookingSystem;

import java.io.Serializable;

public class Kunde implements Serializable{

	private static final long serialVersionUID = -4408648319826143894L;
	
	private String name, addresse;

	public Kunde(String name, String address) {
		setName(name);
		setAddresse(address);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddresse(String address) {
		this.addresse = address;	
	}

	public String getName() {
		return name;
	}

	public String getAddresse() {
		return addresse;
	}

}