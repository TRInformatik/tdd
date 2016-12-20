package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import bookingSystem.Veranstaltung;

public class TestVeranstaltung {
	
	private static final double DELTA = 1e-15;
	private Veranstaltung v;
	private Veranstaltung v2; 
	private Veranstaltung v3;
		
	@Before 
	public void init() throws ParseException {
		 v = new Veranstaltung("Großes Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500);
		 v2 = new Veranstaltung("Zytanien", "28.07.2017 16:00", 25.0, 1000);
		 v3 = new Veranstaltung("Geburtstag", "05.06.2017 18:00", 0.0, 20);
	}
	@Test
	public void testName() throws ParseException {
		assertEquals("Großes Fest im kleinen Garten", v.getTitle());
		assertEquals("Zytanien", v2.getTitle());
	}
	
	@Test
	public void testSeatNumber() throws ParseException {
		assertEquals(500, v.getSeats());
		assertEquals(1000, v2.getSeats());
	}
	
	@Test
	public void testPrice() throws ParseException {
		assertEquals(13.0, v.getTicketPrice(), DELTA);
		assertEquals(25.0, v2.getTicketPrice(), DELTA);
	}
	
	@Test
	public void testID() throws ParseException{
		System.out.println(v.getID()+", " + v2.getID() +", "+v3.getID());
		System.out.println((new Veranstaltung("Silvester", "31.12.16 20:00", 5.0,100)).getID());
	}
	@Test
	public void testBooking() throws Exception{
		v.book(5);
		v.book(13);
		v.book(2);
		assertEquals(480, v.getFreeSeats());
		assertEquals(500, v.getSeats());
		
	}
	@Test(expected=Exception.class)
	public void testBookToMuch() throws Exception {
		v3.book(5);
		v3.book(10);
		try{
		v3.book(10);
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
