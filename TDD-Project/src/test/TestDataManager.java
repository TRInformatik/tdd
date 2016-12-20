package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import bookingSystem.DataManager;
import bookingSystem.Kunde;
import bookingSystem.Veranstaltung;

public class TestDataManager {
	
	public DataManager dataManager;
	
	@Before 
	public void init(){
		dataManager = new DataManager();
	}
	
	@Test
	public void testCustomer() {
		
		
		// The customer to store
		String firstName = "Hans";
		String lastName = "Wurst";
		String address = "Straße 1, PLZ1, Ort";
		
		HashMap<String, Kunde> customerList = new HashMap<String, Kunde>();
		customerList.put(lastName, new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		
		firstName = "Christiane";
		lastName = "Macke";
		address = "Neue Straße1, 4711, Köln";
		customerList.put(lastName, new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		assertEquals(2, customerList.size());
		
		
		Kunde hans = customerList.get("Wurst");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Hans", hans.getFirstName());
		assertEquals("Wurst", hans.getLastName());
		assertEquals("Straße 1, PLZ1, Ort", hans.getAddress());
		
		
		Kunde christiane = customerList.get("Macke");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Christiane", christiane.getFirstName());
		assertEquals("Macke", christiane.getLastName());
		assertEquals("Neue Straße1, 4711, Köln", christiane.getAddress());
		
	}@Test
	
	public void testEvent() {
		
		
		// The customer to store
		String firstName = "Hans";
		String lastName = "Wurst";
		String address = "Straße 1, PLZ1, Ort";
		
		HashMap<String, Kunde> customerList = new HashMap<String, Kunde>();
		customerList.put(lastName, new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		
		firstName = "Christiane";
		lastName = "Macke";
		address = "Neue Straße1, 4711, Köln";
		customerList.put(lastName, new Kunde(firstName, lastName, address));
		dataManager.storeCustomerList(customerList);
		assertEquals(2, customerList.size());
		
		
		Kunde hans = customerList.get("Wurst");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Hans", hans.getFirstName());
		assertEquals("Wurst", hans.getLastName());
		assertEquals("Straße 1, PLZ1, Ort", hans.getAddress());
		
		
		Kunde christiane = customerList.get("Macke");
		assertEquals(hans.getClass(), Kunde.class);
		assertEquals("Christiane", christiane.getFirstName());
		assertEquals("Macke", christiane.getLastName());
		assertEquals("Neue Straße1, 4711, Köln", christiane.getAddress());
		
		
	}
}
