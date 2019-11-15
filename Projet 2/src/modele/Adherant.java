package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Adherant {
	private String numTelephone;		// FORMAT: (000) 000-0000
	private String nom;
	private String prenom;
	private String adresse;
	private ObservableList<Pret> Prets = FXCollections.observableArrayList();
	private ListView<Pret> lstPrets = new ListView<>(Prets);

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

	public ListView<Pret> getLstPrets() {
		return lstPrets;
	}

	public Adherant(String numTelephone, String nom, String prenom, String adresse) {
		// TODO Auto-generated constructor stub
		this.numTelephone = numTelephone;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

}
