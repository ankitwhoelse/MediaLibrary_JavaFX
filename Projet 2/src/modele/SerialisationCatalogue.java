package modele;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialisationCatalogue {

	public static void serialiseCata() {
		//SÚrialisation du catalogue
		
		Catalogue cat = Catalogue.getCatalogue();
		
		try {
			FileOutputStream fichier = new FileOutputStream("catalogue.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("Catalogue sÚrialisation");
			os.writeObject(cat);
			
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void serialiseUtil() {
		//SÚrialisation du catalogue
		
		Utilisateurs users = Utilisateurs.getUtilisateurs();
	
		try {
			FileOutputStream fichier = new FileOutputStream("users.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("Utilisateurs sÚrialisation");
			os.writeObject(users);
			
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
//	public static void main(String[] args) {
//		serialiseUtil();
//	}
}
