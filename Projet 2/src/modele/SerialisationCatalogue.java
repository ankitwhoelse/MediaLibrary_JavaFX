package modele;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SerialisationCatalogue {

	public static void serialiseCata() {
	
		//Sérialisation du catalogue
		
		Catalogue cat = Catalogue.getCatalogue();
//		ArrayList<Document> lstDocument = cat.getLstDoc();
//		ArrayList<Periodique> lstPeriodique = cat.getLstPer();
//		ArrayList<Livre> lstLivre = cat.getLstLvr();
//		ArrayList<DVD> lstDVD = cat.getLstDvd();
//		
//		
//		lstDocument.addAll(lstPeriodique);
//		lstDocument.addAll(lstLivre);
//		lstDocument.addAll(lstDVD);
//		
		try {
			FileOutputStream fichier = new FileOutputStream("catalogue.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("nouvel sérialisation");
			os.writeObject(cat);
			
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
