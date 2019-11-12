package modele;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.time.LocalDate;
//
//import vue.Interface;

public class DeserialisationCatalogue{

	static Catalogue cat;
	
	public static void deserialiseCata() throws IOException {
		// désérialiser le catalogue
		
//		Livre book = new Livre("","",LocalDate.MIN,"","","");
//		DVD dvd = new DVD("","",LocalDate.MIN,"",0,"");
//		Periodique weekly = new Periodique("","",LocalDate.MIN,"",0,0);
//		Document doc = new Document("", "", LocalDate.MIN, "");
		
		FileInputStream fichier = new FileInputStream("catalogue.ser");
		ObjectInputStream is = new ObjectInputStream(fichier);
		
		try {
			cat = (Catalogue) is.readObject();
			System.out.println("désérialise");
		
			is.close();
		
			
//			FileInputStream fichierD = new FileInputStream("dvd.ser");
//			ObjectInputStream isD = new ObjectInputStream(fichierD);
//			
//			while ((dvd = (DVD) isD.readObject()) != null) 
//				System.out.println(dvd);
//			isD.close();
//			
//			FileInputStream fichierP = new FileInputStream("periodique.ser");
//			ObjectInputStream isP = new ObjectInputStream(fichierP);
//			
//			while ((weekly = (Periodique) isP.readObject()) != null) 
//				System.out.println(weekly);
//			isP.close();
			
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
	
	
}
