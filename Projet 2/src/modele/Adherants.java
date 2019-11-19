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
	private static ArrayList<Adherant> lstAdherants = new ArrayList<>();
	private static int compteurID;
	
	public Adherants() {
		compteurID = 1;
		
		try {
			FileInputStream fichier = new FileInputStream("adherants.ser");
			ObjectInputStream is = new ObjectInputStream(fichier);
	
			instance = (Adherants) is.readObject();
			System.out.println("désérialise adherants");

			is.close();
				
		} catch (FileNotFoundException e) {
		//	e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static Adherants getInstance() {
		if (instance==null) {
			instance=new Adherants();
		}
		return instance;
	}
	
	public static void addLstAdherant(Adherant adher) {
		lstAdherants.add(adher);
	}
	
	public static void addCompteur() {
		compteurID++;
	}

	public static ArrayList<Adherant> getLstAdherants() {
		return lstAdherants;
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

	public static int getCompteurID() {
		return compteurID;
	}
	
}
