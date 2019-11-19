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

public class Preposes implements Serializable{

	private static final long serialVersionUID = 1L;
	private	static Preposes instance;
	private ArrayList<Prepose> lstPreposes = new ArrayList<>();
	
	public Preposes() {
		try {
			FileInputStream fichier = new FileInputStream("preposes.ser");
			ObjectInputStream is = new ObjectInputStream(fichier);
	
			instance = (Preposes) is.readObject();
			System.out.println("désérialise preposes");

			is.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static Preposes getInstance() {
		if (instance==null) {
			instance = new Preposes();
		}
		return instance;
	}
	
	public void addLstPrepose(Prepose prep) {
		lstPreposes.add(prep);
	}

	public ArrayList<Prepose> getLstPreposes() {
		return lstPreposes;
	}
	
	public static void serialisePreposes() {
		try {
			FileOutputStream fichier = new FileOutputStream("preposes.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("preposes sérialisation");
			os.writeObject(instance);
			
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}