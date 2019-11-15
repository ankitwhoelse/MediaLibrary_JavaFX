package modele;

import java.util.ArrayList;

public class Comptes {

//	private String id;

	private ArrayList<Adherant> lstAdherant = new ArrayList<>(); 
	private ArrayList<Prepose> lstPrepose = new ArrayList<>();
	private ArrayList<Comptes> lstComptes = new ArrayList<>();
	
//	public Comptes(String id) {
//		// TODO Auto-generated constructor stub
//		this.setId(id);
//	}
	
	public Comptes() {
//		test
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public ArrayList<Adherant> getLstAdherant() {
		return lstAdherant;
	}
	
	public ArrayList<Prepose> getLstPrepose() {
		return lstPrepose;
	}
	
	public ArrayList<Comptes> getLstComptes() {
		return lstComptes;
	}

	public void addLstAdherant(Adherant adher) {
		lstAdherant.add(adher);
	}

	public void addLstPrepose(Prepose prep) {
		lstPrepose.add(prep);
	}

	public void setLstComptes(ArrayList<Comptes> lstComptes) {
		this.lstComptes = lstComptes;
	}
	
}
