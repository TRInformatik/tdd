package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bookingSystem.Kunde;
import bookingSystem.Service;

public class TestService {

	private Kunde k;

	private Service service = new Service();
	
	@Test
	public void createCustomer() {
		k = service.createCustomer("Max", "Mustermann", "Musterstraße 1, 39878 Musterstadt");
		assertNotNull(k);
		assertEquals("Max", k.getFirstName());
		assertEquals("Mustermann", k.getLastName());
		assertEquals("Musterstraße 1, 39878 Musterstadt", k.getAddress());
	}
	
	@Test
	public void storeCustomer(){
		service.storeCustomer(new Kunde("Max", "Mustermann-Mayer", "Musterstraße 1, 39878 Musterstadt"));
	}
	
	@Test
	public void printCustomers(){
		service.printAllCustomers();
	}
	
	
}
