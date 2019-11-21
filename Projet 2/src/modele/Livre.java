package modele;



import java.io.Serializable;
import java.time.LocalDate;


public class Livre  extends Document {
	
	private static final long serialVersionUID = 1L;
	private String auteur;
	private String motsCles;
	
	public Livre(String noDoc, String titre, LocalDate dateParution, boolean disponible, String motsCles, 
				 String auteur) {
		
		super(noDoc, titre, dateParution, disponible);
		this.motsCles = motsCles;
		this.auteur =auteur;
	}

	public String getMotsCles() {
		return motsCles;
	}

	public void setMotsCles(String motsCles) {
		this.motsCles = motsCles;
	}

	@Override
	public String toString() {
		return "Livre [" +  super.toString()+ "auteur="  +auteur + "]";
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
