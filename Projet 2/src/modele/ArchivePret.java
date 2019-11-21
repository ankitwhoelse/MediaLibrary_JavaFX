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

public class ArchivePret implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private	static ArchivePret instance;
	private ArrayList<Pret> lstPrets;
	private int compteurIdPret;

	public ArrayList<Pret> getLstPrets() {
		return lstPrets;
	}

	public void addLstPrets(Pret pret) {
		lstPrets.add(pret);
	}
	
	
	public ArchivePret() {
		compteurIdPret = 1;
		lstPrets = new ArrayList<Pret>();
		
		try {
			if (new File("archive.ser").exists()) {
				FileInputStream fichier = new FileInputStream("archive.ser");
				ObjectInputStream is = new ObjectInputStream(fichier);
		
				instance = (ArchivePret) is.readObject();
				lstPrets = instance.getLstPrets();
				System.out.println("désérialise archive prêt");
	
				is.close();
				fichier.close();
			}
		
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
	
	public static ArchivePret getInstance() {
		if (instance==null) {
			instance=new ArchivePret(); System.out.println("l'instance archive est nulle");
		}
		return instance;
	}

	public void serialiseArchivePret() {
		try {
			FileOutputStream fichier = new FileOutputStream("archive.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("archive prêt sérialisation");
			os.writeObject(instance);
			
			os.close();
			fichier.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getCompteurIdPret() {
		return compteurIdPret;
	}

	public void addCompteurIdPret() {
		compteurIdPret++;
	}
}
