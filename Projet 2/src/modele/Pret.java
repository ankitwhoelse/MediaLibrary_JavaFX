package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Pret {

	private String idPret;
	private LocalDate dateEmprunt; 
	private String idAdherant;
	private String noDoc;
	private LocalDate dateRetour; // même format que dateEmprunt
	private double amende = 0;
	
	private ArrayList<Pret> lstPrets = new ArrayList<Pret>();
	
	public Pret(LocalDate date, String idAdherant, String noDoc, String idPret) {
		// TODO Auto-generated constructor stub
		this.dateEmprunt = date;
		this.idAdherant = idAdherant;
		this.noDoc = noDoc;
		this.idPret = idPret;
		
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate localDate) {
		this.dateRetour = localDate;
	}

	public double getAmende() {
		return amende;
	}

	public void setAmende(double amende) {
		this.amende = amende;
	}

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public String getIdAdherant() {
		return idAdherant;
	}

	public String getNoDoc() {
		return noDoc;
	}

	public ArrayList<Pret> getLstPrets() {
		return lstPrets;
	}

	public String getIdPret() {
		return idPret;
	}

	public void setIdPret(String idPret) {
		this.idPret = idPret;
	}
}
