package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Catalogue implements Serializable {

  //  Complétez  pour programmer la classe comme singleton 
  //  Le constructeur permet de remplir les listes suivantes à partir 
  //	des fichiers textes Livres.txt et periodiques.txt et DVD.txt
	
	private static final long serialVersionUID = 1L;
	private static Catalogue instance;
	private ArrayList<Document> lstDocuments;
	private ArrayList<Livre> lstLivres;
	private ArrayList<Periodique> lstPeriodiques;
	private ArrayList<DVD> lstDvd;
	private int compteurIdLivre;
	private int compteurIdDVD;
	private int compteurIdPer;
	
	
	public int getCompteurIdLivre() {
		return compteurIdLivre;
	}

	public void setCompteurIdLivre(int compteurIdLivre) {
		this.compteurIdLivre = compteurIdLivre;
	}

	public int getCompteurIdDVD() {
		return compteurIdDVD;
	}

	public void setCompteurIdDVD(int compteurIdDVD) {
		this.compteurIdDVD = compteurIdDVD;
	}

	public int getCompteurIdPer() {
		return compteurIdPer;
	}

	public void setCompteurIdPer(int compteurIdPer) {
		this.compteurIdPer = compteurIdPer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addLstDocuments(Document doc) {
		lstDocuments.add(doc);
		
	}

	public void addLstLivres(Livre livre) {
		lstLivres.add(livre);
		compteurIdLivre++;
	}

	public void addLstPeriodiques(Periodique per) {
		lstPeriodiques.add(per);
		compteurIdPer++;
	}
	
	public void addLstDvd(DVD dvd) {
		lstDvd.add(dvd);
		compteurIdDVD++;
	}

	public Catalogue() {
		lstDocuments = new ArrayList<>();
		lstLivres = new ArrayList<>();
		lstPeriodiques = new ArrayList<>();
		lstDvd = new ArrayList<>();
		compteurIdLivre = lstLivres.size() + 1;
		compteurIdDVD = lstDvd.size() + 1;
		compteurIdPer = lstPeriodiques.size() + 1;
		
		BufferedReader br = null;
		StringTokenizer st;
		Livre book;
		DVD disk;
		Periodique weekly;
		String strLigne;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

		try {
			if (new File("catalogue.ser").exists()) {
				instance = DeserialisationCatalogue.getDeseriaCata();
				lstDocuments = instance.getLstDoc();
				lstLivres = instance.getLstLvr();
				lstPeriodiques = instance.getLstPer();
				lstDvd = instance.getLstDvd();
			} else {
//				LECTURE DU FICHIER LIVRES
				br = new BufferedReader(new FileReader("Livres.txt"));
				while ((strLigne = br.readLine()) != null) {
					st = new StringTokenizer(strLigne, ",");
					String noDoc = st.nextToken().trim();
					String titre = st.nextToken().trim();
					LocalDate dateParution = LocalDate.parse(st.nextToken().trim(), formatter);
					boolean disponible = true;
					String motsCles = null; 
					String auteur = st.nextToken().trim();
					
					book = new Livre(noDoc, titre, dateParution, disponible, motsCles, auteur);
					lstLivres.add(book);
				} 
				br.close();
//				LECTURE DU FICHIER DVD
				br = new BufferedReader(new FileReader("DVD.txt"));
				while ((strLigne = br.readLine()) != null) {
					st = new StringTokenizer(strLigne, ",");
					String noDoc = st.nextToken().trim();
					String titre = st.nextToken().trim();
					LocalDate dateParution = LocalDate.parse(st.nextToken().trim(), formatter);
					boolean disponible = true;
					int nbDisques = Integer.parseInt(st.nextToken().trim()); 
					String strRealisateur = st.nextToken().trim();
					String motsCles = null;
					
					disk = new DVD(noDoc, titre, dateParution, disponible, nbDisques, strRealisateur, motsCles);
					lstDvd.add(disk);
				} 
				br.close();
//				LECTURE DU FICHIER PERIODIQUE
				br = new BufferedReader(new FileReader("Periodiques.txt"));
				while ((strLigne = br.readLine()) != null) {
					st = new StringTokenizer(strLigne, ",");
					String noDoc = st.nextToken().trim();
					String titre = st.nextToken().trim();
					LocalDate dateParution = LocalDate.parse(st.nextToken().trim(), formatter);
					boolean disponible = true;
					int noVolume = Integer.parseInt(st.nextToken().trim());
					int noPeriodique = Integer.parseInt(st.nextToken().trim());
					String motsCles = null;
					
					weekly = new Periodique(noDoc, titre, dateParution, disponible, noVolume, noPeriodique, motsCles);
					lstPeriodiques.add(weekly);
				} 
				br.close();
				
				lstDocuments.addAll(lstDvd);
				lstDocuments.addAll(lstLivres);
				lstDocuments.addAll(lstPeriodiques);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Ce fichier n'existe pas.");
		} catch (IOException e) {
			System.out.println("IOException");
		}
				
		System.out.println("objet unique catalogue créé");
	}
	
	public static Catalogue getInstance() {
		if (instance == null) {
			instance = new Catalogue(); System.out.println("instance catalogue == null");}
		return instance;
	}
	
	public ArrayList<Document> getLstDoc() {
		return lstDocuments;
	}
	
	public ArrayList<Periodique> getLstPer() {
		return lstPeriodiques;
	}
	
	public ArrayList<Livre> getLstLvr() {
		return lstLivres;
	}
	
	public ArrayList<DVD> getLstDvd() {
		return lstDvd;
	}
	
}
