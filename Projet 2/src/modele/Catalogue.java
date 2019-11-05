package modele;

import java.io.BufferedReader;
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
	private ArrayList<Document> lstDocuments = new ArrayList<>();
	private ArrayList<Livre> lstLivres = new ArrayList<>();
	private ArrayList<Periodique> lstPeriodiques = new ArrayList<>();
	private ArrayList<DVD> lstDvd = new ArrayList<>();

	private Catalogue() {
		BufferedReader br = null;
		StringTokenizer st;
		Livre book;
		DVD disk;
		Periodique weekly;
		String strLigne;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		
		try {
			System.out.println();
			br = new BufferedReader(new FileReader("Livres.txt"));
			while ((strLigne = br.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				String noDoc = st.nextToken().trim();
				String titre = st.nextToken().trim();
				LocalDate dateParution = LocalDate.parse(st.nextToken().trim(), formatter);
				String disponible = null;
				String motsCles = null; 
				String auteur = st.nextToken().trim();
				
				book = new Livre(noDoc, titre, dateParution, disponible, motsCles, auteur);
//				System.out.println(book.toString());
				lstLivres.add(book);
			} 
			br.close();
			
			System.out.println();
			br = new BufferedReader(new FileReader("DVD.txt"));
			while ((strLigne = br.readLine()) != null) {
				
				st = new StringTokenizer(strLigne, ",");
				String noDoc = st.nextToken().trim();
				String titre = st.nextToken().trim();
				LocalDate dateParution = LocalDate.parse(st.nextToken().trim(), formatter);
				String disponible = null;
				int nbDisques = Integer.parseInt(st.nextToken().trim()); 
				String strRealisateur = st.nextToken().trim();
				
				disk = new DVD(noDoc, titre, dateParution, disponible, nbDisques, strRealisateur);
//				System.out.println(disk.toString());
				lstDvd.add(disk);
			} 
			br.close();
			
			System.out.println();
			br = new BufferedReader(new FileReader("Periodiques.txt"));
			while ((strLigne = br.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				String noDoc = st.nextToken().trim();
				String titre = st.nextToken().trim();
				LocalDate dateParution = LocalDate.parse(st.nextToken().trim(), formatter);
				String disponible = null;
				int noVolume = Integer.parseInt(st.nextToken().trim());
				int noPeriodique = Integer.parseInt(st.nextToken().trim());
				
				weekly = new Periodique(noDoc, titre, dateParution, disponible, noVolume, noPeriodique);
//				System.out.println(weekly.toString());
				lstPeriodiques.add(weekly);
			} 
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ce fichier n'existe pas.");
		} catch (IOException e) {}
				
		System.out.println("objet unique catalogue créé");
	}
	
	public static Catalogue getCatalogue() {
		if (instance == null)
			instance = new Catalogue();
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
