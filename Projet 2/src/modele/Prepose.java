package modele;

public class Prepose extends Comptes {

	private String id;
	private String MotDePasse;
	
	public Prepose(String id, String MotDePasse) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setMotDePasse(MotDePasse);
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
