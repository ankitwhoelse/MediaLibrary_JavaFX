package modele;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserialisationCatalogue{

	static Catalogue cat;
	static Utilisateurs users;
	
	public static void deserialiseCata() throws IOException {
		// désérialiser le catalogue
		
		FileInputStream fichier = new FileInputStream("catalogue.ser");
		ObjectInputStream is = new ObjectInputStream(fichier);
		
		try {
			cat = (Catalogue) is.readObject();
			System.out.println("désérialise catalogue");
		
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("erreur de fin du fichier");
			e.printStackTrace();
		}
	}
	
	public static Catalogue getDeseriaCata() throws IOException {
		deserialiseCata();
		return cat;
	}

	
	public static void deserialiseUsers() throws IOException {
		// désérialiser les utilisateurs
		
		FileInputStream fichier = new FileInputStream("users.ser");
		ObjectInputStream is = new ObjectInputStream(fichier);
		
		try {
			users = (Utilisateurs) is.readObject();
			System.out.println("désérialise users");
		
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("erreur de fin du fichier");
			e.printStackTrace();
		}
	}
	
	public static Utilisateurs getDeseriaUsers() throws IOException {
		deserialiseUsers();
		return users;
	}
	
}