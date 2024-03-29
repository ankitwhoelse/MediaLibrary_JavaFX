package vue;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import modele.Adherant;
import modele.Adherants;
import modele.ArchivePret;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Catalogue;
import modele.DVD;
import modele.DeserialisationCatalogue;
import modele.Document;
import modele.Livre;
import modele.Periodique;
import modele.Prepose;
import modele.Preposes;
import modele.Pret;
import modele.SerialisationCatalogue;

public class Interface extends Application{

	BorderPane root, root2;
	Button btnConn, btnBiblio, btnCons, btnAjoutUtil, btnAjoutCata, btnConfirmU, btnModifConfirmPrep, btnAjoutPrep, btnEmprunter, btnRetourner, btnPayer, btnSupprPrep, btnSupprUtil, btnCataConfir, btnSupprCata;
	TextField txtPrenom, txtNom, txtTel, txtRecherche, tbModifU, tbID, tbModifPrep, tbIDPrep, tbMDP;
	Text txt1, txt2, txt3, txt4, txtA, txtT, txtN, txtP, txtMDP, txtUtil, txtIdAdher, txtAdresseAdher, txtNumAdher;
	TextField tbAjTitr, tbAjDate, tbAjMC, tbAj2, tbAj3, tbAj4, tbN, tbP, tbA, tbT, tbEmprID, tbEmprDocID;
	Text txtAjTitr, txtAjDate, txtAjMC, txtAj2, txtAj3, txtAj4;
	CheckBox cbConn;
	RadioButton rbAjoutL, rbAjoutD, rbAjoutP, rbModifAdr, rbModifTel, rbAjoutAdh, rbAjoutPre, rbModifID, rbModifMDP;
	Scene scene, scene2, scene3, scene4, scene5;
	Stage stage2, stage3, stage4, stage5;
	TabPane tabPane;
	Tab tabDoc, tabLivre, tabDvd, tabPerio, tabUtil, tabPrepo, tabAdher, tabPrets, tabPrep;
	Adherant connectedAdher;
	ObservableList<Pret> donneesPrets;
	final TableView<Pret> tablePrets = new TableView<Pret>();
	final TableView<Prepose> tabPrepose = new TableView<Prepose>();
	ObservableList<Prepose> donneesPrep;
	final TableView<Adherant> tableUtilisateurs = new TableView<Adherant>();
	ObservableList<Adherant> donneesAdh;
	final TableView<Document> tableDoc = new TableView<Document>();
	ObservableList<Document> donneesDoc;
	final TableView<DVD> tableDvd = new TableView<DVD>();
	ObservableList<DVD> donneesDvd;
	final TableView<Periodique> tablePerio = new TableView<Periodique>();
	ObservableList<Periodique> donneesPerio;
	final TableView<Livre> tableLivre = new TableView<Livre>();
	ObservableList<Livre> donneesLivres;
	final TableView<Document> tableCatalogue = new TableView<Document>();
	TableView<Pret> tablePretAdher = new TableView<Pret>();
	ObservableList<Pret> donneesPretAdher;
	
	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) {
		try {
			
//			
//					< INTERFACE DE CONNECTION >
			root = new BorderPane();
			GestionClick gc = new GestionClick();
			
			VBox vBox = new VBox();
			vBox.setPadding(new Insets(10));
			VBox.setMargin(vBox, new Insets(10));
			vBox.setSpacing(10);
			
			GridPane gPane = new GridPane();
			GridPane.setHalignment(gPane, HPos.LEFT);
			GridPane.setValignment(gPane, VPos.CENTER);
			gPane.setHgap(5);
			gPane.setVgap(5);
			
			txt1 = new Text("Identifiez vous");
			gPane.add(txt1, 0, 0);
			txt1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
			
			txt2 = new Text("Votre nom:");
			gPane.add(txt2, 0, 1);
			txtNom = new TextField("");
			txtNom.setPrefWidth(100);
			txtNom.setMinWidth(100);
			gPane.add(txtNom, 1, 1);
			
			txt3 = new Text("Votre pr�nom:");
			gPane.add(txt3, 0, 2);
			txtPrenom = new TextField("");
			txtPrenom.setPrefWidth(100);
			txtPrenom.setMinWidth(100);
			gPane.add(txtPrenom, 1, 2);
			
			txt4 = new Text("Votre num�ro de t�l�phone:");
			gPane.add(txt4, 0, 3);
			txtTel = new TextField("");
			txtTel.setPrefWidth(100);
			txtTel.setMinWidth(100);
			gPane.add(txtTel, 1, 3);
			
			
			btnCons = new Button();
			btnCons.setText("Connexion");
			btnCons.setOnAction(gc);
			btnCons.setPrefWidth(255);
			btnCons.setMinWidth(255);
			btnCons.setPrefHeight(33);
			btnCons.setMaxHeight(33);
			
			btnBiblio = new Button();
			btnBiblio.setText("Consulter la m�diath�que");
			btnBiblio.setOnAction(gc);
			btnBiblio.setPrefHeight(255);
			btnBiblio.setMinWidth(255);
			btnBiblio.setPrefHeight(33);
			btnBiblio.setMaxHeight(33);

			cbConn = new CheckBox();
			cbConn.setText("Pr�pos�/Admin");
			cbConn.setOnAction(gc);
			
			
			vBox.getChildren().addAll(gPane, btnCons, btnBiblio, cbConn);
			vBox.setAlignment(Pos.CENTER);
			root.setCenter(vBox);
			BorderPane.setAlignment(root, Pos.BOTTOM_CENTER);
			
			scene = new Scene(root,270,250);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Acceuil");
			primaryStage.setScene(scene);
			primaryStage.show();
//					< / INTERFACE DE CONNECTION >
//				
			
			
//			
//					< INTERFACE DE CATALOGUE >		
			root2 = new BorderPane();
			BorderPane.setMargin(root2, new Insets(10));
			scene2 = new Scene(root2, 825, 400);
			stage2 = new Stage();
			stage2.setScene(scene2);
			stage2.setTitle("Mediatheque");
			stage2.initModality(Modality.APPLICATION_MODAL);
						
			tabPane = new TabPane();
			VBox vBox2 = new VBox();
			vBox2.setSpacing(10);
			VBox.setMargin(vBox2, new Insets(10));
			
			HBox hBoxSearch = new HBox();
			hBoxSearch.setAlignment(Pos.CENTER_LEFT);
			hBoxSearch.setSpacing(10);
			HBox.setMargin(hBoxSearch, new Insets(5));
			Text txtSearch = new Text("Recherche dans le catalogue: ");
			VBox.setMargin(hBoxSearch, new Insets(5));
			
			txtRecherche = new TextField();
			txtRecherche.setPrefWidth(200);
			txtRecherche.setMinWidth(200);
			
			hBoxSearch.getChildren().addAll(txtSearch, txtRecherche);
			
			HBox hBoxCata = new HBox();
			hBoxCata.setSpacing(15);
			
			Catalogue cata = Catalogue.getInstance();
			Adherants adh = Adherants.getInstance();
			Preposes preps = Preposes.getInstance();
			ArchivePret archive = ArchivePret.getInstance();
			
//				onglet documents
			tabDoc = new Tab();
			tabDoc.setClosable(false);
			tabDoc.setText("Documents");
//			tabDoc.setGraphic(new ImageView(new Image("images\\icon-collection.png")));
			
//					RECHERCHE TITRE / MOTS CLES
				donneesDoc = FXCollections.observableArrayList(Catalogue.getInstance().getLstDoc());
				FilteredList<Document> filteredDoc = new FilteredList<Document>(donneesDoc, doc -> true);
				
				txtRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredDoc.setPredicate(doc -> {
							//si rien est taper dans le textfield, laisse tout passer
						if (newValue==null || newValue.isEmpty())
							return true;
							//quand il y a du text dans le textfield
						else if (doc.getTitre().toLowerCase().contains(newValue.toLowerCase()))
							return true;
//				 		else if (doc.getMotsCles().toLowerCase().contains(newValue.toLowerCase()))
//							return true; // match un des mots cl�s
						else
							return false; // match rien
					});
				});
				
				SortedList<Document> sortedDoc = new SortedList<Document>(filteredDoc);
				sortedDoc.comparatorProperty().bind(tableDoc.comparatorProperty());
			
			TableColumn<Document, String> colonneNum1 = new TableColumn<Document, String> ("Num�ro");
			TableColumn<Document, String> colonneTitre1 = new TableColumn<Document, String> ("Titre");
			TableColumn<Document, LocalDate> colonneParution1 = new TableColumn<Document, LocalDate> ("Date de parution");
			TableColumn<Document, String> colonneDispo1 = new TableColumn<Document, String> ("Disponible");
			tableDoc.getColumns().addAll(colonneNum1, colonneTitre1, colonneParution1, colonneDispo1);
			
			colonneNum1.setPrefWidth(60);				colonneNum1.setMaxWidth(60);
			colonneTitre1.setPrefWidth(560);			colonneTitre1.setMaxWidth(560);
			colonneParution1.setPrefWidth(120);			colonneParution1.setMaxWidth(120);
			colonneDispo1.setPrefWidth(80);				colonneDispo1.setMaxWidth(80);

			colonneNum1.setCellValueFactory(new PropertyValueFactory<Document, String>("noDoc"));
			colonneTitre1.setCellValueFactory(new PropertyValueFactory<Document, String>("titre"));
			colonneParution1.setCellValueFactory(new PropertyValueFactory<Document, LocalDate>("dateParution"));
			colonneDispo1.setCellValueFactory(new PropertyValueFactory<Document, String>("disponible"));			
			tableDoc.setItems(sortedDoc);
			tabDoc.setContent(tableDoc);
			
			
	//			onglet dvd
			tabDvd = new Tab();
			tabDvd.setClosable(false);
			tabDvd.setText("DVD");
//			tabDvd.setGraphic(new ImageView(new Image("images/icon-dvd.png")));
			
			
			TableColumn<DVD, String> colonneNum2 = new TableColumn<DVD, String> ("Num�ro");
			TableColumn<DVD, String> colonneTitre2 = new TableColumn<DVD, String> ("Titre");
			TableColumn<DVD, LocalDate> colonneParution2 = new TableColumn<DVD, LocalDate> ("Date de parution");
			TableColumn<DVD, String> colonneDispo2 = new TableColumn<DVD, String> ("Disponible");
			TableColumn<DVD, Integer> colonneDisk = new TableColumn<DVD, Integer> ("Nombre de disques");
			TableColumn<DVD, String> colonneRealis = new TableColumn<DVD, String> ("R�alisateur");
			tableDvd.getColumns().addAll(colonneNum2, colonneTitre2, colonneParution2, colonneDispo2, colonneDisk, colonneRealis);
			
			
		//			RECHERCHE TITRE / R�ALISATEUR / MOTS CLES
				donneesDvd = FXCollections.observableArrayList(Catalogue.getInstance().getLstDvd());
				FilteredList<DVD> filteredDvd = new FilteredList<DVD>(donneesDvd, disk -> true);
				
				txtRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredDvd.setPredicate(disk -> {
							//si rien est taper dans le textfield, laisse tout passer
						if (newValue==null || newValue.isEmpty())
							return true;
							//quand il y a du text dans le textfield
						else if (disk.getTitre().toLowerCase().contains(newValue.toLowerCase()))
							return true;
						else if (disk.getStrRealisateur().toLowerCase().contains(newValue.toLowerCase()))
							return true;
		//		 		else if (disk.getMotsCles().toLowerCase().contains(newValue.toLowerCase()))
		//					return true; // match un des mots cl�s
						else
							return false; // match rien
					});
				});
				
				SortedList<DVD> sortedDvd = new SortedList<DVD>(filteredDvd);
				sortedDvd.comparatorProperty().bind(tableDvd.comparatorProperty());
					
			colonneNum2.setPrefWidth(60);				colonneNum2.setMaxWidth(60);
			colonneTitre2.setPrefWidth(310);			colonneTitre2.setMaxWidth(310);
			colonneParution2.setPrefWidth(120);			colonneParution2.setMaxWidth(120);
			colonneDispo2.setPrefWidth(80);				colonneDispo2.setMaxWidth(80);
			colonneDisk.setPrefWidth(120);				colonneDisk.setMaxWidth(120);
			colonneRealis.setPrefWidth(130);			colonneRealis.setMaxWidth(130);
			
			colonneNum2.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
			colonneTitre2.setCellValueFactory(new PropertyValueFactory<>("titre"));
			colonneParution2.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			colonneDispo2.setCellValueFactory(new PropertyValueFactory<>("disponible"));
			colonneDisk.setCellValueFactory(new PropertyValueFactory<>("nbDisques"));
			colonneRealis.setCellValueFactory(new PropertyValueFactory<>("strRealisateur"));
			tableDvd.setItems(sortedDvd);
			tabDvd.setContent(tableDvd);
			
						
//										ONGLET LIVRE
			tabLivre = new Tab();
			tabLivre.setClosable(false);
			tabLivre.setText("Livre");
//			tabLivre.setGraphic(new ImageView(new Image("images/icon-livre.png")));
			
//					RECHERCHE TITRE / AUTEUR / MOTS CLES
				donneesLivres = FXCollections.observableArrayList(Catalogue.getInstance().getLstLvr());
				FilteredList<Livre> filteredLiv = new FilteredList<Livre>(donneesLivres, book -> true);
				
				txtRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredLiv.setPredicate(book -> {
						//si rien est taper dans le textfield, laisse tout passer
						if (newValue==null || newValue.isEmpty()) 
							return true;
							//quand il y a du text dans le textfield
						else if (book.getTitre().toLowerCase().contains(newValue.toLowerCase()))
							return true;
						else if (book.getAuteur().toLowerCase().contains(newValue.toLowerCase())) 
							return true; // match auteur
//						else if (book.getMotsCles().toLowerCase().contains(newValue.toLowerCase()))
//							return true; // match un des mots cl�s
						else
							return false; // match rien
					});
				});
				
				SortedList<Livre> sortedLivre = new SortedList<Livre>(filteredLiv);
				sortedLivre.comparatorProperty().bind(tableLivre.comparatorProperty());
				
			TableColumn<Livre, String> colonneNum3 = new TableColumn<Livre, String> ("Num�ro");
			TableColumn<Livre, String> colonneTitre3 = new TableColumn<Livre, String> ("Titre");
			TableColumn<Livre, LocalDate> colonneParution3 = new TableColumn<Livre, LocalDate> ("Date de parution");
			TableColumn<Livre, String> colonneDispo3 = new TableColumn<Livre, String> ("Disponible");
			TableColumn<Livre, String> colonneAuteur = new TableColumn<Livre, String> ("Auteur");
			tableLivre.getColumns().addAll(colonneNum3, colonneTitre3, colonneParution3, colonneDispo3,/* colonneMCle, */colonneAuteur);
			
			colonneNum3.setPrefWidth(60);				colonneNum3.setMaxWidth(60);
			colonneTitre3.setPrefWidth(410);			colonneTitre3.setMaxWidth(410);
			colonneParution3.setPrefWidth(120);			colonneParution3.setMaxWidth(120);
			colonneDispo3.setPrefWidth(80);				colonneDispo3.setMaxWidth(80);
			colonneAuteur.setPrefWidth(150);			colonneAuteur.setMaxWidth(150);
			
			colonneNum3.setCellValueFactory(new PropertyValueFactory<Livre, String>("noDoc"));
			colonneTitre3.setCellValueFactory(new PropertyValueFactory<Livre, String>("titre"));
			colonneParution3.setCellValueFactory(new PropertyValueFactory<Livre, LocalDate>("dateParution"));
			colonneDispo3.setCellValueFactory(new PropertyValueFactory<Livre, String>("disponible"));
			colonneAuteur.setCellValueFactory(new PropertyValueFactory<Livre, String>("auteur"));
			tableLivre.setItems(sortedLivre);
			tabLivre.setContent(tableLivre);
			
			
	//			onglet periodique
			tabPerio = new Tab();
			tabPerio.setClosable(false);
			tabPerio.setText("P�riodique");
//			tabPerio.setGraphic(new ImageView(new Image("images/icon-livre.png")));
			
			
			TableColumn<Periodique, String> colonneNum4 = new TableColumn<Periodique, String> ("Num�ro");
			TableColumn<Periodique, String> colonneTitre4 = new TableColumn<Periodique, String> ("Titre");
			TableColumn<Periodique, LocalDate> colonneParution4 = new TableColumn<Periodique, LocalDate> ("Date de parution");
			TableColumn<Periodique, String> colonneDispo4 = new TableColumn<Periodique, String> ("Disponible");
			TableColumn<Periodique, Integer> colonneVol = new TableColumn<Periodique, Integer> ("Num�ro de volume");
			TableColumn<Periodique, Integer> colonnePerio = new TableColumn<Periodique, Integer> ("Num�ro de p�riodique");
			tablePerio.getColumns().addAll(colonneNum4, colonneTitre4, colonneParution4, colonneDispo4, colonneVol, colonnePerio);
			
			colonneNum4.setPrefWidth(60);				colonneNum4.setMaxWidth(60);
			colonneTitre4.setPrefWidth(300);			colonneTitre4.setMaxWidth(300);
			colonneParution4.setPrefWidth(120);			colonneParution4.setMaxWidth(120);
			colonneDispo4.setPrefWidth(80);				colonneDispo4.setMaxWidth(80);
			colonneVol.setPrefWidth(120);				colonneVol.setMaxWidth(120);
			colonnePerio.setPrefWidth(140);				colonnePerio.setMaxWidth(150);
			
//					RECHERCHE TITRE / MOTS CLES
				donneesPerio = FXCollections.observableArrayList(Catalogue.getInstance().getLstPer());
				FilteredList<Periodique> filteredPer = new FilteredList<Periodique>(donneesPerio, per -> true);
				
				txtRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredPer.setPredicate(per -> {
							//si rien est taper dans le textfield, laisse tout passer
						if (newValue==null || newValue.isEmpty())
							return true;
							//quand il y a du text dans le textfield
						else if (per.getTitre().toLowerCase().contains(newValue.toLowerCase()))
							return true;
//						else if (book.getMotsCles().toLowerCase().contains(newValue.toLowerCase()))
//							return true; // match un des mots cl�s
						else
							return false; // match rien
					});
				});
				
				SortedList<Periodique> sortedPer = new SortedList<Periodique>(filteredPer);
				sortedPer.comparatorProperty().bind(tablePerio.comparatorProperty());
		
			colonneNum4.setCellValueFactory(new PropertyValueFactory<Periodique, String>("noDoc"));
			colonneTitre4.setCellValueFactory(new PropertyValueFactory<Periodique, String>("titre"));
			colonneParution4.setCellValueFactory(new PropertyValueFactory<Periodique, LocalDate>("dateParution"));
			colonneDispo4.setCellValueFactory(new PropertyValueFactory<Periodique, String>("disponible"));
			colonneVol.setCellValueFactory(new PropertyValueFactory<Periodique, Integer>("noVolume"));
			colonnePerio.setCellValueFactory(new PropertyValueFactory<Periodique, Integer>("noPeriodique"));
			tablePerio.setItems(sortedPer);
			tabPerio.setContent(tablePerio);
			
			tabUtil = new Tab();
			tabPrep = new Tab();
			tabPrepo = new Tab();
			tabAdher = new Tab();
			tabPrets = new Tab();
			
			
			if (true) {			// if logged in comme admin	ou prepose
			//			onglet utilisateurs
				
				// SECTION POUR GERER LES ADH�RANTS
				tabUtil.setClosable(false);
				tabUtil.setText("Adh�rants");
				
				HBox hBoxAdher = new HBox();
				hBoxAdher.setSpacing(20);
				hBoxAdher.setPadding(new Insets(10));
								
				TableColumn<Adherant, String> colonneId = new TableColumn<Adherant, String> ("ID");
				TableColumn<Adherant, String> colonneNom = new TableColumn<Adherant, String>("Nom");
				TableColumn<Adherant, String> colonnePrenom = new TableColumn<Adherant, String>("Prenom");
				TableColumn<Adherant, String> colonneNumTel = new TableColumn<Adherant, String>("Numero Tel");
				TableColumn<Adherant, String> colonneAdresse = new TableColumn<Adherant, String>("Adresse");
				tableUtilisateurs.getColumns().addAll(colonneId, colonneNom, colonnePrenom, colonneNumTel, colonneAdresse);
				
				donneesAdh = FXCollections.observableArrayList(Adherants.getInstance().getLstAdherants());
				colonneId.setCellValueFactory(new PropertyValueFactory<Adherant, String> ("strId"));
				colonneNom.setCellValueFactory(new PropertyValueFactory<Adherant, String>("nom"));
				colonnePrenom.setCellValueFactory(new PropertyValueFactory<Adherant, String>("prenom"));
				colonneNumTel.setCellValueFactory(new PropertyValueFactory<Adherant, String>("numTelephone"));
				colonneAdresse.setCellValueFactory(new PropertyValueFactory<Adherant, String>("adresse"));
				tableUtilisateurs.setItems(donneesAdh);

				GridPane gbModifU = new GridPane();
				gbModifU.setHgap(5);
				gbModifU.setVgap(5);
				Text txtModif1 = new Text("Actions sur adh�rants");
				btnAjoutUtil = new Button("Ajouter");
				btnAjoutUtil.setOnAction(gc);
				btnSupprUtil = new Button("Supprimer");
				btnSupprUtil.setOnAction(gc);
				Text txtModif2 = new Text("Modification");
				ToggleGroup tgModif = new ToggleGroup();
				rbModifAdr = new RadioButton("Adresse");
				rbModifAdr.setOnAction(gc);
				rbModifTel = new RadioButton("Numero Telephone");
				rbModifTel.setOnAction(gc);
				tgModif.getToggles().addAll(rbModifAdr, rbModifTel);
				
//					FEN�TRE MODALE POUR AJOUTER UN UTILISATEUR
					VBox vBoxAjU1 = new VBox();
					VBox.setMargin(vBoxAjU1, new Insets(20));
					vBoxAjU1.setPadding(new Insets(10));
					
					Text txtAjU1 = new Text("Informations de l'adh�rant");
					
					GridPane gpAddUser = new GridPane();
					gpAddUser.setHgap(5);
					gpAddUser.setVgap(5);
					Text txtId = new Text("ID");
					tbID = new TextField();
					tbID.setText("adher" + Adherants.getInstance().getCompteurID());
//					tbID.setDisable(true);
					txtP = new Text("Pr�nom");
					tbP = new TextField();
					txtN = new Text("Nom");
					tbN = new TextField();
					txtA = new Text("Adresse");
					tbA = new TextField();
					txtT = new Text("T�l�phone");
					tbT = new TextField();					
//					MaskedTextField text = new MaskedTextField("(###) ###-####");
//					text.setPlaceholder(' ');
					
					gpAddUser.add(txtId, 0, 0);					gpAddUser.add(tbID, 1, 0);
					gpAddUser.add(txtP, 0, 1);					gpAddUser.add(tbP, 1, 1);
					gpAddUser.add(txtN, 0, 2);					gpAddUser.add(tbN, 1, 2);
					gpAddUser.add(txtA, 0, 3);					gpAddUser.add(tbA, 1, 3);
					gpAddUser.add(txtT, 0, 4);					gpAddUser.add(tbT, 1, 4);
					
					HBox hBoxAjU2 = new HBox();
					Button btnUserConfir = new Button("Confirmer");
					btnUserConfir.setOnAction(e -> {
						if (tbN.getText().trim().length()==0 || tbP.getText().trim().length()==0 ||
							tbA.getText().length()==0 || tbT.getText().length()==0) {
							Optional<ButtonType> retour = afficherBoiteInfo(8);
						} 
						else {
							String nom = tbN.getText().trim();
							String prenom = tbP.getText().trim();
							String adresse = tbA.getText().trim();
							String telephone = tbT.getText().trim();
							Adherant adher = new Adherant("adher" + Adherants.getInstance().getCompteurID(),prenom, nom, adresse, telephone);
							Adherants.getInstance().addCompteur();
							
							Adherants.getInstance().addLstAdherant(adher);
							System.out.println(Adherants.getInstance().getLstAdherants());
							donneesAdh.add(adher);
							
							Optional<ButtonType> retour = afficherBoiteInfo(13);
							tbID.clear();
							tbP.clear();
							tbN.clear();
							tbA.clear();
							tbT.clear();
							stage4.close();
						}
					});
					
					Button btnUserQuit = new Button("Annuler");
					btnUserQuit.setOnAction(e -> stage4.close());
					hBoxAjU2.getChildren().addAll(btnUserConfir, btnUserQuit);
					hBoxAjU2.setSpacing(15);
					vBoxAjU1.getChildren().addAll(txtAjU1, gpAddUser, hBoxAjU2);
					vBoxAjU1.setSpacing(10);
					
					scene4 = new Scene(vBoxAjU1, 350, 250);
					stage4 = new Stage();
					stage4.setScene(scene4);
					stage4.setTitle("Ajouter un adh�rant");
					stage4.initModality(Modality.APPLICATION_MODAL);
				
				tbModifU = new TextField();
				tbModifU.setDisable(true);
				btnConfirmU = new Button("Confirmer");
				btnConfirmU.setOnAction(gc);
				btnConfirmU.setDisable(true);
				
				gbModifU.add(txtModif1, 0, 0, 2, 1);
				gbModifU.add(btnAjoutUtil, 0, 1, 1, 1);				gbModifU.add(btnSupprUtil, 1, 1, 1, 1);
				gbModifU.add(txtModif2, 0, 2, 2, 1);
				gbModifU.add(rbModifAdr, 0, 3, 1, 1);				gbModifU.add(rbModifTel, 1, 3, 1, 1);
				gbModifU.add(tbModifU, 0, 4, 2, 1);
				gbModifU.add(btnConfirmU, 0, 5, 2, 1);
				
				hBoxAdher.getChildren().addAll(tableUtilisateurs, gbModifU);
				tabUtil.setContent(hBoxAdher);
				
				
				// SECTION POUR GERER LES PREPOSES
				tabPrep.setClosable(false);
				tabPrep.setText("Pr�pos�s");
				
				HBox hBoxPrep = new HBox();
				hBoxPrep.setSpacing(20);
				hBoxPrep.setPadding(new Insets(10));
								
				TableColumn<Prepose, String> colonneIdPrep = new TableColumn<Prepose, String> ("ID");
				TableColumn<Prepose, String> colonneMotDePasse = new TableColumn<Prepose, String>("Mot de passe");
				tabPrepose.getColumns().addAll(colonneIdPrep, colonneMotDePasse);
				
				donneesPrep = FXCollections.observableArrayList(Preposes.getInstance().getLstPreposes());
				colonneIdPrep.setCellValueFactory(new PropertyValueFactory<Prepose, String> ("id"));
				colonneMotDePasse.setCellValueFactory(new PropertyValueFactory<Prepose, String> ("MotDePasse"));
				tabPrepose.setItems(donneesPrep);

				GridPane gbModifPrep = new GridPane();
				gbModifPrep.setHgap(5);
				gbModifPrep.setVgap(5);
				Text txtModifPrep = new Text("Actions sur Pr�pos�s");
				btnAjoutPrep = new Button("Ajouter");
				btnAjoutPrep.setOnAction(gc);
				btnSupprPrep = new Button("Supprimer");
				btnSupprPrep.setOnAction(gc);
				Text txtModifPrep2 = new Text("Modification");
				ToggleGroup tgModifPrep = new ToggleGroup();
				rbModifID = new RadioButton("ID");
				rbModifID.setOnAction(gc);
				rbModifMDP = new RadioButton("Mot de passe");
				rbModifMDP.setOnAction(gc);
				tgModifPrep.getToggles().addAll(rbModifID, rbModifMDP);
				
//					FEN�TRE MODALE POUR AJOUTER UN UTILISATEUR
					VBox vBoxAjPrep1 = new VBox();
					VBox.setMargin(vBoxAjPrep1, new Insets(20));
					vBoxAjPrep1.setPadding(new Insets(10));
					
					Text txtAjUPrep1 = new Text("Informations du pr�pos�");				
					GridPane gpAddPrep = new GridPane();
					gpAddPrep.setHgap(5);
					gpAddPrep.setVgap(5);
					Text txtIdPrep = new Text("ID");
					tbIDPrep = new TextField();
					txtMDP = new Text("Mot de passe");
					tbMDP = new TextField();
					
					gpAddPrep.add(txtIdPrep, 0, 0);					gpAddPrep.add(tbIDPrep, 1, 0);
					gpAddPrep.add(txtMDP, 0, 1);					gpAddPrep.add(tbMDP, 1, 1);
					
					HBox hBoxAjUPrep2 = new HBox();
					Button btnPrepConfir = new Button("Confirmer");
					btnPrepConfir.setOnAction(e -> {
						if (tbIDPrep.getText().trim().length()==0 || tbMDP.getText().trim().length()==0) {
							Optional<ButtonType> retour = afficherBoiteInfo(8);
						} 
						else {
							String ID = tbIDPrep.getText().trim();
							String MotDePasse = tbMDP.getText().trim();
							Prepose prep = new Prepose(ID, MotDePasse);
							
							Preposes.getInstance().addLstPrepose(prep);
							donneesPrep.add(prep);
							
							Optional<ButtonType> retour = afficherBoiteInfo(13);
							tbIDPrep.clear();
							tbMDP.clear();
							stage5.close();
						}
					});
					
					Button btnPrepQuit = new Button("Annuler");
					btnPrepQuit.setOnAction(e -> stage5.close());
					hBoxAjUPrep2.getChildren().addAll(btnPrepConfir, btnPrepQuit);
					hBoxAjUPrep2.setSpacing(15);
					vBoxAjPrep1.getChildren().addAll(txtAjUPrep1, gpAddPrep, hBoxAjUPrep2);
					vBoxAjPrep1.setSpacing(10);
					
					scene5 = new Scene(vBoxAjPrep1, 350, 250);
					stage5 = new Stage();
					stage5.setScene(scene5);
					stage5.setTitle("Ajouter un pr�pos�");
					stage5.initModality(Modality.APPLICATION_MODAL);
				
				tbModifPrep = new TextField();
				tbModifPrep.setDisable(true);
				btnModifConfirmPrep = new Button("Confirmer");
				btnModifConfirmPrep.setOnAction(gc);
				btnModifConfirmPrep.setDisable(true);
				
				gbModifPrep.add(txtModifPrep, 0, 0, 2, 1);
				gbModifPrep.add(btnAjoutPrep, 0, 1, 1, 1);			gbModifPrep.add(btnSupprPrep, 1, 1, 1, 1);
				gbModifPrep.add(txtModifPrep2, 0, 2, 2, 1);
				gbModifPrep.add(rbModifID, 0, 3, 1, 1);				gbModifPrep.add(rbModifMDP, 1, 3, 1, 1);
				gbModifPrep.add(tbModifPrep, 0, 4, 2, 1);
				gbModifPrep.add(btnModifConfirmPrep, 0, 5, 2, 1);
				
				hBoxPrep.getChildren().addAll(tabPrepose, gbModifPrep);
				tabPrep.setContent(hBoxPrep);
			}
			
			if (true) {			// if logged in comme prepos�
			//			onglet catalogue
				tabPrepo.setClosable(false);
				tabPrepo.setText("Catalogue");
				
				HBox hBoxCatal = new HBox();
				hBoxCatal.setSpacing(20);
				hBoxCatal.setPadding(new Insets(10));
				
				TableColumn<Document, String> colonneNo = new TableColumn<Document, String> ("No Doc");
				TableColumn<Document, String> colonneTi = new TableColumn<Document, String>("Titre");
				TableColumn<Document, LocalDate> colonneDP = new TableColumn<Document, LocalDate>("Date parution");
				TableColumn<Document, String> colonneNumDi = new TableColumn<Document, String>("Disponibilite");
				tableCatalogue.getColumns().addAll(colonneNo, colonneTi, colonneDP, colonneNumDi);
				
				colonneNo.setCellValueFactory(new PropertyValueFactory<Document, String> ("noDoc"));
				colonneTi.setCellValueFactory(new PropertyValueFactory<Document, String>("titre"));
				colonneDP.setCellValueFactory(new PropertyValueFactory<Document, LocalDate>("dateParution"));
				colonneNumDi.setCellValueFactory(new PropertyValueFactory<Document, String>("disponible"));
				tableCatalogue.setItems(donneesDoc);
		
				
				GridPane gbModifC = new GridPane();
				gbModifC.setHgap(5);
				gbModifC.setVgap(5);
				Text txtModif2 = new Text("Actions sur le catalogue");
				btnAjoutCata = new Button("Ajouter");
				btnAjoutCata.setOnAction(gc);
				btnSupprCata = new Button("Supprimer");
				btnSupprCata.setOnAction(gc);
							
				gbModifC.add(txtModif2, 0, 0, 2, 1);
				gbModifC.add(btnAjoutCata, 0, 1, 1, 1);				gbModifC.add(btnSupprCata, 1, 1, 1, 1);
				
				hBoxCatal.getChildren().addAll(tableCatalogue, gbModifC);
				tabPrepo.setContent(hBoxCatal);
			}
			
//					FEN�TRE DE AJOUT DE DOCUMENT DANS LE CATALOGUE
					VBox vBoxAj1 = new VBox();
					VBox.setMargin(vBoxAj1, new Insets(20));
					vBoxAj1.setPadding(new Insets(10));
					
					Text txtAj1 = new Text("Type de document");
					ToggleGroup tgAjoutCata = new ToggleGroup();
					rbAjoutL = new RadioButton("Livre");
					rbAjoutL.setOnAction(gc);
					rbAjoutL.setSelected(true);
					rbAjoutD = new RadioButton("DVD");
					rbAjoutD.setOnAction(gc);
					rbAjoutP = new RadioButton("P�riodique");
					rbAjoutP.setOnAction(gc);
					tgAjoutCata.getToggles().addAll(rbAjoutL,rbAjoutD,rbAjoutP);
				
					txtAjTitr = new Text("Titre");
					tbAjTitr = new TextField();
					txtAjDate = new Text("Date de parution");
					tbAjDate = new TextField();
					txtAjMC = new Text("Mots Cl�s (s�par� par virgule)");
					tbAjMC = new TextField();
					
					txtAj2 = new Text("Auteur");
					tbAj2 = new TextField();
					txtAj3 = new Text();
					txtAj3.setVisible(false);
					tbAj3 = new TextField();
					tbAj3.setVisible(false);
					
					btnCataConfir = new Button("Confirmer");
					btnCataConfir.setOnAction(gc);
					Button btnCataQuit = new Button("Annuler");
					btnCataQuit.setOnAction(e -> stage3.close());
					
					GridPane gpAj = new GridPane();
					gpAj.setHgap(5);
					gpAj.setVgap(5);
					gpAj.add(txtAjTitr, 0, 0);				gpAj.add(tbAjTitr, 1, 0);
					gpAj.add(txtAjDate, 0, 1);				gpAj.add(tbAjDate, 1, 1);
					gpAj.add(txtAjMC, 0, 2);				gpAj.add(tbAjMC, 1, 2);
					gpAj.add(txtAj2, 0, 3);					gpAj.add(tbAj2, 1, 3);
					gpAj.add(txtAj3, 0, 4);					gpAj.add(tbAj3, 1, 4);
					
					HBox hBoxAj1 = new HBox();
					hBoxAj1.getChildren().addAll(rbAjoutL, rbAjoutD, rbAjoutP);	
					hBoxAj1.setSpacing(25);
					HBox hBoxAj2 = new HBox();
					HBox.setMargin(hBoxAj2, new Insets(10));
					hBoxAj2.getChildren().addAll(btnCataConfir, btnCataQuit);
					hBoxAj2.setSpacing(15);
					vBoxAj1.getChildren().addAll(txtAj1, hBoxAj1, gpAj, hBoxAj2);
					vBoxAj1.setSpacing(10);
					
					scene3 = new Scene(vBoxAj1, 350, 250);
					stage3 = new Stage();
					stage3.setScene(scene3);
					stage3.setTitle("Ajouter un document");
					stage3.initModality(Modality.APPLICATION_MODAL);
			
			if (true) {			// if logged in comme adher	
			//			onglet compte
				tabAdher.setClosable(false);
				tabAdher.setText("Compte");
				
				VBox vBoxUtil = new VBox();
				HBox hBoxPretAdher = new HBox();
			
				txtUtil = new Text();
				txtIdAdher = new Text();
				txtAdresseAdher = new Text();
				txtNumAdher = new Text();
			
				txtUtil.setText("Adh�rant: ");
				txtIdAdher.setText("ID: ");
				txtAdresseAdher.setText("Adresse: ");
				txtNumAdher.setText("Num�ro de t�l�phone: ");
				
				hBoxPretAdher.getChildren().addAll(txtIdAdher, txtAdresseAdher, txtNumAdher);
				
				TableColumn<Pret, String> colonneIdPretAdher = new TableColumn<Pret, String>();
				TableColumn<Pret, String> colonneIdAdherPretAdher = new TableColumn<Pret, String>();
				TableColumn<Pret, String> colonneIdDocPretAdher = new TableColumn<Pret, String>();
				TableColumn<Pret, LocalDate> colonneDateEmpruntPretAdher = new TableColumn<Pret, LocalDate>();
				TableColumn<Pret, LocalDate> colonneDateRetourPretAdher = new TableColumn<Pret, LocalDate>();
				TableColumn<Pret, Double> colonneAmendePretAdher = new TableColumn<Pret, Double>();
				tablePretAdher.getColumns().addAll(colonneIdPretAdher, colonneIdAdherPretAdher, colonneIdDocPretAdher, colonneDateEmpruntPretAdher, colonneDateRetourPretAdher, colonneAmendePretAdher);
				
				colonneIdPretAdher.setPrefWidth(100);			colonneIdPretAdher.setMaxWidth(100);
				colonneDateEmpruntPretAdher.setPrefWidth(100);				colonneDateEmpruntPretAdher.setMaxWidth(100);
				colonneDateRetourPretAdher.setPrefWidth(100);			colonneDateRetourPretAdher.setMaxWidth(100);
				colonneIdAdherPretAdher.setPrefWidth(100);				colonneIdAdherPretAdher.setMaxWidth(100);
				colonneIdDocPretAdher.setPrefWidth(100);			colonneIdDocPretAdher.setMaxWidth(100);
				colonneAmendePretAdher.setPrefWidth(100);			colonneAmendePretAdher.setMaxWidth(100);
				
				colonneIdPretAdher.setCellValueFactory(new PropertyValueFactory<Pret, String>("idPret"));
				colonneIdAdherPretAdher.setCellValueFactory(new PropertyValueFactory<Pret, String>("idAdherant"));
				colonneIdDocPretAdher.setCellValueFactory(new PropertyValueFactory<Pret, String>("noDoc"));
				colonneDateEmpruntPretAdher.setCellValueFactory(new PropertyValueFactory<Pret, LocalDate>("dateEmprunt"));
				colonneDateRetourPretAdher.setCellValueFactory(new PropertyValueFactory<Pret, LocalDate>("dateRetour"));
				colonneAmendePretAdher.setCellValueFactory(new PropertyValueFactory<Pret, Double>("amende"));
				tablePretAdher.setItems(donneesPretAdher);
				
				VBox.setMargin(txtUtil, new Insets(10));
				VBox.setMargin(tablePretAdher, new Insets(10));
				HBox.setMargin(txtIdAdher, new Insets(10));
				HBox.setMargin(txtNumAdher, new Insets(10));
				HBox.setMargin(txtAdresseAdher, new Insets(10));
				
				
				vBoxUtil.getChildren().addAll(txtUtil, hBoxPretAdher, tablePretAdher);
				tabAdher.setContent(vBoxUtil);
			}
			
			if (true) {			// if logged in comme prep/admin
			//		onglet pr�ts
				HBox hBoxPret = new HBox();
				hBoxPret.setPadding(new Insets(10));
				hBoxPret.setSpacing(20);
				tabPrets.setClosable(false);
				tabPrets.setText("Pr�ts");
//				tabDoc.setGraphic(new ImageView(new Image("icon-collection.png")));
				
				TableColumn<Pret, String> colonneIdPret = new TableColumn<Pret, String> ("ID du pr�t");
				TableColumn<Pret, String> colonneEmpr = new TableColumn<Pret, String> ("Date d'emprunt");
				TableColumn<Pret, String> colonneEmprID = new TableColumn<Pret, String> ("ID de l'adh�rant");
				TableColumn<Pret, String> colonneNum5 = new TableColumn<Pret, String> ("ID du document");
				TableColumn<Pret, String> colonneRetour = new TableColumn<Pret, String> ("Date de retour");
				TableColumn<Pret, Number> colonneAmende = new TableColumn<Pret, Number> ("Amende");
				tablePrets.getColumns().addAll(colonneIdPret,colonneEmpr, colonneEmprID, colonneNum5, colonneRetour,colonneAmende);
				
				colonneIdPret.setPrefWidth(100);			colonneIdPret.setMaxWidth(100);
				colonneEmpr.setPrefWidth(100);				colonneEmpr.setMaxWidth(100);
				colonneEmprID.setPrefWidth(100);			colonneEmprID.setMaxWidth(100);
				colonneNum5.setPrefWidth(100);				colonneNum5.setMaxWidth(100);
				colonneRetour.setPrefWidth(100);			colonneRetour.setMaxWidth(100);
				colonneAmende.setPrefWidth(100);			colonneAmende.setMaxWidth(100);

				donneesPrets = FXCollections.observableArrayList(ArchivePret.getInstance().getLstPrets());
				colonneIdPret.setCellValueFactory(new PropertyValueFactory<Pret, String>("idPret"));
				colonneEmpr.setCellValueFactory(new PropertyValueFactory<Pret, String>("dateEmprunt"));
				colonneEmprID.setCellValueFactory(new PropertyValueFactory<Pret, String>("idAdherant"));
				colonneNum5.setCellValueFactory(new PropertyValueFactory<Pret, String>("noDoc"));
				colonneRetour.setCellValueFactory(new PropertyValueFactory<Pret, String>("dateRetour"));
				colonneAmende.setCellValueFactory(new PropertyValueFactory<Pret, Number>("amende"));
				tablePrets.setItems(donneesPrets);
				
				
				GridPane gpEmpr = new GridPane();
				GridPane.setMargin(gpEmpr, new Insets(15));
				gpEmpr.setVgap(15);
				gpEmpr.setHgap(5);
				
				Text txtEmprID = new Text("ID de l'adh�rant");
				tbEmprID = new TextField();
				tbEmprID.setMaxWidth(50);
				tbEmprID.setPrefWidth(50);
				btnRetourner = new Button("Inscrire un retour");
				btnRetourner.setOnAction(gc);
				btnEmprunter = new Button("Inscrire un pr�t");
				btnEmprunter.setOnAction(gc);
				btnPayer = new Button("Payer une amende");
				btnPayer.setOnAction(gc);
				Text txtEmprDocID = new Text("Doc ID:");
				tbEmprDocID = new TextField();
				tbEmprDocID.setMaxWidth(50);
				tbEmprDocID.setPrefWidth(50);

				gpEmpr.add(txtEmprID, 0, 0);				gpEmpr.add(tbEmprID, 1, 0);
				gpEmpr.add(txtEmprDocID, 0, 1);				gpEmpr.add(tbEmprDocID, 1, 1);
				gpEmpr.add(btnEmprunter, 0, 3);				
				gpEmpr.add(btnRetourner, 0, 4);
				gpEmpr.add(btnPayer, 0, 5);
				
				hBoxPret.getChildren().addAll(tablePrets, gpEmpr);
				tabPrets.setContent(hBoxPret);
			}
			
			tabPane.getTabs().addAll(tabDoc, tabDvd, tabLivre, tabPerio, tabAdher, tabPrets, tabPrepo, tabUtil, tabPrep);
			
			HBox hBoxBtn = new HBox();
			
			Button btnQuit = new Button();
			btnQuit.setText("Quitter");
			btnQuit.setOnAction(e -> {stage2.close(); primaryStage.close(); 
				SerialisationCatalogue.serialiseCata();
				Adherants.getInstance().serialiseAdherants();
				Preposes.getInstance().serialisePreposes();
				ArchivePret.getInstance().serialiseArchivePret();
			});
			HBox.setMargin(btnQuit, new Insets(10));
			
			Button btnFermer = new Button();
			btnFermer.setText("Fermer le catalogue");
			btnFermer.setOnAction(e -> {stage2.close();
				SerialisationCatalogue.serialiseCata();
				Adherants.getInstance().serialiseAdherants();
				Preposes.getInstance().serialisePreposes();
				ArchivePret.getInstance().serialiseArchivePret();
			});
			HBox.setMargin(btnFermer, new Insets(10));
					
			hBoxBtn.getChildren().addAll(btnQuit, btnFermer);
			vBox2.getChildren().addAll(hBoxSearch, tabPane, hBoxBtn);
			root2.setCenter(vBox2);
			
			calculAmendes();
				
			
//					< / INTERFACE DE CATALOGUE >
//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public class GestionClick implements EventHandler<ActionEvent> {
		
		@SuppressWarnings({ "unused", "unlikely-arg-type" })
		public void handle(ActionEvent e) {
			
			if (e.getSource() == btnCons) {
				//	IDENTIFICATION CAS O� LES CASES SONT VIDES
				
				if ( txtNom.getText().trim().length()==0 && txtPrenom.getText().trim().length()==0 && txtTel.getText().trim().length()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(0);
					txtNom.requestFocus();
				} else if (txtNom.getText().trim().length()!=0 && txtPrenom.getText().trim().length()!=0 && cbConn.isSelected()) {
					if((txtNom.getText().trim().compareTo("admin")==0) && (txtPrenom.getText().trim().compareTo("admin")==0)) {
						Optional<ButtonType> retour = afficherBoiteInfo(10);
						tabAdher.setDisable(false);			// L'admin a toute les options
						tabPrepo.setDisable(false);
						tabPrets.setDisable(false);
						tabUtil.setDisable(false);
						tabPrep.setDisable(false);
						stage2.showAndWait();	
					}
					else if(connectedPrepose(txtNom.getText().trim(), txtPrenom.getText().trim())){
						Optional<ButtonType> retour = afficherBoiteInfo(9);
						tabAdher.setDisable(false);			// Le pr�pos� a toutes les options pour l'instant
						tabPrepo.setDisable(false);
						tabPrets.setDisable(false);
						tabUtil.setDisable(false);
						tabPrep.setDisable(true);
						stage2.showAndWait();
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(12);
						txtNom.requestFocus();
					}
				} else if (txtTel.getLength()!=14 && (txtNom.getText().trim().length()==0 && txtPrenom.getText().trim().length()==0)) {
					Optional<ButtonType> retour = afficherBoiteInfo(1);
					txtTel.requestFocus();
//					CAS O� CONNECTION EST BONNE
					} else if ((txtNom.getLength()!=0 && txtPrenom.getLength()!=0) && txtTel.getLength()==14 && !cbConn.isSelected()) {
						if(connectedAdherant(txtNom.getText().trim(), txtPrenom.getText().trim(), txtTel.getText().trim())) {
							Optional<ButtonType> retour = afficherBoiteInfo(9);
							connectedAdher = getAdherant(txtNom.getText().trim(), txtPrenom.getText().trim(), txtTel.getText().trim());
							
							txtUtil.setText("Adh�rant: " + connectedAdher.getNom() + " " +  connectedAdher.getPrenom());
							txtIdAdher.setText("ID: " + connectedAdher.getStrId());
							txtAdresseAdher.setText("Adresse: " + connectedAdher.getAdresse());
							txtNumAdher.setText("Num�ro de t�l�phone: " + connectedAdher.getNumTelephone());
							donneesPretAdher = FXCollections.observableArrayList(connectedAdher.getLstPrets());
							tablePretAdher.setItems(donneesPretAdher);
							tabAdher.setDisable(false);			// Lorsqu'il est connect� l'adh�rant
							tabPrepo.setDisable(true);			// ne peut acc�der qu'aux informations
							tabPrets.setDisable(true);			// de son compte et au catalogue
							tabUtil.setDisable(true);
							tabPrep.setDisable(true);
							stage2.showAndWait();
						}
						else {
							Optional<ButtonType> retour = afficherBoiteInfo(12);
							txtNom.requestFocus();
						}
					} 
				}

			
//				BOUTON CONSULTER LA M�DIATH�QUE
			if (e.getSource() == btnBiblio) {
				tabAdher.setDisable(true);			// Lorsque l'utilisateur n'est 
				tabPrepo.setDisable(true);			// connect� sur aucun compte 
				tabPrets.setDisable(true);			// il n'a le droit de consulter
				tabUtil.setDisable(true);			// que le catalogue
				tabPrep.setDisable(true);			
				stage2.showAndWait();
			}

//				ENSEMBLE RADIO BUTTON DE IDENTIFIEZ-VOUS/CONNEXION 
			if (cbConn.isSelected()) {
				txt4.setVisible(false);
				txtTel.setVisible(false);
				txt1.setText("Connectez vous");
				txt2.setText("ID:");
				txt3.setText("Mot de passe:");
				txtNom.clear();
				txtPrenom.clear();
				txtTel.clear();
				txtNom.requestFocus();
			} else if (!cbConn.isSelected()) {
				txt4.setVisible(true);
				txtTel.setVisible(true);
				txt1.setText("Identifiez vous");
				txt2.setText("Votre nom:");
				txt3.setText("Votre pr�nom:");
				txtNom.clear();
				txtPrenom.clear();
				txtTel.clear();
				txtNom.requestFocus();
			}	
			
//				BOUTTON DE AJOUTER ADH�RANTS
			if (e.getSource() == btnAjoutUtil) {
				stage4.showAndWait();
			}
			
			if(e.getSource() == btnAjoutPrep) {
				stage5.showAndWait();
			}
			
//				ENSEMBLE DE RADIO BUTTON DE MODIFICATION DES INFORMATIONS DES ADH�RANTS
			if (rbModifAdr.isSelected()) {
				tbModifU.setDisable(false);
				btnConfirmU.setDisable(false);
			} else if (rbModifTel.isSelected()) {
				tbModifU.setDisable(false);
				btnConfirmU.setDisable(false);
			}
			
//				ENSEMBLE DE RADIO BUTTON DE MODIFICATION DES INFORMATIONS DES PR�POS�S
			if (rbModifID.isSelected()) {
				tbModifPrep.setDisable(false);
				btnModifConfirmPrep.setDisable(false);
			} else if (rbModifMDP.isSelected()) {
				tbModifPrep.setDisable(false);
				btnModifConfirmPrep.setDisable(false);
			}
			
//				STAGE 3, BOITE DE AJOUT CATALOGUE
			if (e.getSource() == btnAjoutCata) {
				stage3.showAndWait();
			}
			
//				ENSEMBLE RADIO BUTTON DE AJOUTER AU CATALOGUE
			if (rbAjoutL.isSelected()) {
				txtAj2.setText("Auteur");
				txtAj2.setVisible(true); tbAj2.setVisible(true);txtAj3.setVisible(false); tbAj3.setVisible(false);
			} else if (rbAjoutD.isSelected()) {
				txtAj2.setText("R�alisateur"); txtAj3.setText("Nombre de disques");
				txtAj2.setVisible(true); tbAj2.setVisible(true);txtAj3.setVisible(true); tbAj3.setVisible(true);
			} else if (rbAjoutP.isSelected()) {
				txtAj2.setText("Num�ro de volume"); txtAj3.setText("Num�ro de p�riodique");
				txtAj2.setVisible(true); tbAj2.setVisible(true);txtAj3.setVisible(true); tbAj3.setVisible(true);
			}
	
//			BOUTON POUR EMPRUNTER UN DOCUMENT
			if(e.getSource() == btnEmprunter) {
				if(tbEmprDocID.getText().trim().length()==0 || tbEmprID.getText().trim().length()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(8);
				}
				else {
					String IDdoc = tbEmprDocID.getText().trim();
					String IDAdher = tbEmprID.getText().trim();
					boolean booIDOK = EmpruntIdOK(IDdoc, IDAdher);
					if(booIDOK) {
						boolean booAmendeok = true;
						boolean booDocDispo = getDoc(IDdoc).getDisponible();
						boolean dispoAmendeok;
						
						dispoAmendeok = booAmendeok & booDocDispo;
						Adherant adherant = getAdherant(IDAdher);
						for(Pret pret: adherant.getLstPrets()) {
							if(pret.getAmende() != 0) {
								booAmendeok = false;
								Optional<ButtonType> retour = afficherBoiteInfo(17);
							}
							if(!booDocDispo) {
								Optional<ButtonType> retour = afficherBoiteInfo(19);
							}
						}
						if(dispoAmendeok) {
							String typedoc = TypeDocument(IDdoc);
							
							Pret pret;
							// 2 DVD MAX, 3 LIVRES MAX, 1 PERIODIQUE MAX
							switch (typedoc) {
							case "dvd":
								if(NombreEmprunter(IDAdher, typedoc) == 2) {
									Optional<ButtonType> retour = afficherBoiteInfo(16);
								}
								else {
									pret = new Pret(LocalDate.now(), IDAdher, IDdoc, "pret" + ArchivePret.getInstance().getCompteurIdPret());
									ArchivePret.getInstance().addCompteurIdPret();
									ArchivePret.getInstance().addLstPrets(pret);
									
									adherant.addPret(pret);
									getDoc(IDdoc).setDisponible(false);
									donneesPrets.add(pret);
									Optional<ButtonType> retour = afficherBoiteInfo(18);
								}
								break;
							case "lvr":
								if(NombreEmprunter(IDAdher, typedoc) == 3) {
									Optional<ButtonType> retour = afficherBoiteInfo(16);
								}
								else {

									pret = new Pret(LocalDate.now(), IDAdher, IDdoc, "pret" + ArchivePret.getInstance().getCompteurIdPret());
									ArchivePret.getInstance().addCompteurIdPret();
									ArchivePret.getInstance().addLstPrets(pret);

									adherant.addPret(pret);
									getDoc(IDdoc).setDisponible(false);
									donneesPrets.add(pret);
									Optional<ButtonType> retour = afficherBoiteInfo(18);
								}
								break;
							case "per":
								if(NombreEmprunter(IDAdher, typedoc) == 1) {
									Optional<ButtonType> retour = afficherBoiteInfo(16);
								}
								else {

									pret = new Pret(LocalDate.now(), IDAdher, IDdoc, "pret" + ArchivePret.getInstance().getCompteurIdPret());
									ArchivePret.getInstance().addCompteurIdPret();
									ArchivePret.getInstance().addLstPrets(pret);


									adherant.addPret(pret);
									getDoc(IDdoc).setDisponible(false);
									donneesPrets.add(pret);
									Optional<ButtonType> retour = afficherBoiteInfo(18);
								}
								break;
							default:
								break;
							}
						}
						else {
							Optional<ButtonType> retour = afficherBoiteInfo(17);
						}
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(15);
					}
				}
			}
			
//			RETOUR D'UN DOCUMENT
			if(e.getSource() == btnRetourner) {
				Pret pret = tablePrets.getSelectionModel().getSelectedItem();
				if(pret != null) {
					if(pret.getAmende() != 0) {
					Optional<ButtonType> retour = afficherBoiteInfo(17);
					}
					else {
						Adherant adher = getAdherant(pret.getIdAdherant());
						donneesPrets.remove(pret);
						adher.getLstPrets().remove(pret);
						getDoc(pret.getNoDoc()).setDisponible(true);
						pret.setDateRetour(LocalDate.now());
						Optional<ButtonType> retour = afficherBoiteInfo(20);
					}
				}
				else {
					Optional<ButtonType> retour = afficherBoiteInfo(23);
				}
			}
			
//			PAIEMENT D'UNE AMENDE
			if(e.getSource() == btnPayer) {
				Pret pret = tablePrets.getSelectionModel().getSelectedItem();
				if (pret != null) {
					if(pret.getAmende() != 0) {
						Adherant adher = getAdherant(pret.getIdAdherant());
						donneesPrets.remove(pret);
						adher.getLstPrets().remove(pret);
						getDoc(pret.getNoDoc()).setDisponible(true);
						pret.setDateRetour(LocalDate.now());
						pret.setAmende(0);
						Optional<ButtonType> retour = afficherBoiteInfo(21);
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(22);
					}
				}
				else {
					Optional<ButtonType> retour = afficherBoiteInfo(23);
				}
			}
			
//			MODIFICATION PREPOSES
			if(e.getSource() == btnModifConfirmPrep) {
				if(rbModifID.isSelected()) {
					if(tbModifPrep.getText().trim().length() != 0) {
						Prepose prep = tabPrepose.getSelectionModel().getSelectedItem();
						if(prep != null) {
							prep.setStrId(tbModifPrep.getText().trim());
							donneesPrep.set(tabPrepose.getSelectionModel().getSelectedIndex(), prep);
							Optional<ButtonType> retour = afficherBoiteInfo(24);
							tbModifPrep.clear();
						}
						else {
							Optional<ButtonType> retour = afficherBoiteInfo(23);
						}
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
					}
				}
				else {
					if(tbModifPrep.getText().trim().length() != 0) {
						Prepose prep = tabPrepose.getSelectionModel().getSelectedItem();
						if(prep != null) {
							prep.setMotDePasse(tbModifPrep.getText().trim());
							donneesPrep.set(tabPrepose.getSelectionModel().getSelectedIndex(), prep);
							Optional<ButtonType> retour = afficherBoiteInfo(24);
							tbModifPrep.clear();
						}
						else {
							Optional<ButtonType> retour = afficherBoiteInfo(23);
						}
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
					}
				}
			}
			
//			MODIFICATION ADH�RANTS
			if(e.getSource() == btnConfirmU) {
				if(rbModifAdr.isSelected()) {
					if(tbModifU.getText().trim().length() != 0) {
						Adherant adher = tableUtilisateurs.getSelectionModel().getSelectedItem();
						if(adher != null) {
							adher.setAdresse(tbModifU.getText().trim());
							donneesAdh.set(tableUtilisateurs.getSelectionModel().getSelectedIndex(), adher);
							Optional<ButtonType> retour = afficherBoiteInfo(28);
							tbModifU.clear();
						}
						else {
							Optional<ButtonType> retour = afficherBoiteInfo(23);
						}
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
					}
				}
				else {
					if(tbModifU.getText().trim().length() != 0) {
						Adherant adher = tableUtilisateurs.getSelectionModel().getSelectedItem();
						if(adher != null) {
							if(tbModifU.getText().trim().length() != 14) {
								Optional<ButtonType> retour = afficherBoiteInfo(25);
							}
							else {
								adher.setNumTelephone(tbModifU.getText().trim());
								donneesAdh.set(tableUtilisateurs.getSelectionModel().getSelectedIndex(), adher);
								Optional<ButtonType> retour = afficherBoiteInfo(28);
								tbModifU.clear();
							}
						}
						else {
							Optional<ButtonType> retour = afficherBoiteInfo(23);
						}
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
					}
				}
			}
			
//			SUPPRIMER PREPOSE
			if(e.getSource() == btnSupprPrep) {
				Prepose prep = tabPrepose.getSelectionModel().getSelectedItem();
				if(prep != null) {
					donneesPrep.remove(prep);
					Preposes.getInstance().getLstPreposes().remove(prep);
					Optional<ButtonType> retour = afficherBoiteInfo(26);
				}
				else {
					Optional<ButtonType> retour = afficherBoiteInfo(23);
				}
			}
			
//			SUPPRIMER ADH�RANT
			if(e.getSource() == btnSupprUtil) {
				Adherant adher = tableUtilisateurs.getSelectionModel().getSelectedItem();
				if(adher != null) {
					donneesAdh.remove(adher);
					Adherants.getInstance().getLstAdherants().remove(adher);
					Optional<ButtonType> retour = afficherBoiteInfo(27);
				}
				else {
					Optional<ButtonType> retour = afficherBoiteInfo(23);
				}
			}
			
			
//			AJOUT DOCUMENT DANS CATALOGUE
			if(e.getSource() == btnCataConfir) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
				if(rbAjoutL.isSelected()) {
					if(tbAjTitr.getText().trim().length() == 0 || tbAjDate.getText().trim().length() == 0 || tbAjMC.getText().trim().length() == 0 ||
							tbAj2.getText().trim().length() == 0) {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
					}
					else {
						String titre = tbAjTitr.getText().trim();
						LocalDate date = LocalDate.parse(tbAjDate.getText().trim(), formatter);
						String motsCles = tbAjMC.getText().trim();
						String Auteur = tbAj2.getText().trim();
						Livre livre = new Livre("Livre" + Catalogue.getInstance().getCompteurIdLivre(),titre, date, true, motsCles, Auteur);
						Catalogue.getInstance().addLstDocuments(livre);
						Catalogue.getInstance().addLstLivres(livre);
						donneesDoc.add(livre);
						donneesLivres.add(livre);
						tbAjTitr.clear();
						tbAjDate.clear();
						tbAj2.clear();
						stage3.close();
						Optional<ButtonType> retour = afficherBoiteInfo(29);
					}
				}
				else if(rbAjoutD.isSelected()) {
					if(tbAjTitr.getText().trim().length() == 0 || tbAjDate.getText().trim().length() == 0 || tbAjMC.getText().trim().length() == 0 ||
							tbAj2.getText().trim().length() == 0 || tbAj3.getText().trim().length() == 0) {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
					}
					else {
						String titre = tbAjTitr.getText().trim();
						LocalDate date = LocalDate.parse(tbAjDate.getText().trim(), formatter);
						String motsCles = tbAjMC.getText().trim();
						String realisateur = tbAj2.getText().trim();
						int nbDisques = Integer.parseInt(tbAj3.getText().trim());
						
						DVD dvd = new DVD("DVD" + Catalogue.getInstance().getCompteurIdDVD(),titre, date, true, nbDisques, realisateur, motsCles);
						Catalogue.getInstance().addLstDocuments(dvd);
						Catalogue.getInstance().addLstDvd(dvd);
						donneesDoc.add(dvd);
						donneesDvd.add(dvd);
						tbAjTitr.clear();
						tbAjDate.clear();
						tbAj2.clear();
						tbAj3.clear();
						stage3.close();
						Optional<ButtonType> retour = afficherBoiteInfo(29);
					}
				}
				else {
					if(tbAjTitr.getText().trim().length() == 0 || tbAjDate.getText().trim().length() == 0 || tbAjMC.getText().trim().length() == 0 ||
							tbAj2.getText().trim().length() == 0 || tbAj3.getText().trim().length() == 0) {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
					}
					else {
						String titre = tbAjTitr.getText().trim();
						LocalDate date = LocalDate.parse(tbAjDate.getText().trim(), formatter);
						String motsCles = tbAjMC.getText().trim();
						int noVolume = Integer.parseInt(tbAj2.getText().trim());
						int noPeriodique = Integer.parseInt(tbAj3.getText().trim());
						
						Periodique per = new Periodique("DVD" + Catalogue.getInstance().getCompteurIdPer(),titre, date, true, noVolume, noPeriodique, motsCles);
						Catalogue.getInstance().addLstDocuments(per);
						Catalogue.getInstance().addLstPeriodiques(per);
						donneesDoc.add(per);
						donneesPerio.add(per);
						tbAjTitr.clear();
						tbAjDate.clear();
						tbAj2.clear();
						tbAj3.clear();
						stage3.close();
						Optional<ButtonType> retour = afficherBoiteInfo(29);
					}
				}
			}
			
//			SUPPRIMER DOCUMENT CATALOGUE
			if(e.getSource() == btnSupprCata) {
				Document doc = tableCatalogue.getSelectionModel().getSelectedItem();
				if(doc != null) {
					donneesDoc.remove(doc);
					Catalogue.getInstance().getLstDoc().remove(doc);
					String type = TypeDocument(doc.getNoDoc());
					switch(type) {
					case "lvr":
						donneesLivres.remove(doc);
						Catalogue.getInstance().getLstLvr().remove(doc);
						break;
					case "dvd":
						donneesDvd.remove(doc);
						Catalogue.getInstance().getLstDvd().remove(doc);
						break;
					default:
						donneesPerio.remove(doc);
						Catalogue.getInstance().getLstPer().remove(doc);
					}
					Optional<ButtonType> retour = afficherBoiteInfo(30);
				}
				else {
					Optional<ButtonType> retour = afficherBoiteInfo(23);
				}
			}

		}
	}
	
	public Optional<ButtonType> afficherBoiteInfo(int cas) {
		Alert alert=null;
		
		switch (cas) {
		case 0:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Information manquante");
			alert.setHeaderText("");
			alert.setContentText("Veuillez remplir la case de nom et pr�nom ou le num�ro de t�l�phone pour vous "
					+ "identifier.");
			break;
		case 1:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Format invalide");
			alert.setHeaderText("");
			alert.setContentText("Veuillez assurer que le num�ro de t�l�phone soit compos� de 14 caract�res.");
			break;
		case 8:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Information manquante");
			alert.setHeaderText("");
			alert.setContentText("Veuillez assurer toutes les cases soient remplies.");
			break;
		case 9:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Connection effectu�e");
			alert.setHeaderText("");
			alert.setContentText("Vous �tes connect�s � votre dossier.");
			break;
		case 10:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Connection effectu�e");
			alert.setHeaderText("");
			alert.setContentText("Vous �tes connect�s comme ADMINISTRATEUR.");
			break;
		case 11:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Recherche");
			alert.setHeaderText("");
			alert.setContentText("Veuillez assurer que la case de recherche soit remplie.");
			break;
		case 12:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Connexion impossible");
			alert.setHeaderText("");
			alert.setContentText("La connexion n'a pu �tre faite. Assurez-vous que les informations que vous rentrez correspondent � celles de votre compte");
			break;
		case 13:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Enregistr�");
			alert.setHeaderText("");
			alert.setContentText("L'Adh�rant a �t� correctement ajout�");
			break;
		case 14:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Enregistr�");
			alert.setHeaderText("");
			alert.setContentText("Le pr�pos� a �t� correctement ajout�");
			break;
		case 15:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Document ou Adh�rant inexistant");
			alert.setHeaderText("");
			alert.setContentText("Le num�ro de document ou l'id d'adh�rant que vous avez tapp� n'existe pas dans la base de donn�e");
			break;
		case 16:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Nombre emprunt maximum");
			alert.setHeaderText("");
			alert.setContentText("Le nombre d'emprunt maximum pour ce type de document a d�j� �t� atteint");
			break;
		case 17:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Amende");
			alert.setHeaderText("");
			alert.setContentText("Cet adh�rant a une amende non-pay�e");
			break;
		case 18:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Emprunt");
			alert.setHeaderText("");
			alert.setContentText("Le pr�t a �t� correctement ajouter � l'adh�rant");
			break;
		case 19:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Emprunt");
			alert.setHeaderText("");
			alert.setContentText("Le document est indisponible");
			break;
		case 20:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Retour");
			alert.setHeaderText("");
			alert.setContentText("Le document a bien �t� retourner");
			break;
		case 21:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Retour");
			alert.setHeaderText("");
			alert.setContentText("L'amende a �t� pay�e et le document a bien �t� retourner");
			break;
		case 22:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Amende");
			alert.setHeaderText("");
			alert.setContentText("L'adh�rant n'a pas d'amende � payer");
			break;
		case 23:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Aucune s�lection");
			alert.setHeaderText("");
			alert.setContentText("Vous devez s�lectionner un objet dans la liste avant d'effectuer cette action");
			break;
		case 24:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Pr�pos�");
			alert.setHeaderText("");
			alert.setContentText("La modification sur le pr�pos� s'est bien ex�cut�e");
			break;
		case 25:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Num�ro T�l�phone");
			alert.setHeaderText("");
			alert.setContentText("Le num�ro de t�l�phone doit �tre sous le format (***) ***-****");
			break;
		case 26:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Pr�pos�");
			alert.setHeaderText("");
			alert.setContentText("Le pr�pos� a bien �t� supprim�");
			break;
		case 27:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Adh�rant");
			alert.setHeaderText("");
			alert.setContentText("L'adh�rant a bien �t� supprim�");
			break;
		case 28:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Adherant");
			alert.setHeaderText("");
			alert.setContentText("La modification sur l'adh�rant s'est bien ex�cut�e");
			break;
		case 29:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Document");
			alert.setHeaderText("");
			alert.setContentText("Le document a bien �t� ajout� au catalogue");
			break;
		case 30:
			alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Document");
			alert.setHeaderText("");
			alert.setContentText("Le document a bien �t� supprim�");
			break;
		
		default:
			break;
		}
		
		return alert.showAndWait();
	}
	
	public boolean connectedAdmin(String strID, String strMotDePasse) {
		boolean ok;
		if((strID.compareTo("admin") == 0) && (strMotDePasse.compareTo("admin") == 0)) {
			ok = true;
		}
		else {
			ok = false;
		}
		return ok;
	}
	
	public boolean connectedPrepose(String ID, String strMotDePasse) {
		boolean ok = false; 
		
		for(Prepose prep: Preposes.getInstance().getLstPreposes()) {
			if((ID.compareTo(prep.getId()) == 0) && (strMotDePasse.compareTo(prep.getMotDePasse()) == 0)) {
				ok = true;
			}
		}
		
		return ok;
	}
	
	public boolean connectedAdherant(String nom, String prenom, String tel) {
		boolean ok = false;
		
		for(Adherant adher: Adherants.getInstance().getLstAdherants()) {
			if((nom.compareTo(adher.getNom()) == 0)&&(prenom.compareTo(adher.getPrenom()) == 0)&&(tel.compareTo(adher.getNumTelephone()) == 0)) {
				ok = true;
			}
		}
		
		return ok;
	}
	
//	TROUVER SI LE DOCUMENT ET L'ADH�RANT EXISTE
	public boolean EmpruntIdOK (String idDoc, String idAdher) {
		boolean ok;
		boolean adhe = false;
		boolean doc = false;
		
		for(Adherant adher: Adherants.getInstance().getLstAdherants()) {
			if(idAdher.compareTo(adher.getStrId()) == 0) {
				adhe = true;
			}
		}
		
		for(Document document : Catalogue.getInstance().getLstDoc()) {
			if(idDoc.compareTo(document.getNoDoc()) == 0) {
				doc = true;
			}
		}
		
		ok = adhe & doc;
		
		return ok;
	}
	
//	TROUVER LE TYPE DE DOCUMENT EMPRUNTER
	public String TypeDocument(String idDoc) {
		String type = "";
		
		for(Document document: Catalogue.getInstance().getLstDvd()) {
			if(idDoc.compareTo(document.getNoDoc()) == 0) {
				type = "dvd";
			}
		}
		
		for(Document document: Catalogue.getInstance().getLstLvr()) {
			if(idDoc.compareTo(document.getNoDoc()) == 0) {
				type = "lvr";
			}
		}
		
		for(Document document : Catalogue.getInstance().getLstPer()) {
			if(idDoc.compareTo(document.getNoDoc()) == 0) {
				type = "per";
			}
		}
		
		return type;
	}
	
//	TROUVER LE NOMBRE DE PR�T D'UN M�ME TYPE DE DOCUMENT
	public int NombreEmprunter(String idAdher, String typeDoc) {
		int Compteur = 0;
		for(Adherant adher: Adherants.getInstance().getLstAdherants()) {
			for(Pret pret : adher.getLstPrets()) {
				if(typeDoc.compareTo(TypeDocument(pret.getNoDoc())) == 0) {
					Compteur++;
				}
			}
		}
		
		return Compteur;
	}
	
// TROUVER UN ADHERANT A PARTIR DE SON ID	
	public Adherant getAdherant(String idAdher) {
		Adherant adher = null;
		for(Adherant adherant: Adherants.getInstance().getLstAdherants()) {
			if(idAdher.compareTo(adherant.getStrId()) == 0) {
				adher = adherant;
			}
		}
		return adher;
	}
	
//	TROUVER UN DOCUMENT A PARTIR DE SON ID
	public Document getDoc(String idDoc) {
		Document doc = null;
		for(Document document: Catalogue.getInstance().getLstDoc()) {
			if(idDoc.compareTo(document.getNoDoc()) == 0) {
				doc = document;
			}
		}
		return doc;
	}
	
//	TROUVER UN PREPOSE A PARTIR DE SON ID
	public Prepose getPrepose(String idPrep) {
		Prepose prep = null;
		for(Prepose prepose: Preposes.getInstance().getLstPreposes()) {
			if(idPrep.compareTo(prepose.getId()) == 0) {
				prep = prepose;
			}
		}
		return prep;
	}
	
//	TROUVER ADHERANT A PARTIR DE SON NOM, SON PRENOM ET SON TELEPHONE
	public Adherant getAdherant(String nom, String prenom, String tel) {
		Adherant adher = null;
		
		for(Adherant adherant: Adherants.getInstance().getLstAdherants()) {
			if((nom.compareTo(adherant.getNom()) == 0)&&(prenom.compareTo(adherant.getPrenom()) == 0)&&(tel.compareTo(adherant.getNumTelephone()) == 0)) {
				adher = adherant;
			}
		}
		System.out.println(adher);
		return adher;
	}
	
// 	CALCUL DES AMENDES
	public void calculAmendes() {
		for (Adherant adher: Adherants.getInstance().getLstAdherants()) {
			for (Pret pret: adher.getLstPrets()) {
				long differenceDate = LocalDate.now().toEpochDay() - pret.getDateEmprunt().toEpochDay();
				String typeDoc = TypeDocument(pret.getNoDoc());
				
				switch(typeDoc) {
				case "lvr":
					if(differenceDate <= 14) {
						long jourRetard = differenceDate - 14;
						pret.setAmende((Double) 0.5 * jourRetard);
					}
					break;
				case "dvd":
					if(differenceDate <= 7) {
						long jourRetard = differenceDate - 7;
						pret.setAmende((Double) 0.5 * jourRetard);
					}
					break;
				default:
					if(differenceDate <= 3) {
						long jourRetard = differenceDate - 3;
						pret.setAmende((Double) 0.5 * jourRetard);
					}
					break;
				}
			}
		}
		System.out.println("Les amendes ont �t�s calcul�es");
	}

}	// FIN DE LA CLASSE