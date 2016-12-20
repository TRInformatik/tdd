package bookingSystem;

import java.util.HashMap;

public class Service {

	private DataManager dataManager = new DataManager();

	public Kunde createCustomer(String firstname, String lastname, String address) {
		return new Kunde(firstname, lastname, address);
	}

	public void storeCustomer(Kunde kunde) {
		if (alreadyExist(kunde)) {
			System.out.println("Customer already exists.");
		} else {
			HashMap<String, Kunde> customerList = dataManager.getCustomerList();
			customerList.put(kunde.getLastName(), kunde);
			dataManager.storeCustomerList(customerList);
		}
	}

	private boolean alreadyExist(Kunde kunde) {
		return dataManager.getCustomerList().get(kunde.getLastName()) != null;
	}

	
	public void printAllCustomers() {
		HashMap<String, Kunde> customerList = dataManager.getCustomerList();
		if(customerList == null)
			customerList = new HashMap<String, Kunde>();
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%10s%25s%45s\n", "Firstname", "Lastname", "Address");
		System.out.println("____________________________________________________________________________________");
		for (String key : customerList.keySet()) {
			Kunde k = customerList.get(key);
			System.out.printf("%10s%25s%45s\n", k.getFirstName(), k.getLastName(), k.getAddress());
		}

	}
	
	public void printAllEvents() {
		HashMap<Integer, Veranstaltung> eventList = dataManager.getEventList();
		if(eventList == null)
			eventList = new HashMap<Integer, Veranstaltung>();
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%3s%40s%25s\n", "ID", "Title", "Date and Time");
		System.out.println("____________________________________________________________________________________");
		for (int key : eventList.keySet()) {
			Veranstaltung v = eventList.get(key);
			System.out.printf("%3d%40s%25s\n", v.getID(),v.getTitle(), v.getDateTime());
		}

	}
	

}
