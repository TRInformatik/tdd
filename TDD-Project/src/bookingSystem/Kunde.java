package bookingSystem;

import java.io.Serializable;

public class Kunde implements Serializable{

	private static final long serialVersionUID = -4408648319826143894L;
	
	private String name, address;

	public Kunde(String name, String address) {
		setName(name);
		setAddress(address);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;	
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}