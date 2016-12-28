package bookingSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DataManager {
	private static final String FILE_PATH = "src/DataFiles/";
	private static final String KUNDE_LIST_NAME = "Kunden";
	private static final String VERANSTALTUNG_LIST_NAME = "Veranstaltung";
	private static final String BUCHUNG_LIST_NAME = "Buchung";

	public DataManager() {
		getKundenList();//
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Kunde> getKundenList() {
		HashMap<String, Kunde> kundenList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			// check if file exists
			if (!fileExists(KUNDE_LIST_NAME)) {
				createNewFile(KUNDE_LIST_NAME);
			}
			fileInputStream = new FileInputStream(pathToLists + "/" + KUNDE_LIST_NAME);
			objectInputStream = new ObjectInputStream(fileInputStream);
			kundenList = (HashMap<String, Kunde>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(kundenList==null){
			kundenList = new HashMap<String, Kunde>();
		}
		return kundenList;
	}

	public void storeKundenList(HashMap<String, Kunde> kundenList) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			fileOutputStream = new FileOutputStream(pathToLists + "/" + KUNDE_LIST_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(kundenList);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, Veranstaltung> getVeranstaltungenList() {
		HashMap<Integer, Veranstaltung> veranstaltungList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			// check if file exists
			if (!fileExists(VERANSTALTUNG_LIST_NAME)) {
				createNewFile(VERANSTALTUNG_LIST_NAME);
			}
			fileInputStream = new FileInputStream(pathToLists + "/" + VERANSTALTUNG_LIST_NAME);
			objectInputStream = new ObjectInputStream(fileInputStream);
			veranstaltungList = (HashMap<Integer, Veranstaltung>) objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(veranstaltungList==null){
			veranstaltungList = new HashMap<Integer, Veranstaltung>();
		}
		return veranstaltungList;
	}

	public void storeVeranstaltungenList(HashMap<Integer, Veranstaltung> veranstaltungList) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			fileOutputStream = new FileOutputStream(pathToLists + "/" + VERANSTALTUNG_LIST_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(veranstaltungList);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<Integer, Buchung> getBuchungenList() {
		HashMap<Integer, Buchung> buchungenList = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			// check if file exists
			if (!fileExists(BUCHUNG_LIST_NAME)) {
				createNewFile(BUCHUNG_LIST_NAME);
			}else{
				fileInputStream = new FileInputStream(pathToLists + "/" + BUCHUNG_LIST_NAME);
				objectInputStream = new ObjectInputStream(fileInputStream);
				buchungenList = (HashMap<Integer, Buchung>) objectInputStream.readObject();
				objectInputStream.close();
				fileInputStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(buchungenList==null){
			buchungenList = new HashMap<Integer, Buchung>();
		}
		return buchungenList;
	}

	public void storeBuchungenList(HashMap<Integer, Buchung> buchungenList) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			String pathToLists = new File(FILE_PATH).getCanonicalPath().toString();
			fileOutputStream = new FileOutputStream(pathToLists + "/" + BUCHUNG_LIST_NAME);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(buchungenList);
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
