package modele;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Adherant extends Adherants implements Serializable{

	private static final long serialVersionUID = 1L;
	private String strId;
	private String numTelephone;// FORMAT: (000) 000-0000
	private String nom;
	private String prenom;
	private String adresse;
	private ObservableList<Pret> Prets = FXCollections.observableArrayList();
//	private ListView<Pret> lstPrets = new ListView<>(Prets);
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

	public ObservableList<Pret> getPrets() {
		return Prets;
	}

//	public ListView<Pret> getLstPrets() {
//		return lstPrets;
//	}
	
	public ArrayList<Pret> getLstPrets() {
		return lstPrets;
	}
	
	public void addPret(Pret pret) {
		lstPrets.add(pret);
	}

	public Adherant(String strId, String numTelephone, String nom, String prenom, String adresse) {
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
