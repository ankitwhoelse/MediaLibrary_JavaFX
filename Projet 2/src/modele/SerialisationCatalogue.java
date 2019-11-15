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

}
