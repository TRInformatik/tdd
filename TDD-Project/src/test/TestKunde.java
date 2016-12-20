package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bookingSystem.Kunde;

public class TestKunde {

	@Test
	public void test() {
		/*
		Kunde k;
		k = new Kunde();
		k.setFirstName("Christiane");
		k.setLastName("Macke");
		
		String firstName = k.getFirstName();
		assertEquals("Christiane", firstName);		
		
		String lastName = k.getLastName();
		assertEquals("Macke", lastName);
		
		k = new Kunde("Hermann");
		firstName = k.getFirstName();
		assertEquals("Hermann", firstName);
		
		k = new Kunde("Christian", "Vogel");
		firstName = k.getFirstName();
		lastName = k.getLastName();
		assertEquals("Christian", firstName);
		assertEquals("Vogel", lastName);
			
		String address = "Musterstraße 1, 0815 Musterstadt";
		k.setAddress(address);
		address = k.getAddress();
		assertEquals("Musterstraße 1, 0815 Musterstadt", address);
		*/
		String firstName = "Firstname";
		String lastName = "Lastname";
		String address = "Straße 1, PLZ1, Ort";
		Kunde k = new Kunde(firstName, lastName, address);
		
		
		k.setFirstName("Christiane");
		firstName = k.getFirstName();
		assertEquals("Christiane", firstName);
		
		k.setLastName("Macke");
		lastName = k.getLastName();
		assertEquals("Macke", lastName);
		
		k.setAddress("Straße 2, PLZ2, Ort2");
		address = k.getAddress();
		assertEquals("Straße 2, PLZ2, Ort2", address);
		
		
		
	}
}
