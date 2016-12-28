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
	private String titel, email;
	private int gesamtzahlSitze;
	private int freieSitze;
	private double kartenPreis;
	private DateFormat dfmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	private Date datumUhrzeit;

	public Veranstaltung(int id, String titel, String datumUhrzeit, double kartenPreis, int gesamtzahlSitze, String email)
			throws ParseException {
		this.id = id;
		this.titel = titel;
		this.datumUhrzeit = dfmt.parse(datumUhrzeit);
		this.kartenPreis = kartenPreis;
		this.gesamtzahlSitze = gesamtzahlSitze;
		this.freieSitze = this.gesamtzahlSitze;
		this.setEmail(email);

	}
	
	public String getTitel() {
		return titel;
	}

	public int getGesamtzahlSitze() {
		return gesamtzahlSitze;
	}

	public double getKartenPreis() {
		return kartenPreis;
	}

	public String getDatumUhrzeit() {
		return dfmt.format(datumUhrzeit);
	}

	public void book(int bookedSeats) {
		this.freieSitze -= bookedSeats;
	}

	public int getFreieSitze() {
		return freieSitze;
	}

	public int getID() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public void setGesamtzahlSitze(int gesamtzahlSitze) {
		this.gesamtzahlSitze = gesamtzahlSitze;
	}

	public void setFreieSitze(int freieSitze) {
		this.freieSitze = freieSitze;
	}

	public void setKartenPreis(double kartenPreis) {
		this.kartenPreis = kartenPreis;
	}

	public void setDatumUhrzeit(String datumUhrzeit) throws ParseException {
		this.datumUhrzeit = dfmt.parse(datumUhrzeit);
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
