package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class DeserialisationCatalogue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
  // désérialiser le catalogue
		
		Livre book = new Livre("","",LocalDate.MIN,"","","");
		DVD dvd = new DVD("","",LocalDate.MIN,"",0,"");
		Periodique weekly = new Periodique("","",LocalDate.MIN,"",0,0);
		Document doc = new Document("", "", LocalDate.MIN, "");
		Catalogue cat;
		
		FileInputStream fichierL = new FileInputStream("catalogue.ser");
		ObjectInputStream isL = new ObjectInputStream(fichierL);
		
		try {
			while ((cat = (Catalogue) isL.readObject()) != null) {// erreur de fin de document 
				System.out.println(cat);
			System.out.println(cat.getLstDoc());
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
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		}
		 	
			
	}
}
