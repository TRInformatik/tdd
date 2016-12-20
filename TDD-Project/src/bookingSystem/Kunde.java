package bookingSystem;

public class Kunde {

	private String firstName, lastName;

	public Kunde(String firstName) {
		setFirstName(firstName);
	}

	public Kunde() {
	}

	public Kunde(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
