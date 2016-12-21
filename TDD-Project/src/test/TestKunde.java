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
		k.setname("Macke");
		
		String firstName = k.getFirstName();
		assertEquals("Christiane", firstName);		
		
		String name = k.getname();
		assertEquals("Macke", name);
		
		k = new Kunde("Hermann");
		firstName = k.getFirstName();
		assertEquals("Hermann", firstName);
		
		k = new Kunde("Christian", "Vogel");
		firstName = k.getFirstName();
		name = k.getname();
		assertEquals("Christian", firstName);
		assertEquals("Vogel", name);
			
		String address = "Musterstraße 1, 0815 Musterstadt";
		k.setAddress(address);
		address = k.getAddress();
		assertEquals("Musterstraße 1, 0815 Musterstadt", address);
		*/
		String name = "Egon Walter";
		String address = "Straße 1, PLZ1, Ort";
		Kunde k = new Kunde(name, address);
		
		k.setName("Christiane Macke");
		name = k.getName();
		assertEquals("Christiane Macke", name);
		
		
		k.setAddress("Straße 2, PLZ2, Ort2");
		address = k.getAddress();
		assertEquals("Straße 2, PLZ2, Ort2", address);
		
		
		
	}
}
