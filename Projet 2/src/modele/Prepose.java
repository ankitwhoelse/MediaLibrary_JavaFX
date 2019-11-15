package modele;

import java.io.Serializable;

public class Prepose extends Preposes implements Serializable{

	private static final long serialVersionUID = 1L;
	private String strId;
	private String MotDePasse;
	
	public Prepose(String strId, String MotDePasse) {
		this.strId = strId;
		this.MotDePasse = MotDePasse;
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public String getId() {
		return strId;
	}


}
