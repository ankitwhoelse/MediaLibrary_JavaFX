package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Adherant implements Serializable{

	private static final long serialVersionUID = 1L;
	private String strId;
	private String prenom;
	private String nom;
	private String adresse;
	private String numTelephone;// FORMAT: (000) 000-0000
	private ArrayList<Pret> lstPrets = new ArrayList<Pret>();

	public String getStrId() {
		return strId;
	}
	public String getNumTelephone() {
		return numTelephone;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public ArrayList<Pret> getPrets() {
		return lstPrets;
	}
	
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setPrets(ArrayList<Pret> prets) {
		lstPrets = prets;
	}
	public void setLstPrets(ArrayList<Pret> lstPrets) {
		this.lstPrets = lstPrets;
	}
	public ArrayList<Pret> getLstPrets() {
		return lstPrets;
	}
	
	public void addPret(Pret pret) {
		lstPrets.add(pret);
	}

	public Adherant(String strId, String prenom, String nom, String adresse, String numTelephone) {
		this.strId = strId;
		this.numTelephone = numTelephone;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public String toString() {
		return "ID: " + strId + " Prenom: " + prenom + " Nom: " + nom + " Adresse: " + adresse + " Numéro de téléphone: " + numTelephone;
	}
}
