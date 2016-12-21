package bookingSystem;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Buchung  implements Serializable {
	
	private static final long serialVersionUID = 6627407231172048073L;
	private int id;
	private int veranstaltungsID;
	private String kundenName;
	private int bookedSeats;
	
	public Buchung(int id, String kunde, int veranstaltung, int seats) {
		this.id = id;
		this.veranstaltungsID = veranstaltung;
		this.kundenName = kunde;
		this.bookedSeats = seats;
	}

	public int getVeranstaltung() {
		return veranstaltungsID;
	}

	public String getKunde() {
		return kundenName;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public int getID() {
		
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setEventID(int veranstaltungsID) {
		this.veranstaltungsID = veranstaltungsID;
	}

	public void setKundenName(String kundenName) {
		this.kundenName = kundenName;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public void addSeats(int addSeats) {
		this.bookedSeats = this.bookedSeats+addSeats;
	}

}
