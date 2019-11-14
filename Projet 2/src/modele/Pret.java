package modele;

import java.util.ArrayList;

public class Pret {

	private String dateEmprunt; // jj/mm/aaaa
	private String idAdherant;
	private String noDoc;
	private String dateRetour = ""; // même format que dateEmprunt
	private double amende = 0;
	
	private static ArrayList<Pret> lstPrets = new ArrayList<Pret>();
	
	public Pret(String dateEmprunt, String idAdherant, String noDoc) {
		// TODO Auto-generated constructor stub
		this.dateEmprunt = dateEmprunt;
		this.idAdherant = idAdherant;
		this.noDoc = noDoc;
	}

	public String getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getAmende() {
		return amende;
	}

	public void setAmende(double amende) {
		this.amende = amende;
	}

	public String getDateEmprunt() {
		return dateEmprunt;
	}

	public String getIdAdherant() {
		return idAdherant;
	}

	public String getNoDoc() {
		return noDoc;
	}

	public static ArrayList<Pret> getLstPrets() {
		return lstPrets;
	}
}
