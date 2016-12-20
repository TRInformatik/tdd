package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bookingSystem.Veranstaltung;

public class TestVeranstaltung {

	@Test
	public void test() {
		Veranstaltung v = new Veranstaltung("Großes Fest im kleinen Garten", 13.0, 500);
		Veranstaltung v2 = new Veranstaltung("Zytanien", 25.0, 1000);
		assertEquals("Großes Fest im kleinen Garten", v.getTitle());
		assertEquals(500, v.getSeats());
		assertEquals(13.0, v.getTicketPrice());
		assertEquals("Zytanien", v2.getTitle());
		assertEquals(1000, v2.getSeats());
		assertEquals(25.0, v2.getTicketPrice());
	}

}
