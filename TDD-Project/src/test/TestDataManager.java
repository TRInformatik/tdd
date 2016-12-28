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
	Veranstaltung v1;
	Veranstaltung v2;
	Veranstaltung v3;
	@Before
	public void init() throws ParseException {
		v1 = new Veranstaltung(1, "Großes Fest im kleinen Garten", "01.01.2017 20:15", 13.0, 500, "email");
		v2 = new Veranstaltung(2, "Zytanien", "28.07.2017 16:00", 25.0, 1000, "email");
		v3 = new Veranstaltung(3, "Geburtstag", "05.06.2017 18:00", 0.0, 20, "email");
		dataManager = new DataManager();
	}

	@Test
	public void testKunde() {

		// The customer to store
		String name = "Hans Wurst";
		String addresse = "Strasse 1, PLZ1, Ort";

		HashMap<String, Kunde> kundenList = new HashMap<String, Kunde>();
		kundenList.put(name, new Kunde(name, addresse));
		dataManager.storeKundenList(kundenList);

		name = "Christiane Macke";
		addresse = "Neue Strasse 1, 4711, Koeln";
		kundenList.put(name, new Kunde(name, addresse));
		dataManager.storeKundenList(kundenList);
		assertEquals(2, kundenList.size());

		Kunde hans = kundenList.get("Hans Wurst");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Hans Wurst", hans.getName());
		assertEquals("Strasse 1, PLZ1, Ort", hans.getAddresse());

		Kunde christiane = kundenList.get("Christiane Macke");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Christiane Macke", christiane.getName());
		assertEquals("Neue Strasse 1, 4711, Koeln", christiane.getAddresse());

	}

	@Test
	public void testEvent() throws ParseException {

		HashMap<Integer, Veranstaltung> veranstaltungenList = new HashMap<Integer, Veranstaltung>();
		veranstaltungenList.put(v1.getID(), v1);
		dataManager.storeVeranstaltungenList(veranstaltungenList);

		veranstaltungenList.put(v2.getID(), v2);
		dataManager.storeVeranstaltungenList(veranstaltungenList);
		assertEquals(2, veranstaltungenList.size());

		Veranstaltung vt1 = veranstaltungenList.get(v1.getID());
		assertEquals(vt1.getClass(), Veranstaltung.class);
		assertEquals(v1.getTitel(), vt1.getTitel());
		assertEquals(v1.getDatumUhrzeit(), vt1.getDatumUhrzeit());
		assertEquals(v1.getGesamtzahlSitze(), vt1.getGesamtzahlSitze());

		Veranstaltung vt2 = veranstaltungenList.get(v2.getID());
		assertEquals(vt2.getClass(), Veranstaltung.class);
		assertEquals(v2.getTitel(), vt2.getTitel());
		assertEquals(v2.getDatumUhrzeit(), vt2.getDatumUhrzeit());
		assertEquals(v2.getGesamtzahlSitze(), vt2.getGesamtzahlSitze());

	}

	@Test
	public void testBooking() throws ParseException {
		
		String name = "Hans Wurst";
		String addresse = "Strasse 1, PLZ1, Ort";
		Kunde k1 = new Kunde(name, addresse);
		Buchung b1 = new Buchung(3, k1.getName(), v3.getID(), 3);

		HashMap<Integer, Buchung> buchungenList = new HashMap<Integer, Buchung>();
		buchungenList.put(b1.getID(), b1);
		dataManager.storeBuchungenList(buchungenList);

		Buchung b2 = new Buchung(4, k1.getName(), v2.getID(), 4);
		buchungenList.put(b2.getID(), b2);
		dataManager.storeBuchungenList(buchungenList);
		assertEquals(2, buchungenList.size());

		Buchung bt1 = buchungenList.get(b1.getID());
		assertEquals(bt1.getClass(), Buchung.class);
		assertEquals(v3.getID(), bt1.getVeranstaltung());
		assertEquals(k1.getName(), bt1.getKunde());
		assertEquals(b1.getGebuchteSitze(), bt1.getGebuchteSitze());

		Buchung bt2 = buchungenList.get(b2.getID());
		assertEquals(bt2.getClass(), Buchung.class);
		assertEquals(v2.getID(), bt2.getVeranstaltung());
		assertEquals(k1.getName(), bt2.getKunde());
		assertEquals(b2.getGebuchteSitze(), bt2.getGebuchteSitze());
	}
}
