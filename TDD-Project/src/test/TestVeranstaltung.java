package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bookingSystem.Veranstaltung;

public class TestVeranstaltung {

	@Test
	public void test() {
		Veranstaltung v = new Veranstaltung();
		System.out.println(v.title());
	}

}
