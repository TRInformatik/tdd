package bookingSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataManager {
	private static final String FILE_PATH = "src/DataFiles/";
	private static final String CUSTOMER_LIST_NAME = "Kunden";	
	
	public DataManager(){

	}

	@SuppressWarnings("unchecked")
	public List<Kunde> getCustomerList() {
		List<Kunde> customerList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
		fileInputStream = new FileInputStream(pathToLists+"/"+CUSTOMER_LIST_NAME);
		objectInputStream = new ObjectInputStream(fileInputStream);
		customerList = (List<Kunde>) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}	
		return customerList;
	}
	
	public void storeCustomerList(List<Kunde> customerList){
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			fileOutputStream = new FileOutputStream(pathToLists+"/"+CUSTOMER_LIST_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(customerList);			
			objectOutputStream.close();
			fileOutputStream.close();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
