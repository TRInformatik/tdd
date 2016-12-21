package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import bookingSystem.Buchung;
import bookingSystem.Kunde;
import bookingSystem.Service;
import bookingSystem.Veranstaltung;

public class TestService {
	private static final String FILE_PATH = "src/DataFiles/";
	private static final String CUSTOMER_LIST_NAME = "Kunden";
	private static final String EVENT_LIST_NAME = "Veranstaltung";
	private static final String BOOKING_LIST_NAME = "Buchung";
	
	private Kunde k;
	private Veranstaltung v;

	private static Service service = new Service();
	
	@AfterClass
	public static void init(){
		service.printAllEvents();
		service.printAllCustomers();
		try {
			Files.deleteIfExists(Paths.get(FILE_PATH+"/"+CUSTOMER_LIST_NAME));
			Files.deleteIfExists(Paths.get(FILE_PATH+"/"+EVENT_LIST_NAME));
			Files.deleteIfExists(Paths.get(FILE_PATH+"/"+BOOKING_LIST_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
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
		k = service.createCustomer("Mustermann Mayer", "Musterstraße 1, 39878 Musterstadt");
		service.storeVeranstaltung(v2);
		Buchung b = service.book(6, k, v2, 5);
		int freeSeats = service.freeSeats(v2.getID());
		assertEquals(freeSeats, 10);
	}
	
	@Test(expected=Exception.class)
	public void testCheckSeats() throws Exception{
		Veranstaltung v3 = service.createVeranstaltung(7, "Silversterparty", "31.12.2016 19:00", 0.0, 30);
		Kunde k2 = service.createCustomer("Marko Mustermann", "Musterstraße 5, 39878 Musterstadt");
		service.storeVeranstaltung(v3);
		Buchung b = service.book(7, k2, v3, 35);
	}
	
	@Test
	public void testBooking() throws Exception{
		v = service.createVeranstaltung(22, "Weihnachtsmarkt 3", "20.12.2017 18:00", 0.0, 10);
		k = service.createCustomer("Mustermann Mayer", "Musterstraße 1, 39878 Musterstadt");
		service.storeVeranstaltung(v);
		
		Buchung b = service.book(8, k, v, 5);
	}
	
	@Test
	public void testMultipleBooking() throws Exception{
		Veranstaltung v3 = service.createVeranstaltung(19, "Rocknacht", "15.06.2017 16:00", 20.0, 250);
		Kunde k2 = service.createCustomer("Marko Mustermann", "Musterstraße 5, 39878 Musterstadt");
		service.storeVeranstaltung(v3);
		Buchung b1 = service.book(15, k2, v3, 5);
		Buchung b2 = service.book(17, k2, v3, 3);
		
		assertEquals(17, b2.getID());
		assertEquals(8, b2.getBookedSeats());
		
	}
	
	@Test
	public void testGetBookings() throws Exception{
		v = service.createVeranstaltung(100, "Neujahrsparty", "20.12.2017 18:00", 0.0, 10);
		k = service.createCustomer("Mustermann Maria", "Musterstraße 1, 39878 Musterstadt");
		service.storeVeranstaltung(v);
		service.book(122, k, v, 2);
		
		Buchung b = service.getBookings(k, v);
		
		
		assertNotNull(b);	
		System.out.println();
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%3s%25s%20s%20s\n", "ID", "Kunde", "Veranstaltungs-ID", "Anzahl Sitze");
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%3d%25s%20s%20s\n", b.getID(), b.getKunde(), b.getVeranstaltung(), b.getBookedSeats());
		

	}
	@Test
	public void testPrintCustomers(){
		service.printAllCustomers();
	}
	
	@Test
	public void testPrintEvents(){
		service.printAllEvents();
	}
	
}