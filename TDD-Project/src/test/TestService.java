package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import org.junit.AfterClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import bookingSystem.BlackListService;
import bookingSystem.Buchung;
import bookingSystem.EMailService;
import bookingSystem.Kunde;
import bookingSystem.Service;
import bookingSystem.Veranstaltung;

public class TestService {
	private static final String FILE_PATH = "src/DataFiles/";
	private static final String KUNDEN_LIST_NAME = "Kunden";
	private static final String VERANSTALTUNGEN_LIST_NAME = "Veranstaltung";
	private static final String BUCHUNGEN_LIST_NAME = "Buchung";

	private Kunde k;
	private Veranstaltung v;

	private static Service service = new Service();

	@AfterClass
	public static void init() {
		service.printAllVeranstaltungen();
		service.printAllKunden();
		try {
			Files.deleteIfExists(Paths.get(FILE_PATH + "/" + KUNDEN_LIST_NAME));
			Files.deleteIfExists(Paths.get(FILE_PATH + "/" + VERANSTALTUNGEN_LIST_NAME));
			Files.deleteIfExists(Paths.get(FILE_PATH + "/" + BUCHUNGEN_LIST_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testCreateKunde() {
		k = service.createKunde("Max Mustermann", "Musterstrasse 1, 39878 Musterstadt");
		assertNotNull(k);
		assertEquals("Max Mustermann", k.getName());
		assertEquals("Musterstrasse 1, 39878 Musterstadt", k.getAddresse());
	}

	@Test
	public void testStoreKunde() {
		service.storeKunde(new Kunde("Mustermann Mayer", "Musterstrasse 1, 39878 Musterstadt"));
	}

	@Test
	public void testCreateVeranstaltung() throws ParseException {
		v = service.createVeranstaltung(5, "Weihnachtsmarkt", "20.12.2017 18:00", 0.0, 10, "email");
		assertNotNull(v);
		assertEquals("Weihnachtsmarkt", v.getTitel());
		assertEquals("20.12.2017 18:00", v.getDatumUhrzeit());
	}

	@Test
	public void testStoreVeranstaltung() throws ParseException {
		service.storeVeranstaltung(new Veranstaltung(5, "Weihnachtsmarkt", "20.12.2017 18:00", 0.0, 10, "email"));
	}

	@Test
	public void testGetFreieSitze() throws Exception {
		Veranstaltung v2 = service.createVeranstaltung(6, "Weihnachtsmarkt 2", "22.12.2017 19:00", 0.0, 15, "email");
		k = service.createKunde("Mustermann Mayer", "Musterstrasse 2, 39878 Musterstadt");
		service.storeVeranstaltung(v2);
		Buchung b = service.book(6, k, v2, 5);
		int freieSitze = service.checkFreieSitze(v2.getID());
		assertEquals(freieSitze, 10);
	}

	@Test(expected = Exception.class)
	public void testCheckSitze() throws Exception {
		Veranstaltung v3 = service.createVeranstaltung(7, "Silversterparty", "31.12.2016 19:00", 0.0, 30, "email");
		Kunde k2 = service.createKunde("Marko Mustermann", "Musterstrasse 5, 39878 Musterstadt");
		service.storeVeranstaltung(v3);
		service.book(7, k2, v3, 35);
	}

	@Test
	public void testBooking() throws Exception {
		v = service.createVeranstaltung(22, "Weihnachtsmarkt 3", "20.12.2017 18:00", 0.0, 10, "email");
		k = service.createKunde("Mustermann Mayer", "Musterstrasse 4, 39878 Musterstadt");
		service.storeVeranstaltung(v);
		service.book(8, k, v, 5);
	}

	@Test
	public void testMultipleBooking() throws Exception {
		Veranstaltung v3 = service.createVeranstaltung(19, "Rocknacht", "15.06.2017 16:00", 20.0, 250, "email");
		Kunde k2 = service.createKunde("Marko Mustermann", "Musterstrasse 5, 39878 Musterstadt");
		service.storeVeranstaltung(v3);
		Buchung b1 = service.book(15, k2, v3, 5);
		Buchung b2 = service.book(17, k2, v3, 3);

		assertEquals(17, b2.getID());
		assertEquals(8, b2.getGebuchteSitze());

	}

	@Test
	public void testGetBookings() throws Exception {
		v = service.createVeranstaltung(100, "Neujahrsparty", "20.12.2017 18:00", 0.0, 10, "email");
		k = service.createKunde("Mustermann Maria", "Musterstrasse 7, 39878 Musterstadt");
		service.storeVeranstaltung(v);
		service.book(122, k, v, 2);

		Buchung b = service.getBuchungen(k, v);

		assertNotNull(b);
		System.out.println();
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%3s%25s%20s%20s\n", "ID", "Kunde", "Veranstaltungs-ID", "Anzahl Sitze");
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%3d%25s%20s%20s\n", b.getID(), b.getKunde(), b.getVeranstaltung(), b.getGebuchteSitze());

	}
	
	@Test
	public void testEmailIsSend() throws Exception{
		EMailService mailService = Mockito.mock(EMailService.class);
		when(mailService.isInformed(anyString(), anyObject())).thenReturn(true);
		v = service.createVeranstaltung(125, "Neujahrsparty 2017", "01.01.2017 18:00", 0.0, 10, "email");
		k = service.createKunde("Mustermann Maria", "Musterstrasse 7, 39878 Musterstadt");
		service.storeVeranstaltung(v);
		Buchung b = new Buchung(1112, k.getName(), v.getID(), 3);
		service.checkBigOrder(mailService,b , v);
		verify(mailService, times(1)).isInformed(v.getEmail(), b);
	}

	@Test
	public void testEmailIsNotSend() throws Exception{
		EMailService mailService = Mockito.mock(EMailService.class);
		when(mailService.isInformed(anyString(), anyObject())).thenReturn(false);
		v = service.createVeranstaltung(126, "Neujahrsparty 2018", "01.01.2018 18:00", 0.0, 100, "email");
		k = service.createKunde("Mustermann Maria", "Musterstrasse 1, 39878 Musterstadt");
		service.storeVeranstaltung(v);
		Buchung b = new Buchung(1112, k.getName(), v.getID(), 10);
		service.checkBigOrder(mailService,b , v);
		verify(mailService, never()).isInformed(v.getEmail(), b);
	}
	
	@Test
	public void testKundeIsBanned() {
		BlackListService blackListService = Mockito.mock(BlackListService.class);
		when(blackListService.kundeIsLocked(anyString())).thenReturn(true);
		Kunde k = new Kunde("Daisy Duck", "Entenhausen");
		assertTrue(blackListService.kundeIsLocked(k.getName()));
	}
	
	@Test
	public void testKundeNotBanned() {
		BlackListService blackListService = Mockito.mock(BlackListService.class);
		when(blackListService.kundeIsLocked(anyString())).thenReturn(false);
		Kunde k = new Kunde("Daisy Duck", "Entenhausen");
		assertFalse(blackListService.kundeIsLocked(k.getName()));
	}

	@Test
	public void testPrintKunden() {
		service.printAllKunden();
	}

	@Test
	public void testPrintVeranstaltungen() {
		service.printAllVeranstaltungen();
	}

}