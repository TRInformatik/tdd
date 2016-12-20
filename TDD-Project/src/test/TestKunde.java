package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bookingSystem.Kunde;

public class TestKunde {

	@Test
	public void test() {
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
			
		
		
	}

}
