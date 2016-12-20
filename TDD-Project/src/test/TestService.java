package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import bookingSystem.DataManager;
import bookingSystem.Kunde;
import bookingSystem.Service;

public class TestService {
	
	@Test
	public void test() {

	}
	
	
	
	@Test
	public void printAllCustomer(){
		DataManager dataManager = new DataManager();
		HashMap<String, Kunde> customerList = dataManager.getCustomerList();
		for(String key : customerList.keySet()){
			System.out.println(customerList.get(key).getFirstName()+"\t"+customerList.get(key).getLastName()+"\t"+customerList.get(key).getAddress());
		}
	}
}
