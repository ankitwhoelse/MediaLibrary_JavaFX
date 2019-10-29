package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SerialisationCatalogue {

	public static void main(String[] args) {
		//Sérialisation du catalogue
		
		Catalogue cat = Catalogue.getCatalogue();
		ArrayList<Document> lstDocument = cat.getLstDoc();
		ArrayList<Periodique> lstPeriodique = cat.getLstPer();
		ArrayList<Livre> lstLivre = cat.getLstLvr();
		ArrayList<DVD> lstDVD = cat.getLstDvd();
		
		
		
		lstDocument.addAll(lstPeriodique);
		lstDocument.addAll(lstLivre);
		lstDocument.addAll(lstDVD);
		
		try {
			FileOutputStream fichier = new FileOutputStream("catalogue.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
				os.writeObject(cat);
			
			os.close();
			
//			FileOutputStream fichierD = new FileOutputStream("dvd.ser");
//			ObjectOutputStream osD = new ObjectOutputStream(fichierD);
//			
//			for (DVD e : lstDVD) 
//				osD.writeObject(e);
//			
//			osD.close();
//			
//			FileOutputStream fichierL = new FileOutputStream("livre.ser");
//			ObjectOutputStream osL = new ObjectOutputStream(fichierL);
//			
//			for (Livre e : lstLivre) 
//				osL.writeObject(e);
//			
//			osL.close();
//			
//			FileOutputStream fichierP = new FileOutputStream("periodique.ser");
//			ObjectOutputStream osP = new ObjectOutputStream(fichierP);
//			
//			for (Periodique e : lstPeriodique) 
//				osP.writeObject(e);
//			
//			osP.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
