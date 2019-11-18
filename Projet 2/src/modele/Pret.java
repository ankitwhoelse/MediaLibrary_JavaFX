package modele;

import java.util.ArrayList;
import java.util.Date;

public class Pret {

	private Date dateEmprunt; 
	private String idAdherant;
	private String noDoc;
	private String dateRetour = ""; // même format que dateEmprunt
	private double amende = 0;
	
	private static ArrayList<Pret> lstPrets = new ArrayList<Pret>();
	
	public Pret(Date dateEmprunt, String idAdherant, String noDoc) {
		// TODO Auto-generated constructor stub
		this.dateEmprunt = dateEmprunt;
		this.idAdherant = idAdherant;
		this.noDoc = noDoc;
	}
	
	public Pret() {
		
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

	public Date getDateEmprunt() {
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
