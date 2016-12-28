package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import bookingSystem.Buchung;
import bookingSystem.Kunde;
import bookingSystem.Veranstaltung;

public class TestBuchung {

	private Veranstaltung v1;
	private Veranstaltung v2;
	private Kunde k;
	@Before 
	public void init() throws ParseException {
		 v1 = new Veranstaltung(1, "Grosses Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500, "email");
		 v2 = new Veranstaltung(2, "Zytanien", "28.07.2017 16:00", 25.0, 1000, "email");
		String name = "Max Lastname";
		String addresse = "Strasse 1, PLZ1, Ort";
		k = new Kunde(name, addresse);
	}
	
	@Test
	public void testDeclaration() throws ParseException {
		Buchung b = new Buchung(1, k.getName(), v1.getID(), 5);
		assertEquals(v1.getID(), b.getVeranstaltung());
		assertEquals(k.getName(), b.getKunde());
		assertEquals(5, b.getGebuchteSitze());
	}
	
	@Test
	public void testID(){
		Buchung b = new Buchung(1, k.getName(), v1.getID(), 5);
		Buchung b2 = new Buchung(2, k.getName(), v2.getID(), 10);
		assertFalse("Gleiche ID!",b.getID()==b2.getID());
	}
	
	@Test
	public void testSetter(){
		Buchung b = new Buchung(1, k.getName(), v1.getID(), 5);
		assertEquals(v1.getID(), b.getVeranstaltung());
		assertEquals(k.getName(), b.getKunde());
		assertEquals(5, b.getGebuchteSitze());
		assertEquals(1,b.getID());
		
		b.setVeranstaltungsID(5);
		b.setKundenName("Horstl");
		b.setGebuchteSitze(7);
		b.setId(33);
		
		assertEquals(5, b.getVeranstaltung());
		assertEquals("Horstl", b.getKunde());
		assertEquals(7, b.getGebuchteSitze());
		assertEquals(33,b.getID());
	}

}
