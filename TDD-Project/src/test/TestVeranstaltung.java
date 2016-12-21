package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import bookingSystem.Veranstaltung;

public class TestVeranstaltung {
	
	private static final double DELTA = 1e-15;
	private Veranstaltung v1;
	private Veranstaltung v2; 
	private Veranstaltung v3;
		
	@Before 
	public void init() throws ParseException {
		 v1 = new Veranstaltung(1, "Großes Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500);
		 v2 = new Veranstaltung(2, "Zytanien", "28.07.2017 16:00", 25.0, 1000);
		 v3 = new Veranstaltung(3, "Geburtstag", "05.06.2017 18:00", 0.0, 20);
	}
	@Test
	public void testName() throws ParseException {
		assertEquals("Großes Fest im kleinen Garten", v1.getTitle());
		assertEquals("Zytanien", v2.getTitle());
	}
	
	@Test
	public void testSeatNumber() throws ParseException {
		assertEquals(500, v1.getSeats());
		assertEquals(1000, v2.getSeats());
	}
	
	@Test
	public void testPrice() throws ParseException {
		assertEquals(13.0, v1.getTicketPrice(), DELTA);
		assertEquals(25.0, v2.getTicketPrice(), DELTA);
	}
	
	@Test
	public void testID() throws ParseException{
		System.out.println(v1.getID()+", " + v2.getID() +", "+v3.getID());
		System.out.println((new Veranstaltung(4, "Silvester", "31.12.16 20:00", 5.0,100)).getID());
	}
	
	@Test
	public void testDate(){
		assertEquals("05.06.2017 18:00", v3.getDateTime());
	}
	
	@Test
	public void testSetter() throws ParseException{
		assertEquals("Großes Fest im kleinen Garten", v1.getTitle());
		assertEquals(500, v1.getSeats());
		assertEquals(13.0, v1.getTicketPrice(), DELTA);
		assertEquals("01.01.2017 20:15", v1.getDateTime());
		
		v1.setSeats(100);
		v1.setTicketPrice(11.0);
		v1.setTitle("Großes Fest/Kleiner Garten");
		v1.setDateTime("01.01.2017 19:00");
		
		assertEquals("Großes Fest/Kleiner Garten", v1.getTitle());
		assertEquals(100, v1.getSeats());
		assertEquals(11.0, v1.getTicketPrice(), DELTA);
		assertEquals("01.01.2017 19:00", v1.getDateTime());
	}
	@Test
	public void testBooking() throws Exception{
		v1.book(5);
		v1.book(13);
		v1.book(2);
		assertEquals(480, v1.getFreeSeats());
		assertEquals(500, v1.getSeats());
		
	}
	/*@Test(expected=Exception.class)
	public void testBookToMuch() throws Exception {
		v3.book(5);
		v3.book(10);
		try{
		v3.book(10);
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
		}
	}*/
}
