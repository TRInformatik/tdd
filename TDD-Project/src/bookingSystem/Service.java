package bookingSystem;

import java.text.ParseException;
import java.util.HashMap;

public class Service {

	private DataManager dataManager = new DataManager();

	public Kunde createCustomer(String name, String address) {
		return new Kunde(name, address);
	}

	public void storeCustomer(Kunde kunde) {
		if (alreadyExist(kunde)) {
			System.out.println("Customer already exists.");
		} else {
			HashMap<String, Kunde> customerList = dataManager.getCustomerList();
			customerList.put(kunde.getName(), kunde);
			dataManager.storeCustomerList(customerList);
		}
	}

	private boolean alreadyExist(Kunde kunde) {
		return dataManager.getCustomerList().get(kunde.getName()) != null;
	}

	
	public void printAllCustomers() {
		HashMap<String, Kunde> customerList = dataManager.getCustomerList();
		if(customerList == null)
			customerList = new HashMap<String, Kunde>();
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%25s%45s\n", "Name", "Address");
		System.out.println("____________________________________________________________________________________");
		for (String key : customerList.keySet()) {
			Kunde k = customerList.get(key);
			System.out.printf("%25s%45s\n", k.getName(),k.getAddress());
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

	public Veranstaltung createVeranstaltung(int id, String title, String date, double price, int seats) throws ParseException {
		return new Veranstaltung(id, title, date, price, seats);
	}

	public void storeVeranstaltung(Veranstaltung v) {
		HashMap<Integer, Veranstaltung> eventList = dataManager.getEventList();
		eventList.put(v.getID(), v);
		dataManager.storeEventList(eventList);
		
	}

	public int freeSeats(int id) {
		HashMap<Integer, Veranstaltung> eventList = dataManager.getEventList();
		return eventList.get(id).getFreeSeats();
	}

	public Buchung book(int id, Kunde kunde, Veranstaltung veranstaltung, int bookedSeats) throws Exception {
		Buchung newBooking = new Buchung(id, kunde.getName(), veranstaltung.getID(), bookedSeats);
		HashMap<Integer, Veranstaltung> eventList = dataManager.getEventList();
		int freeSeats = eventList.get(veranstaltung.getID()).getFreeSeats();
		
		if(freeSeats >= bookedSeats){
			HashMap<Integer, Buchung> bookingList = dataManager.getBookingList();
			Buchung b = getBookings(kunde, veranstaltung);
			
			int i=-1;
			if(b != null && bookingList!=null){
				newBooking.addSeats(b.getBookedSeats());
				for (int keyBook : bookingList.keySet()) {
					if(keyBook == b.getID())
						i = keyBook;
				}
				if(i>=0){
					bookingList.remove(i, bookingList.get(i));
				}
			}
			bookingList.put(newBooking.getID(), newBooking);
			dataManager.storeBookingList(bookingList);
		
			eventList.get(newBooking.getVeranstaltung()).book(bookedSeats);
			dataManager.storeEventList(eventList);	
			
		}else{
			throw new Exception("Too many bookings! You ordered" + newBooking.getBookedSeats() + " but there are ony "+freeSeats+" free!");
		}
		return newBooking;
	}

	public Buchung getBookings(Kunde k, Veranstaltung v) {
		HashMap<Integer, Buchung> bookingList = dataManager.getBookingList();
		Buchung b;
		if(bookingList!=null){
			for(int keyListing : bookingList.keySet()){
				b = bookingList.get(keyListing);
				if(b.getKunde().equals(k.getName()) && (b.getVeranstaltung()==v.getID()))
					return b;
			}
		}
		return null;
	}
	

}