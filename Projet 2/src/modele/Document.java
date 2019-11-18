package modele;

import java.io.Serializable;
import java.time.LocalDate;

public class Document implements Serializable{

	private static final long serialVersionUID = 1L;
	private String  noDoc;
	private String  titre;
	private LocalDate  dateParution;
	private boolean  disponible;
	
	public Document(String noDoc, String titre, LocalDate dateParution, boolean disponible) {
		super();
		this.noDoc = noDoc;
		this.titre = titre;
		this.dateParution = dateParution;
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "noDoc=" + noDoc + ", titre=" + titre + ", dateParution=" + dateParution + ", disponible="
				+ disponible ;
	}

	public String getNoDoc() {
		return noDoc;
	}

	public void setNoDoc(String noDoc) {
		this.noDoc = noDoc;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public LocalDate getDateParution() {
		return dateParution;
	}

	public void setDateParution(LocalDate dateParution) {
		this.dateParution = dateParution;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
}