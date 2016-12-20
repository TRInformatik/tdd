package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import bookingSystem.Buchung;
import bookingSystem.Kunde;
import bookingSystem.Veranstaltung;

public class TestBuchung {

	@Test
	public void testDeclaration() throws ParseException {
		Veranstaltung v = new Veranstaltung("Großes Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500);
		Veranstaltung v2 = new Veranstaltung("Zytanien", "28.07.2017 16:00", 25.0, 1000);
		String firstName = "Firstname";
		String lastName = "Lastname";
		String address = "Straße 1, PLZ1, Ort";
		Kunde k = new Kunde(firstName, lastName, address);
		
		Buchung b = new Buchung(k.getFirstName(), v.getID(), 5);
		assertEquals(v.getID(), b.getVeranstaltung());
		assertEquals(k.getFirstName(), b.getKunde());
		assertEquals(5, b.getBookedSeats());
		System.out.println(b.getID());
		
		Buchung b2 = new Buchung(k.getFirstName(), v2.getID(), 10);
		assertFalse("Gleiche ID!",b.getID()==b2.getID());
		
	}

}
