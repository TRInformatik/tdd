package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import bookingSystem.Buchung;
import bookingSystem.Kunde;
import bookingSystem.Service;
import bookingSystem.Veranstaltung;

public class TestService {

	private Kunde k;
	private Veranstaltung v;

	private Service service = new Service();
	
	@Test
	public void testCreateCustomer() {
		k = service.createCustomer("Max Mustermann", "Musterstraße 1, 39878 Musterstadt");
		assertNotNull(k);
		assertEquals("Max Mustermann", k.getName());
		assertEquals("Musterstraße 1, 39878 Musterstadt", k.getAddress());
	}
	
	@Test
	public void testStoreCustomer(){
		service.storeCustomer(new Kunde("Mustermann Mayer", "Musterstraße 1, 39878 Musterstadt"));
	}
	
	@Test
	public void testPrintCustomers(){
		service.printAllCustomers();
	}
	
	@Test
	public void testPrintEvents(){
		service.printAllEvents();
	}
	
	@Test
	public void testCreateVeranstaltung() throws ParseException{
		v = service.createVeranstaltung(5, "Weihnachtsmarkt", "20.12.2017 18:00", 0.0, 10);
		assertNotNull(v);
		assertEquals("Weihnachtsmarkt", v.getTitle());
		assertEquals("20.12.2017 18:00", v.getDateTime());
	}
	
	@Test
	public void testStoreVeranstaltung() throws ParseException{
		service.storeVeranstaltung(new Veranstaltung(5, "Weihnachtsmarkt", "20.12.2017 18:00", 0.0, 10));
	}
	
	@Test
	public void testGetFreeSeats() throws Exception{
		Veranstaltung v2 = service.createVeranstaltung(6, "Weihnachtsmarkt 2", "22.12.2017 19:00", 0.0, 15);
		k = new Kunde("Mustermann Mayer", "Musterstraße 1, 39878 Musterstadt");
		Buchung b = new Buchung(6, k.getName(), v2.getID(), 5);
		service.storeVeranstaltung(v2);
		service.book(b);
		int freeSeats = service.freeSeats(v2.getID());
		assertEquals(freeSeats, 10);
	}
	
	@Test(expected=Exception.class)
	public void testCheckSeats() throws Exception{
		Veranstaltung v3 = service.createVeranstaltung(7, "Silversterparty", "31.12.2016 19:00", 0.0, 30);
		Kunde k2 = new Kunde("Marko Mustermann", "Musterstraße 5, 39878 Musterstadt");
		Buchung b = new Buchung(7, k2.getName(), v3.getID(), 35);
		service.storeVeranstaltung(v3);
		service.book(b);
	}
	
	@Test
	public void testBooking() throws Exception{
		v = service.createVeranstaltung(5, "Weihnachtsmarkt", "20.12.2017 18:00", 0.0, 10);
		k = new Kunde("Mustermann Mayer", "Musterstraße 1, 39878 Musterstadt");
		Buchung b = new Buchung(8, k.getName(), v.getID(), 5);
		service.book(b);
	}
	
	
}