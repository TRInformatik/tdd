package bookingSystem;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Buchung  implements Serializable {
	
	static AtomicInteger nextId = new AtomicInteger();
	private int id;
	private int eventID;
	private String kundenName;
	private int bookedSeats;
	
	public Buchung(String kunde, int veranstaltung, int seats) {
		this.id = nextId.incrementAndGet();
		this.eventID = veranstaltung;
		this.kundenName = kunde;
		this.bookedSeats = seats;
	}

	public int getVeranstaltung() {
		return eventID;
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

}
