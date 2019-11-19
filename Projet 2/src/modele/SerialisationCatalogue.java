package modele;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialisationCatalogue {

	public static void serialiseCata() {
		//Sérialisation du catalogue
		
		Catalogue cat = Catalogue.getInstance();
		
		try {
			FileOutputStream fichier = new FileOutputStream("catalogue.ser");
			ObjectOutputStream os = new ObjectOutputStream(fichier);
			
			System.out.println("Catalogue sérialisation");
			os.writeObject(cat);
			
			os.close();
			fichier.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
