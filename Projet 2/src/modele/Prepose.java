package modele;

public class Prepose extends Comptes {

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
	}

}
