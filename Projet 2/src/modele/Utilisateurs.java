package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Utilisateurs implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Utilisateurs instance;
	private ArrayList<Adherant> lstAdherant = new ArrayList<>(); 
	private ArrayList<Prepose> lstPrepose = new ArrayList<>();
	private ArrayList<Comptes> lstComptes = new ArrayList<>();
	
	public Utilisateurs() {
//		lstAdherant.add(new Adherant("testTel", "testNom", "testPrenom", "testAdr"));
//		lstPrepose.add(new Prepose("testID", "testMdP"));
		lstComptes.addAll(lstAdherant);
		lstComptes.addAll(lstPrepose);
	}
	
	public static Utilisateurs getUtilisateurs() {
		if (instance==null)
			instance = new Utilisateurs();
		return instance;
	}

	public ArrayList<Adherant> getLstAdherant() {
		return lstAdherant;
	}

	public ArrayList<Prepose> getLstPrepose() {
		return lstPrepose;
	}

	public ArrayList<Comptes> getLstComptes() {
		return lstComptes;
	}
	
}
