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
		
	}	
	
	public static Preposes getPreposes() {
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

	public Preposes deserialisePreposes() {
		Preposes adh = new Preposes();
		
		try {
			FileInputStream fichier = new FileInputStream("preposes.ser");
			ObjectInputStream is = new ObjectInputStream(fichier);
	
			adh = (Preposes) is.readObject();
			System.out.println("désérialise preposes");

			is.close();
				
		} catch (FileNotFoundException e) {
		} catch (ClassNotFoundException e) {
		} catch (EOFException e) {
		} catch (IOException e) {}
		
		return adh;
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