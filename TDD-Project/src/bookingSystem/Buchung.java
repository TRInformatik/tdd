package bookingSystem;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Buchung  implements Serializable {
	
	private static final long serialVersionUID = 6627407231172048073L;
	private int id;
	private int veranstaltungsID;
	private String kundenName;
	private int gebuchteSitze;
	
	public Buchung(int id, String kunde, int veranstaltung, int seats) {
		this.id = id;
		this.veranstaltungsID = veranstaltung;
		this.kundenName = kunde;
		this.gebuchteSitze = seats;
	}

	public int getVeranstaltung() {
		return veranstaltungsID;
	}

	public String getKunde() {
		return kundenName;
	}

	public int getGebuchteSitze() {
		return gebuchteSitze;
	}

	public int getID() {
		
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setVeranstaltungsID(int veranstaltungsID) {
		this.veranstaltungsID = veranstaltungsID;
	}

	public void setKundenName(String kundenName) {
		this.kundenName = kundenName;
	}

	public void setGebuchteSitze(int gebuchteSitze) {
		this.gebuchteSitze = gebuchteSitze;
	}

	public void addGebuchteSitze(int addGebuchteSitze) {
		this.gebuchteSitze = this.gebuchteSitze+addGebuchteSitze;
	}

}
