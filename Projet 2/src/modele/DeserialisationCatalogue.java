package modele;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;

import vue.Interface;

public class DeserialisationCatalogue extends Interface{

	 static Catalogue cat;
	
	public static void deserialiseCata() throws IOException {
		// TODO Auto-generated method stub
  // désérialiser le catalogue
		System.out.println("deserial no work");
//		Livre book = new Livre("","",LocalDate.MIN,"","","");
//		DVD dvd = new DVD("","",LocalDate.MIN,"",0,"");
//		Periodique weekly = new Periodique("","",LocalDate.MIN,"",0,0);
//		Document doc = new Document("", "", LocalDate.MIN, "");
		cat = Catalogue.getCatalogue();
		
		FileInputStream fichierL = new FileInputStream("catalogue.ser");
		ObjectInputStream isL = new ObjectInputStream(fichierL);
		
		try {
			while ((cat = (Catalogue) isL.readObject()) != null) {// erreur de fin de document 
				System.out.println(cat);
				System.out.println(cat.getLstDoc());
				System.out.println("désérialise");
			}
			isL.close();
		
			
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
			e.printStackTrace();
		}
	}
	
	public static Catalogue getDeseriaCata() {
		return cat;
	}
	
	
}
