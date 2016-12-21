package bookingSystem;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Veranstaltung implements Serializable {

	private static final long serialVersionUID = -3862786948644285639L;

	private int id;
	private String title;
	private int seats;
	private int freeSeats;
	private double ticketPrice;
	private DateFormat dfmt = new SimpleDateFormat( "dd.MM.yyyy HH:mm" );
	private Date dateTime;
	
	public Veranstaltung(int id, String title, String dateTime, double ticketPrice, int seats) throws ParseException {
		this.id = id;
		this.title = title;
		this.dateTime = dfmt.parse(dateTime);
		this.ticketPrice = ticketPrice;
		this.seats = seats;
		this.freeSeats = this.seats;
		
	}
	public String getTitle() {
		return title;
	}

	public int getSeats() {
		return seats;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public String getDateTime() {
		return dfmt.format(dateTime);
	}

	public void book(int bookedSeats) throws Exception {
		if(bookedSeats<=freeSeats){
			this.freeSeats -=bookedSeats;
		}else {
			throw new Exception("There are too few free seats for your booking! You wanted to book "+bookedSeats+" seats, but there are only "+freeSeats+" free!");
		}
		
	}
	public int getFreeSeats() {
		return freeSeats;
	}
	public int getID() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	private void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public void setDateTime(String dateTime) throws ParseException {
		this.dateTime = dfmt.parse(dateTime);
	}
}

