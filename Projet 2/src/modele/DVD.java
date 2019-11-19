package modele;


import java.time.LocalDate;


public class DVD extends Document{
	
	private static final long serialVersionUID = 1L;
	private int  nbDisques;
	private String strRealisateur;
	public DVD(String noDoc, String titre, LocalDate dateParution, boolean disponible, 
			   int nbDisques, String strRealisateur) {
		
		super(noDoc, titre, dateParution, disponible);
		this.nbDisques = nbDisques;
		this.strRealisateur = strRealisateur;
	}
	
	public String toString() {
		return " DVD :" + super.toString()+ "nbDisques: " +this.nbDisques+ " Réalisateur: "+ this.strRealisateur; 
	}

	public int getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(int nbDisques) {
		this.nbDisques = nbDisques;
	}

	public String getStrRealisateur() {
		return strRealisateur;
	}

	public void setStrRealisateur(String strRealisateur) {
		this.strRealisateur = strRealisateur;
	}
}
