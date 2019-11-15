package modele;

public class Prepose extends Comptes {

	private String MotDePasse;
	
	public Prepose(String id, String MotDePasse) {
		super(id);
		// TODO Auto-generated constructor stub
		this.setMotDePasse(MotDePasse);
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}

}
