package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bookingSystem.Kunde;

public class TestKunde {

	@Test
	public void test() {
		
		/*
		 * Old test, where still first and last name was used
		 * 
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
			
		String addresse = "Musterstrasse 1, 0815 Musterstadt";
		k.setAddresse(address);
		addresse = k.getAddress();
		assertEquals("Musterstrasse 1, 0815 Musterstadt", addresse);
		*/
		String name = "Egon Walter";
		String addresse = "Strasse 1, PLZ1, Ort";
		Kunde k = new Kunde(name, addresse);
		
		k.setName("Christiane Macke");
		name = k.getName();
		assertEquals("Christiane Macke", name);
		
		
		k.setAddresse("Strasse 2, PLZ2, Ort2");
		addresse = k.getAddresse();
		assertEquals("Strasse 2, PLZ2, Ort2", addresse);
		
		
		
	}
}
