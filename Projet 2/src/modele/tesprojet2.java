package modele;

public class tesprojet2 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Adherants.getInstance();
		System.out.println(Adherants.getInstance().getLstAdherants());
		Adherants.getInstance().getLstAdherants().add(new Adherant("11", "1", "1", "1", "1"));
		Adherants.getInstance().getLstAdherants().add(new Adherant("12", "1", "1", "1", "1"));
		System.out.println(Adherants.getInstance().getLstAdherants());
	 	Adherants.getInstance().serialiseAdherants();
		System.out.println(Adherants.getInstance().getLstAdherants());
	}

}
