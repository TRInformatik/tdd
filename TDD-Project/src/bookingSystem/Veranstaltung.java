package bookingSystem;

public class Veranstaltung {

	private String title;
	private int seats;
	private double ticketPrice;
	
	public Veranstaltung(String title, double d, int i) {
		this.title = title;
		this.ticketPrice = d;
		this.seats = i;
	}

	public String getTitle() {
		return title;
	}

	public Object getSeats() {
		return seats;
	}

	public Object getTicketPrice() {
		return ticketPrice;
	}

}
