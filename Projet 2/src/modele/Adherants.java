package modele;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Adherants implements Serializable{

	private static final long serialVersionUID = 1L;
	private	static Adherants instance;
	private ArrayList<Adherant> lstAdherants = new ArrayList<>();
	
	public Adherants() {
		
	}	
	
	public static Adherants getAdherants() {
		if (instance==null) {
			instance=new Adherants();
		}
		return instance;
	}
	
	public void addLstAdherant(Adherant adher) {
		lstAdherants.add(adher);
	}

	public ArrayList<Adherant> getLstAdherants() {
		return lstAdherants;
	}

	public Adherants deserialiseAdherants() {
		Adherants adh = new Adherants();
		
		try {
			FileInputStream fichier = new FileInputStream("adherants.ser");
			ObjectInputStream is = new ObjectInputStream(fichier);
	
			adh = (Adherants) is.readObject();
			System.out.println("désérialise adherants");

			is.close();
				
		} catch (FileNotFoundException e) {
		} catch (ClassNotFoundException e) {
		} catch (EOFException e) {
		} catch (IOException e) {}
		
		return adh;
	}
	
	public static void serialiseAdherants() {
		try {
			FileOutputStream fichier = new FileOutputStream("adherants.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("adherants sérialisation");
			os.writeObject(instance);
			
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
