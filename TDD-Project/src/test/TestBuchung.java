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
		String firstName = "Firstname";
		String lastName = "Lastname";
		String address = "Straße 1, PLZ1, Ort";
		Kunde k = new Kunde(firstName, lastName, address);
		
		Buchung b = new Buchung(k.getFirstName(), v.getID());
		assertEquals(500, b.getVeranstaltung());
		
	}

}
