package modele;

import java.io.EOFException;
import java.io.File;
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
	private ArrayList<Adherant> lstAdherants;
	private int compteurID;
	
	private Adherants() {
		compteurID = 1;
		lstAdherants = new ArrayList<Adherant>();
		
		try {
			if(new File("adherants.ser").exists()) {
				FileInputStream fichier = new FileInputStream("adherants.ser");
				ObjectInputStream is = new ObjectInputStream(fichier);
	
				instance = (Adherants) is.readObject();
				lstAdherants = instance.getLstAdherants();
				System.out.println("désérialise adherants");

				is.close();
				fichier.close();
			}
			
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
			instance=new Adherants(); System.out.println("L'instance adhérant est nulle");
		}
		return instance;
	}
	
	public void addLstAdherant(Adherant adher) {
		lstAdherants.add(adher);
	}
	
	public void addCompteur() {
		compteurID++;
	}

	public ArrayList<Adherant> getLstAdherants() {
		return lstAdherants;
	}
	
	public void serialiseAdherants() {
		try {
			FileOutputStream fichier = new FileOutputStream("adherants.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("adherants sérialisation");
			os.writeObject(instance);
			
			os.close();
			fichier.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getCompteurID() {
		return compteurID;
	}
	
}
