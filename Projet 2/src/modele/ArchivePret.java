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

public class ArchivePret implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private	static ArchivePret instance;
	private ArrayList<Pret> lstPrets = new ArrayList<Pret>();
	private static int compteurIdPret;

	public ArrayList<Pret> getLstPrets() {
		return lstPrets;
	}

	public void addLstPrets(Pret pret) {
		lstPrets.add(pret);
	}
	
	
	public ArchivePret() {
		compteurIdPret = 1;
		
		try {
			FileInputStream fichier = new FileInputStream("archive.ser");
			ObjectInputStream is = new ObjectInputStream(fichier);
	
			instance = (ArchivePret) is.readObject();
			System.out.println("désérialise archive prêt");

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
	
	public static ArchivePret getArchivePret() {
		if (instance==null) {
			instance=new ArchivePret();
		}
		return instance;
	}

	public static void serialiseArchivePret() {
		try {
			FileOutputStream fichier = new FileOutputStream("archive.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("archive prêt sérialisation");
			os.writeObject(instance);
			
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getCompteurIdPret() {
		return compteurIdPret;
	}

	public static void addCompteurIdPret() {
		compteurIdPret++;
	}
}
