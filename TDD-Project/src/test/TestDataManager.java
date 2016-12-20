package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bookingSystem.DataManager;
import bookingSystem.Kunde;

public class TestDataManager {

	@Test
	public void test() {
		DataManager dataManager = new DataManager();
		
		// The customer to store
		String firstName = "Hans";
		String lastName = "Wurst";
		String address = "Straße 1, PLZ1, Ort";
		
		List<Kunde> customerList = new ArrayList<Kunde>();
		customerList.add(new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		
		firstName = "Christiane";
		lastName = "Macke";
		address = "Neue Straße1, 4711, Köln";
		customerList.add(new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		assertEquals(2, customerList.size());
		
		Kunde hans = customerList.get(0);
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Hans", hans.getFirstName());
		assertEquals("Wurst", hans.getLastName());
		assertEquals("Straße 1, PLZ1, Ort", hans.getAddress());
		
		Kunde christiane = customerList.get(1);
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Christiane", christiane.getFirstName());
		assertEquals("Macke", christiane.getLastName());
		assertEquals("Neue Straße1, 4711, Köln", christiane.getAddress());
		
	}
}