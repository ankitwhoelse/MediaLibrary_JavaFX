package application;

public class Administrateur extends Comptes {

	private String MotDePasse;
	
	public Administrateur(String id, String MotDePasse) {
		super(id);
		// TODO Auto-generated constructor stub
		this.MotDePasse = MotDePasse;
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

}
