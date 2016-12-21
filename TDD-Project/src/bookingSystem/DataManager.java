package bookingSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DataManager {
	private static final String FILE_PATH = "src/DataFiles/";
	private static final String CUSTOMER_LIST_NAME = "Kunden";
	private static final String EVENT_LIST_NAME = "Veranstaltung";
	private static final String BOOKING_LIST_NAME = "Buchung";

	public DataManager() {
		getCustomerList();//
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Kunde> getCustomerList() {
		HashMap<String, Kunde> customerList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			// check if file exists
			if (!fileExists(CUSTOMER_LIST_NAME)) {
				createNewFile(CUSTOMER_LIST_NAME);
			}
			fileInputStream = new FileInputStream(pathToLists + "/" + CUSTOMER_LIST_NAME);
			objectInputStream = new ObjectInputStream(fileInputStream);
			customerList = (HashMap<String, Kunde>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(customerList==null){
			customerList = new HashMap<String, Kunde>();
		}
		return customerList;
	}

	public void storeCustomerList(HashMap<String, Kunde> customerList) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			fileOutputStream = new FileOutputStream(pathToLists + "/" + CUSTOMER_LIST_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(customerList);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, Veranstaltung> getEventList() {
		HashMap<Integer, Veranstaltung> eventList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			// check if file exists
			if (!fileExists(EVENT_LIST_NAME)) {
				createNewFile(EVENT_LIST_NAME);
			}
			fileInputStream = new FileInputStream(pathToLists + "/" + EVENT_LIST_NAME);
			objectInputStream = new ObjectInputStream(fileInputStream);
			eventList = (HashMap<Integer, Veranstaltung>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(eventList==null){
			eventList = new HashMap<Integer, Veranstaltung>();
		}
		return eventList;
	}

	public void storeEventList(HashMap<Integer, Veranstaltung> eventList) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			fileOutputStream = new FileOutputStream(pathToLists + "/" + EVENT_LIST_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(eventList);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, Buchung> getBookingList() {
		HashMap<Integer, Buchung> bookingList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			// check if file exists
			if (!fileExists(BOOKING_LIST_NAME)) {
				createNewFile(BOOKING_LIST_NAME);
			}else{
				fileInputStream = new FileInputStream(pathToLists + "/" + BOOKING_LIST_NAME);
				objectInputStream = new ObjectInputStream(fileInputStream);
				bookingList = (HashMap<Integer, Buchung>) objectInputStream.readObject();
				objectInputStream.close();
				fileInputStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(bookingList==null){
			bookingList = new HashMap<Integer, Buchung>();
		}
		return bookingList;
	}

	public void storeBookingList(HashMap<Integer, Buchung> bookingList) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			fileOutputStream = new FileOutputStream(pathToLists + "/" + BOOKING_LIST_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(bookingList);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean fileExists(String filename) {
		for (File fileEntry : new File(FILE_PATH).listFiles()) {
			if (!fileEntry.isDirectory()) {
				if (fileEntry.getName().equals(filename)) {
					return true;
				}
			}
		}
		return false;
	}

	private void createNewFile(String filename) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(FILE_PATH + "/" + filename);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(null);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
