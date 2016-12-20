package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import bookingSystem.Buchung;
import bookingSystem.DataManager;
import bookingSystem.Kunde;
import bookingSystem.Veranstaltung;

public class TestDataManager {
	
	public DataManager dataManager;
	
	@Before 
	public void init(){
		dataManager = new DataManager();
	}
	
	@Test
	public void testCustomer() {
		
		
		// The customer to store
		String firstName = "Hans";
		String lastName = "Wurst";
		String address = "Straße 1, PLZ1, Ort";
		
		HashMap<String, Kunde> customerList = new HashMap<String, Kunde>();
		customerList.put(lastName, new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		
		firstName = "Christiane";
		lastName = "Macke";
		address = "Neue Straße1, 4711, Köln";
		customerList.put(lastName, new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		assertEquals(2, customerList.size());
		
		
		Kunde hans = customerList.get("Wurst");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Hans", hans.getFirstName());
		assertEquals("Wurst", hans.getLastName());
		assertEquals("Straße 1, PLZ1, Ort", hans.getAddress());
		
		
		Kunde christiane = customerList.get("Macke");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Christiane", christiane.getFirstName());
		assertEquals("Macke", christiane.getLastName());
		assertEquals("Neue Straße1, 4711, Köln", christiane.getAddress());
		
	}
	
	@Test
	public void testBooking() throws ParseException {

		// The customer to store
		 Veranstaltung v = new Veranstaltung("Großes Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500);
		 Veranstaltung v2 = new Veranstaltung("Zytanien", "28.07.2017 16:00", 25.0, 1000);
		 Veranstaltung v3 = new Veranstaltung("Geburtstag", "05.06.2017 18:00", 0.0, 20);
		
		HashMap<Integer, Veranstaltung> eventList = new HashMap<Integer, Veranstaltung>();
		eventList.put(v.getID(), v);
		dataManager.storeEventList(eventList);
		
		eventList.put(v2.getID(), v2);
		dataManager.storeEventList(eventList);
		assertEquals(2, eventList.size());
		
		
		Veranstaltung vt1 = eventList.get(v.getID());
		assertEquals(vt1.getClass(), Veranstaltung.class);
		assertEquals(v.getTitle(), vt1.getTitle());
		assertEquals(v.getDateTime(), vt1.getDateTime());
		assertEquals(v.getSeats(), vt1.getSeats());
		
		
		Veranstaltung vt2 = eventList.get(v2.getID());
		assertEquals(vt2.getClass(), Veranstaltung.class);
		assertEquals(v2.getTitle(), vt2.getTitle());
		assertEquals(v2.getDateTime(), vt2.getDateTime());
		assertEquals(v2.getSeats(), vt2.getSeats());
		
		
	}
	
	@Test
	public void testEvent() throws ParseException {

		// The customer to store
		 Veranstaltung v = new Veranstaltung("Großes Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500);
		 Veranstaltung v2 = new Veranstaltung("Zytanien", "28.07.2017 16:00", 25.0, 1000);
		 Veranstaltung v3 = new Veranstaltung("Geburtstag", "05.06.2017 18:00", 0.0, 20);
		 String firstName = "Hans";
		String lastName = "Wurst";
		String address = "Straße 1, PLZ1, Ort";
		Kunde k1 =  new Kunde(firstName, lastName, address);
		Buchung b1 = new Buchung(k1.getFirstName(), v3.getID(), 3);
		
		HashMap<Integer, Buchung> bookingList = new HashMap<Integer, Buchung>();
		bookingList.put(b1.getID(), b1);
		dataManager.storeBookingList(bookingList);
		
		Buchung b2 = new Buchung(k1.getFirstName(), v2.getID(), 4);
		bookingList.put(b2.getID(), b2);
		dataManager.storeBookingList(bookingList);
		assertEquals(2, bookingList.size());
		
		
		Buchung bt1 = bookingList.get(b1.getID());
		assertEquals(bt1.getClass(), Buchung.class);
		assertEquals(v3.getID(), bt1.getVeranstaltung());
		assertEquals(k1.getFirstName(), bt1.getKunde());
		assertEquals(b1.getBookedSeats(), bt1.getBookedSeats());
		
		
		Buchung bt2 = bookingList.get(b2.getID());
		assertEquals(bt2.getClass(), Buchung.class);
		assertEquals(v2.getID(), bt2.getVeranstaltung());
		assertEquals(k1.getFirstName(), bt2.getKunde());
		assertEquals(b2.getBookedSeats(), bt2.getBookedSeats());
		
		
	}
}
