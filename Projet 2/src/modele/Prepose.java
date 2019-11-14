package modele;

public class Prepose extends Comptes {

<<<<<<< HEAD
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
=======
	private String strMdP;
	
	public String getStrMdP() {
		return strMdP;
	}

	public void setStrMdP(String strMdP) {
		this.strMdP = strMdP;
	}

	public Prepose(String id, String strMdP) {
		super(id);
		this.strMdP = strMdP;
>>>>>>> 8b12f11e8fc22c86d4d542b3add26a4392994003
	}

}
