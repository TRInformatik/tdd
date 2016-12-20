package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import bookingSystem.Veranstaltung;

public class TestVeranstaltung {
	
	private static final double DELTA = 1e-15;
		Veranstaltung v;
		Veranstaltung v2; 
	@Before 
	public void init() throws ParseException {
		 v = new Veranstaltung("Großes Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500);
		 v2 = new Veranstaltung("Zytanien", "28.07.2017 16:00", 25.0, 1000);
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
	public void testBooking(){
		v.book(5);
		v.book(13);
		v.book(2);
		assertEquals(480, v.getFreeSeats());
		assertEquals(500, v.getSeats());
	}

}
