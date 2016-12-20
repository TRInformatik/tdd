package bookingSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Veranstaltung {

	private String title;
	private int seats;
	private int freeSeats;
	private double ticketPrice;
	DateFormat dfmt = new SimpleDateFormat( "dd.MM.yyyy HH:mm" );
	private Date dateTime;
	
	public Veranstaltung(String title, String dateTime, double ticketPrice, int seats) throws ParseException {
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
	
}

