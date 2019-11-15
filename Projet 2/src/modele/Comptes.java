package modele;

import java.io.Serializable;
import java.util.ArrayList;

public class Comptes implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Comptes> lstComptes = new ArrayList<>();
	
	
	public ArrayList<Comptes> getLstComptes() {
		return lstComptes;
	}
	
}
