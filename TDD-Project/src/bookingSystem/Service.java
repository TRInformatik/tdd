package bookingSystem;

import java.text.ParseException;
import java.util.HashMap;

import org.mockito.Mock;
import org.mockito.Mockito;

public class Service {

	private DataManager dataManager = new DataManager();

	public Kunde createKunde(String name, String addresse) {
		return new Kunde(name, addresse);
	}

	public void storeKunde(Kunde kunde) {
		if (alreadyExist(kunde)) {
			System.out.println("Customer already exists.");
		} else {
			HashMap<String, Kunde> kundenList = dataManager.getKundenList();
			kundenList.put(kunde.getName(), kunde);
			dataManager.storeKundenList(kundenList);
		}
	}

	private boolean alreadyExist(Kunde kunde) {
		return dataManager.getKundenList().get(kunde.getName()) != null;
	}

	
	public void printAllKunden() {
		HashMap<String, Kunde> kundenList = dataManager.getKundenList();
		if(kundenList == null)
			kundenList = new HashMap<String, Kunde>();
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%25s%45s\n", "Name", "Address");
		System.out.println("____________________________________________________________________________________");
		for (String key : kundenList.keySet()) {
			Kunde k = kundenList.get(key);
			System.out.printf("%25s%45s\n", k.getName(),k.getAddresse());
		}

	}
	
	public void printAllVeranstaltungen() {
		HashMap<Integer, Veranstaltung> veranstaltungenList = dataManager.getVeranstaltungenList();
		if(veranstaltungenList == null)
			veranstaltungenList = new HashMap<Integer, Veranstaltung>();
		System.out.println("____________________________________________________________________________________");
		System.out.printf("%3s%40s%25s\n", "ID", "Title", "Date and Time");
		System.out.println("____________________________________________________________________________________");
		for (int key : veranstaltungenList.keySet()) {
			Veranstaltung v = veranstaltungenList.get(key);
			System.out.printf("%3d%40s%25s\n", v.getID(),v.getTitel(), v.getDatumUhrzeit());
		}

	}

	public Veranstaltung createVeranstaltung(int id, String titel, String datum, double preis, int sitze, String email) throws ParseException {
		return new Veranstaltung(id, titel, datum, preis, sitze, email);
	}

	public void storeVeranstaltung(Veranstaltung v) {
		HashMap<Integer, Veranstaltung> veranstaltungenList = dataManager.getVeranstaltungenList();
		veranstaltungenList.put(v.getID(), v);
		dataManager.storeVeranstaltungenList(veranstaltungenList);
		
	}

	public int checkFreieSitze(int id) {
		HashMap<Integer, Veranstaltung> veranstaltungenList = dataManager.getVeranstaltungenList();
		return veranstaltungenList.get(id).getFreieSitze();
	}

	public Buchung book(int id, Kunde kunde, Veranstaltung veranstaltung, int gebuchteSitze) throws Exception {
		Buchung newBuchung = new Buchung(id, kunde.getName(), veranstaltung.getID(), gebuchteSitze);
		HashMap<Integer, Veranstaltung> veranstaltungenList = dataManager.getVeranstaltungenList();
		int freieSitze = veranstaltungenList.get(veranstaltung.getID()).getFreieSitze();
		if(freieSitze >= gebuchteSitze){
			HashMap<Integer, Buchung> buchungenList = dataManager.getBuchungenList();
			Buchung b = getBuchungen(kunde, veranstaltung);
			int i=-1;
			if(b != null && buchungenList!=null){
				newBuchung.addGebuchteSitze(b.getGebuchteSitze());
				for (int keyBook : buchungenList.keySet()) {
					if(keyBook == b.getID()){
						i = keyBook;
					}
				}
				if(i>=0){
					buchungenList.remove(i, buchungenList.get(i));
				}
			}
			buchungenList.put(newBuchung.getID(), newBuchung);
			
			checkBigOrder(Mockito.mock(EMailService.class),newBuchung, veranstaltung);			

			dataManager.storeBuchungenList(buchungenList);
			veranstaltungenList.get(newBuchung.getVeranstaltung()).book(gebuchteSitze);
			dataManager.storeVeranstaltungenList(veranstaltungenList);			
		}else{
			throw new Exception("Too many bookings! You ordered " + newBuchung.getGebuchteSitze() + " but there are ony "+freieSitze+" free!");
		}
		return newBuchung;
	}

	public void checkBigOrder(EMailService mailService, Buchung newBuchung, Veranstaltung veranstaltung) {
		if(newBuchung.getGebuchteSitze()>(veranstaltung.getGesamtzahlSitze()/10)){
			mailService.isInformed(veranstaltung.getEmail(), newBuchung);
		}
	}

	public Buchung getBuchungen(Kunde k, Veranstaltung v) {
		HashMap<Integer, Buchung> buchungenList = dataManager.getBuchungenList();
		Buchung b;
		if(buchungenList!=null){
			for(int keyListing : buchungenList.keySet()){
				b = buchungenList.get(keyListing);
				if(b.getKunde().equals(k.getName()) && (b.getVeranstaltung()==v.getID()))
					return b;
			}
			
		}
		return null;
	}
}