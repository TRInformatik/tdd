package bookingSystem;

import java.io.Serializable;

public class Kunde implements Serializable{

	private static final long serialVersionUID = -4408648319826143894L;
	
	private String firstName, lastName, address;

	public Kunde(String firstName, String lastName, String address) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;	
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

}