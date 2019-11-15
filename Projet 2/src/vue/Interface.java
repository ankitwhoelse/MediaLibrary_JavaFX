package vue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import modele.Adherant;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import modele.Comptes;
import modele.DVD;
import modele.DeserialisationCatalogue;
import modele.Document;
import modele.Livre;
import modele.Prepose;
import modele.Periodique;
import modele.Pret;
import modele.SerialisationCatalogue;

public class Interface extends Application{

	BorderPane root, root2;
	Button btnConn, btnBiblio, btnCons, btnSearch, btnAjoutUtil, btnAjoutCata, btnConfirmU, btnSeConnecter;
	TextField txtPrenom, txtNom, txtTel, txtRecherche, tbModifU, tbID;
	Text txt1, txt2, txt3, txt4, txtA, txtT, txtN, txtP;
	TextField tbAjTitr, tbAjDate, tbAjMC, tbAj2, tbAj3, tbAj4, tbN, tbP, tbA, tbT;
	Text txtAjTitr, txtAjDate, txtAjMC, txtAj2, txtAj3, txtAj4;
	CheckBox cbConn;
	RadioButton rbAuteur, rbMotsCles, rbAjoutL, rbAjoutD, rbAjoutP, rbModifAdr, rbModifTel, rbAjoutAdh, rbAjoutPre;
	Scene scene, scene2, scene3, scene4;
	Stage stage2, stage3, stage4;
	Tab tabAdher, tabPrets, tabPrepo, tabUtil;
	int Connexion = 0;

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
			
			txt3 = new Text("Votre prénom:");
			gPane.add(txt3, 0, 2);
			txtPrenom = new TextField("");
			txtPrenom.setPrefWidth(100);
			txtPrenom.setMinWidth(100);
			gPane.add(txtPrenom, 1, 2);
			
			txt4 = new Text("Votre numéro de téléphone:");
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
			btnBiblio.setText("Consulter la médiathèque");
			btnBiblio.setOnAction(gc);
			btnBiblio.setPrefHeight(255);
			btnBiblio.setMinWidth(255);
			btnBiblio.setPrefHeight(33);
			btnBiblio.setMaxHeight(33);

			cbConn = new CheckBox();
			cbConn.setText("Préposé/Admin");
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
			
			TabPane tabPane = new TabPane();
			VBox vBox2 = new VBox();
			vBox2.setSpacing(10);
			VBox.setMargin(vBox2, new Insets(10));
			
			HBox hBoxSearch = new HBox();
			hBoxSearch.setAlignment(Pos.CENTER_LEFT);
			hBoxSearch.setSpacing(10);
			HBox.setMargin(hBoxSearch, new Insets(5));
			Text txtSearch = new Text("Recherche par: ");
			VBox.setMargin(hBoxSearch, new Insets(5));
			
			ToggleGroup tgSearch = new ToggleGroup();
			rbAuteur = new RadioButton();
			rbAuteur.setText("auteur");
			rbMotsCles = new RadioButton();
			rbMotsCles.setText("mots clés");
			tgSearch.getToggles().addAll(rbAuteur, rbMotsCles);
			
			txtRecherche = new TextField("");
			txtRecherche.setPrefWidth(100);
			txtRecherche.setMinWidth(100);
			
			btnSearch = new Button();
			btnSearch.setText("Rechercher");
			btnSearch.setOnAction(gc);
			
			hBoxSearch.getChildren().addAll(txtSearch, rbAuteur, rbMotsCles, txtRecherche, btnSearch);
			
			HBox hBoxCata = new HBox();
			hBoxCata.setSpacing(15);
			
			Catalogue cata = Catalogue.getCatalogue();
			cata = DeserialisationCatalogue.getDeseriaCata();
			
//				onglet documents
			Tab tabDoc = new Tab();
			tabDoc.setClosable(false);
			tabDoc.setText("Documents");
//			tabDoc.setGraphic(new ImageView(new Image("icon-collection.png")));
			
			final TableView<Document> tableDoc = new TableView<Document>();
			TableColumn<Document, String> colonneNum1 = new TableColumn<Document, String> ("Numéro");
			TableColumn<Document, String> colonneTitre1 = new TableColumn<Document, String> ("Titre");
			TableColumn<Document, LocalDate> colonneParution1 = new TableColumn<Document, LocalDate> ("Date de parution");
			TableColumn<Document, String> colonneDispo1 = new TableColumn<Document, String> ("Disponible");
			tableDoc.getColumns().addAll(colonneNum1, colonneTitre1, colonneParution1, colonneDispo1);
			
			colonneNum1.setPrefWidth(120);			colonneNum1.setMaxWidth(120);
			colonneTitre1.setPrefWidth(120);			colonneTitre1.setMaxWidth(120);
			colonneParution1.setPrefWidth(120);			colonneParution1.setMaxWidth(120);
			colonneDispo1.setPrefWidth(120);			colonneDispo1.setMaxWidth(120);

			ArrayList<Document> lstDocs = cata.getLstDoc();
			final ObservableList<Document> donneesDoc = FXCollections.observableArrayList(lstDocs);
			colonneNum1.setCellValueFactory(new PropertyValueFactory<Document, String>("noDoc"));
			colonneTitre1.setCellValueFactory(new PropertyValueFactory<Document, String>("titre"));
			colonneParution1.setCellValueFactory(new PropertyValueFactory<Document, LocalDate>("dateParution"));
			colonneDispo1.setCellValueFactory(new PropertyValueFactory<Document, String>("disponible"));			
			tableDoc.setItems(donneesDoc);
			
			tabDoc.setContent(tableDoc);
			
			
	//			onglet dvd
			Tab tabDvd = new Tab();
			tabDvd.setClosable(false);
			tabDvd.setText("DVD");
//			tabDoc.setGraphic(new ImageView(new Image("icon-dvd.png")));
			
			final TableView<DVD> tableDvd = new TableView<DVD>();
			TableColumn<DVD, String> colonneNum2 = new TableColumn<DVD, String> ("Numéro");
			TableColumn<DVD, String> colonneTitre2 = new TableColumn<DVD, String> ("Titre");
			TableColumn<DVD, LocalDate> colonneParution2 = new TableColumn<DVD, LocalDate> ("Date de parution");
			TableColumn<DVD, String> colonneDispo2 = new TableColumn<DVD, String> ("Disponible");
			TableColumn<DVD, Integer> colonneDisk = new TableColumn<DVD, Integer> ("Nombre de disques");
			TableColumn<DVD, String> colonneRealis = new TableColumn<DVD, String> ("Réalisateur");
			tableDvd.getColumns().addAll(colonneNum2, colonneTitre2, colonneParution2, colonneDispo2, colonneDisk, colonneRealis);
			
			colonneNum2.setPrefWidth(120);			colonneNum2.setMaxWidth(120);
			colonneTitre2.setPrefWidth(120);			colonneTitre2.setMaxWidth(120);
			colonneParution2.setPrefWidth(120);			colonneParution2.setMaxWidth(120);
			colonneDispo2.setPrefWidth(120);			colonneDispo2.setMaxWidth(120);
			colonneDisk.setPrefWidth(120);			colonneDisk.setMaxWidth(120);
			colonneRealis.setPrefWidth(120);			colonneRealis.setMaxWidth(120);
			
			final ObservableList<DVD> donneesDvd = FXCollections.observableArrayList(cata.getLstDvd());
			colonneNum2.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
			colonneTitre2.setCellValueFactory(new PropertyValueFactory<>("titre"));
			colonneParution2.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			colonneDispo2.setCellValueFactory(new PropertyValueFactory<>("disponible"));
			colonneDisk.setCellValueFactory(new PropertyValueFactory<>("nbDisques"));
			colonneRealis.setCellValueFactory(new PropertyValueFactory<>("strRealisateur"));
			tableDvd.setItems(donneesDvd);
			
			tabDvd.setContent(tableDvd);
			
						
	//			onglet livre
			Tab tabLivre = new Tab();
			tabLivre.setClosable(false);
			tabLivre.setText("Livre");
	//		tabDoc.setGraphic(new ImageView(new Image("icon-livre.png")));
			
			final TableView<Livre> tableLivre = new TableView<Livre>();
			TableColumn<Livre, String> colonneNum3 = new TableColumn<Livre, String> ("Numéro");
			TableColumn<Livre, String> colonneTitre3 = new TableColumn<Livre, String> ("Titre");
			TableColumn<Livre, LocalDate> colonneParution3 = new TableColumn<Livre, LocalDate> ("Date de parution");
			TableColumn<Livre, String> colonneDispo3 = new TableColumn<Livre, String> ("Disponible");
			TableColumn<Livre, Integer> colonneMCle = new TableColumn<Livre, Integer> ("Mots clés");
			TableColumn<Livre, String> colonneAuteur = new TableColumn<Livre, String> ("Auteur");
			tableLivre.getColumns().addAll(colonneNum3, colonneTitre3, colonneParution3, colonneDispo3, colonneMCle, colonneAuteur);
			
			colonneNum3.setPrefWidth(120);			colonneNum3.setMaxWidth(120);
			colonneTitre3.setPrefWidth(120);			colonneTitre3.setMaxWidth(120);
			colonneParution3.setPrefWidth(120);			colonneParution3.setMaxWidth(120);
			colonneDispo3.setPrefWidth(120);			colonneDispo3.setMaxWidth(120);
			colonneMCle.setPrefWidth(120);			colonneMCle.setMaxWidth(120);
			colonneAuteur.setPrefWidth(120);			colonneAuteur.setMaxWidth(120);
			
			final ObservableList<Livre> donneesLives = FXCollections.observableArrayList(cata.getLstLvr());
			colonneNum3.setCellValueFactory(new PropertyValueFactory<Livre, String>("noDoc"));
			colonneTitre3.setCellValueFactory(new PropertyValueFactory<Livre, String>("titre"));
			colonneParution3.setCellValueFactory(new PropertyValueFactory<Livre, LocalDate>("dateParution"));
			colonneDispo3.setCellValueFactory(new PropertyValueFactory<Livre, String>("disponible"));
			colonneMCle.setCellValueFactory(new PropertyValueFactory<Livre, Integer>("motsCles"));
			colonneAuteur.setCellValueFactory(new PropertyValueFactory<Livre, String>("auteur"));
			tableLivre.setItems(donneesLives);
			
			tabLivre.setContent(tableLivre);
			
			
	//			onglet periodique
			Tab tabPerio = new Tab();
			tabPerio.setClosable(false);
			tabPerio.setText("Périodique");
	//		tabDoc.setGraphic(new ImageView(new Image("icon-livre.png")));
			
			final TableView<Periodique> tablePerio = new TableView<Periodique>();
			TableColumn<Periodique, String> colonneNum4 = new TableColumn<Periodique, String> ("Numéro");
			TableColumn<Periodique, String> colonneTitre4 = new TableColumn<Periodique, String> ("Titre");
			TableColumn<Periodique, LocalDate> colonneParution4 = new TableColumn<Periodique, LocalDate> ("Date de parution");
			TableColumn<Periodique, String> colonneDispo4 = new TableColumn<Periodique, String> ("Disponible");
			TableColumn<Periodique, Integer> colonneVol = new TableColumn<Periodique, Integer> ("Numéro de volume");
			TableColumn<Periodique, Integer> colonnePerio = new TableColumn<Periodique, Integer> ("Numéro de périodique");
			tablePerio.getColumns().addAll(colonneNum4, colonneTitre4, colonneParution4, colonneDispo4, colonneVol, colonnePerio);
			
			colonneNum4.setPrefWidth(120);			colonneNum4.setMaxWidth(120);
			colonneTitre4.setPrefWidth(120);			colonneTitre4.setMaxWidth(120);
			colonneParution4.setPrefWidth(120);			colonneParution4.setMaxWidth(120);
			colonneDispo4.setPrefWidth(120);			colonneDispo4.setMaxWidth(120);
			colonneVol.setPrefWidth(120);			colonneVol.setMaxWidth(120);
			colonnePerio.setPrefWidth(130);			colonnePerio.setMaxWidth(130);
			
			final ObservableList<Periodique> donneesPerio = FXCollections.observableArrayList(cata.getLstPer());
			colonneNum4.setCellValueFactory(new PropertyValueFactory<Periodique, String>("noDoc"));
			colonneTitre4.setCellValueFactory(new PropertyValueFactory<Periodique, String>("titre"));
			colonneParution4.setCellValueFactory(new PropertyValueFactory<Periodique, LocalDate>("dateParution"));
			colonneDispo4.setCellValueFactory(new PropertyValueFactory<Periodique, String>("disponible"));
			colonneVol.setCellValueFactory(new PropertyValueFactory<Periodique, Integer>("noVolume"));
			colonnePerio.setCellValueFactory(new PropertyValueFactory<Periodique, Integer>("noPeriodique"));
			tablePerio.setItems(donneesPerio);
			
			tabPerio.setContent(tablePerio);
			
			tabUtil = new Tab();
			tabPrepo = new Tab();
			tabAdher = new Tab();
			tabPrets = new Tab();
			
			Comptes acc = new Comptes();
			
			if (true) {			// if logged in comme adher	
			//			onglet compte
				tabAdher.setClosable(false);
				tabAdher.setText("Compte");
				
				VBox vBoxUtil = new VBox();
			
				Text txtUtil = new Text();
				txtUtil.setText("Utilisateur: ");	// ajoute + nom du adherant
				VBox.setMargin(txtUtil, new Insets(10));
				
				vBoxUtil.getChildren().addAll(txtUtil);
				tabAdher.setContent(vBoxUtil);
			}
			if (true) {			// if logged in comme admin	ou prepose
			//			onglet utilisateurs
				tabUtil.setClosable(false);
				tabUtil.setText("Utilisateurs");
				
				HBox hBoxUtil = new HBox();
				hBoxUtil.setSpacing(20);
				hBoxUtil.setPadding(new Insets(10));
								
				final TableView<Adherant> tableUtilisateurs = new TableView<Adherant>();
				TableColumn<Adherant, String> colonneId = new TableColumn<Adherant, String> ("ID");
				TableColumn<Adherant, String> colonneNom = new TableColumn<Adherant, String>("Nom");
				TableColumn<Adherant, String> colonnePrenom = new TableColumn<Adherant, String>("Prenom");
				TableColumn<Adherant, String> colonneNumTel = new TableColumn<Adherant, String>("Numero Tel");
				TableColumn<Adherant, String> colonneAdresse = new TableColumn<Adherant, String>("Adresse");
				tableUtilisateurs.getColumns().addAll(colonneId, colonneNom, colonnePrenom, colonneNumTel, colonneAdresse);
				
				final ObservableList<Adherant> donneesAdh = FXCollections.observableArrayList(acc.getLstAdherant());
				colonneId.setCellValueFactory(new PropertyValueFactory<Adherant, String> ("id"));
				colonneNom.setCellValueFactory(new PropertyValueFactory<Adherant, String>("nom"));
				colonnePrenom.setCellValueFactory(new PropertyValueFactory<Adherant, String>("prenom"));
				colonneNumTel.setCellValueFactory(new PropertyValueFactory<Adherant, String>("numTelephone"));
				colonneAdresse.setCellValueFactory(new PropertyValueFactory<Adherant, String>("adresse"));
				tableUtilisateurs.setItems(donneesAdh);
							
				GridPane gbModifU = new GridPane();
				gbModifU.setHgap(5);
				gbModifU.setVgap(5);
				Text txtModif1 = new Text("Actions sur utilisateurs");
				btnAjoutUtil = new Button("Ajouter");
				btnAjoutUtil.setOnAction(gc);
				Button btnSupprUtil = new Button("Supprimer");
				Text txtModif2 = new Text("Modification");
				ToggleGroup tgModif = new ToggleGroup();
				rbModifAdr = new RadioButton("Adresse");
				rbModifAdr.setOnAction(gc);
				rbModifTel = new RadioButton("Numero Telephone");
				rbModifTel.setOnAction(gc);
				tgModif.getToggles().addAll(rbModifAdr, rbModifTel);
				
//					FENÈTRE MODALE POUR AJOUTER UN UTILISATEUR
					VBox vBoxAjU1 = new VBox();
					VBox.setMargin(vBoxAjU1, new Insets(20));
					vBoxAjU1.setPadding(new Insets(10));
					
					Text txtAjU1 = new Text("Type de utilisateur");
					ToggleGroup tgAjoutCata = new ToggleGroup();
					rbAjoutAdh = new RadioButton("Adhérant");
					rbAjoutAdh.setOnAction(gc);
					rbAjoutAdh.setSelected(true);
					rbAjoutPre = new RadioButton("Préposé");
					rbAjoutPre.setOnAction(gc);
					tgAjoutCata.getToggles().addAll(rbAjoutAdh,rbAjoutPre);
					
					HBox hBoxAjU1 = new HBox();
					hBoxAjU1.getChildren().addAll(rbAjoutAdh, rbAjoutPre);
					hBoxAjU1.setSpacing(25);
					
					GridPane gpAddUser = new GridPane();
					gpAddUser.setHgap(5);
					gpAddUser.setVgap(5);
					Text txtId = new Text("ID");
					tbID = new TextField();
					tbID.setDisable(true);
					txtP = new Text("Prénom");
					tbP = new TextField();
					txtN = new Text("Nom");
					tbN = new TextField();
					txtA = new Text("Adresse");
					tbA = new TextField();
					txtT = new Text("Téléphone");
					tbT = new TextField();
					
					gpAddUser.add(txtId, 0, 0);					gpAddUser.add(tbID, 1, 0);
					gpAddUser.add(txtP, 0, 1);					gpAddUser.add(tbP, 1, 1);
					gpAddUser.add(txtN, 0, 2);					gpAddUser.add(tbN, 1, 2);
					gpAddUser.add(txtA, 0, 3);					gpAddUser.add(tbA, 1, 3);
					gpAddUser.add(txtT, 0, 4);					gpAddUser.add(tbT, 1, 4);
					
					HBox hBoxAjU2 = new HBox();
					Button btnUserConfir = new Button("Confirmer");
					btnUserConfir.setOnAction(e -> {
						if (tbN.getText().length()==0 || tbP.getText().length()==0 ||
							tbA.getText().length()==0 || tbT.getText().length()==0) {
						Optional<ButtonType> retour = afficherBoiteInfo(8);
//						else {
//							
//						}
						}});
					
					Button btnUserQuit = new Button("Annuler");
					btnUserQuit.setOnAction(e -> stage4.close());
					hBoxAjU2.getChildren().addAll(btnUserConfir, btnUserQuit);
					hBoxAjU2.setSpacing(15);
					vBoxAjU1.getChildren().addAll(txtAjU1, hBoxAjU1, gpAddUser, hBoxAjU2);
					vBoxAjU1.setSpacing(10);
					
					scene4 = new Scene(vBoxAjU1, 350, 250);
					stage4 = new Stage();
					stage4.setScene(scene4);
					stage4.setTitle("Ajouter un utilisateur");
					stage4.initModality(Modality.APPLICATION_MODAL);
				
				tbModifU = new TextField();
				tbModifU.setDisable(true);
				btnConfirmU = new Button("Confirmer");
				btnConfirmU.setDisable(true);
				
				gbModifU.add(txtModif1, 0, 0, 2, 1);
				gbModifU.add(btnAjoutUtil, 0, 1, 1, 1);				gbModifU.add(btnSupprUtil, 1, 1, 1, 1);
				gbModifU.add(txtModif2, 0, 2, 2, 1);
				gbModifU.add(rbModifAdr, 0, 3, 1, 1);				gbModifU.add(rbModifTel, 1, 3, 1, 1);
				gbModifU.add(tbModifU, 0, 4, 2, 1);
				gbModifU.add(btnConfirmU, 0, 5, 2, 1);
				
				hBoxUtil.getChildren().addAll(tableUtilisateurs, gbModifU);
				tabUtil.setContent(hBoxUtil);
			}
			
			if (true) {			// if logged in comme preposé
			//			onglet catalogue
				tabPrepo.setClosable(false);
				tabPrepo.setText("Catalogue");
				
				HBox hBoxCatal = new HBox();
				hBoxCatal.setSpacing(20);
				hBoxCatal.setPadding(new Insets(10));
				
				final TableView<Document> tableCatalogue = new TableView<Document>();
				TableColumn<Document, String> colonneNo = new TableColumn<Document, String> ("No Doc");
				TableColumn<Document, String> colonneTi = new TableColumn<Document, String>("Titre");
				TableColumn<Document, LocalDate> colonneDP = new TableColumn<Document, LocalDate>("Date parution");
				TableColumn<Document, String> colonneNumDi = new TableColumn<Document, String>("Disponibilite");
				tableCatalogue.getColumns().addAll(colonneNo, colonneTi, colonneDP, colonneNumDi);
				
				final ObservableList<Document> donneesCata = FXCollections.observableArrayList(cata.getLstDoc());
				colonneNo.setCellValueFactory(new PropertyValueFactory<Document, String> ("noDoc"));
				colonneTi.setCellValueFactory(new PropertyValueFactory<Document, String>("titre"));
				colonneDP.setCellValueFactory(new PropertyValueFactory<Document, LocalDate>("dateParution"));
				colonneNumDi.setCellValueFactory(new PropertyValueFactory<Document, String>("disponible"));
				tableCatalogue.setItems(donneesCata);
				
				
				
				GridPane gbModifC = new GridPane();
				gbModifC.setHgap(5);
				gbModifC.setVgap(5);
				Text txtModif2 = new Text("Actions sur le catalogue");
				btnAjoutCata = new Button("Ajouter");
				btnAjoutCata.setOnAction(gc);
				Button btnSupprCata = new Button("Supprimer");
				
				gbModifC.add(txtModif2, 0, 0, 2, 1);
				gbModifC.add(btnAjoutCata, 0, 1, 1, 1);				gbModifC.add(btnSupprCata, 1, 1, 1, 1);
				
				hBoxCatal.getChildren().addAll(tableCatalogue, gbModifC);
				tabPrepo.setContent(hBoxCatal);
			}
			
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
					rbAjoutP = new RadioButton("Périodique");
					rbAjoutP.setOnAction(gc);
					tgAjoutCata.getToggles().addAll(rbAjoutL,rbAjoutD,rbAjoutP);
				
					txtAjTitr = new Text("Titre");
					tbAjTitr = new TextField();
					txtAjDate = new Text("Date de parution");
					tbAjDate = new TextField();
					txtAjMC = new Text("Mots Clés (séparé par virgule)");
					tbAjMC = new TextField();
					
					txtAj2 = new Text("Auteur");
					tbAj2 = new TextField();
					txtAj3 = new Text();
					txtAj3.setVisible(false);
					tbAj3 = new TextField();
					tbAj3.setVisible(false);
					
					Button btnCataConfir = new Button("Confirmer");
					Button btnCataQuit = new Button("Annuler");
					btnCataQuit.setOnAction(e -> stage3.close());
					
					GridPane gpAj = new GridPane();
					gpAj.setHgap(5);
					gpAj.setVgap(5);
					gpAj.add(txtAjTitr, 0, 0);					gpAj.add(tbAjTitr, 1, 0);
					gpAj.add(txtAjDate, 0, 1);					gpAj.add(tbAjDate, 1, 1);
					gpAj.add(txtAjMC, 0, 2);					gpAj.add(tbAjMC, 1, 2);
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
			
			if (true) {			// if logged in comme prep/admin
			//		onglet prêts
				HBox hBoxPret = new HBox();
				hBoxPret.setPadding(new Insets(10));
				hBoxPret.setSpacing(20);
				tabPrets.setClosable(false);
				tabPrets.setText("Prêts");
//				tabDoc.setGraphic(new ImageView(new Image("icon-collection.png")));
				
				final TableView<Pret> tablePrets = new TableView<Pret>();
				TableColumn<Pret, String> colonneEmpr = new TableColumn<Pret, String> ("Date d'emprunt");
				TableColumn<Pret, String> colonneEmprID = new TableColumn<Pret, String> ("ID de l'adhérant");
				TableColumn<Pret, String> colonneNum5 = new TableColumn<Pret, String> ("ID du document");
				TableColumn<Pret, String> colonneRetour = new TableColumn<Pret, String> ("Date de retour");
				TableColumn<Pret, Number> colonneAmende = new TableColumn<Pret, Number> ("Amende");
				tablePrets.getColumns().addAll(colonneEmpr, colonneEmprID, colonneNum5, colonneRetour,colonneAmende);
				
				colonneEmpr.setPrefWidth(120);				colonneEmpr.setMaxWidth(120);
				colonneEmprID.setPrefWidth(120);				colonneEmprID.setMaxWidth(120);
				colonneNum5.setPrefWidth(120);				colonneNum5.setMaxWidth(120);
				colonneRetour.setPrefWidth(120);				colonneRetour.setMaxWidth(120);
				colonneAmende.setPrefWidth(120);				colonneAmende.setMaxWidth(120);

				final ObservableList<Pret> donneesPrets = FXCollections.observableArrayList(Pret.getLstPrets());
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
				
				Text txtEmprID = new Text("ID de l'adhérant");
				TextField tbEmprID = new TextField();
				tbEmprID.setMaxWidth(50);
				tbEmprID.setPrefWidth(50);
				Button btnRetourner = new Button("Inscrire un retour");
				Button btnEmprunter = new Button("Inscrire un prêt");
				Button btnPayer = new Button("Payer une amende");
				Text txtEmprDocID = new Text("Doc ID:");
				TextField tbEmprDocID = new TextField();
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
			
			tabPane.getTabs().addAll(tabDoc, tabDvd, tabLivre, tabPerio, tabAdher, tabPrets, tabPrepo, tabUtil);

			HBox hBoxBtn = new HBox();
			
			Button btnQuit = new Button();
			btnQuit.setText("Quitter");
			btnQuit.setOnAction(e -> {stage2.close(); primaryStage.close(); 
				SerialisationCatalogue.serialiseCata();});
			HBox.setMargin(btnQuit, new Insets(10));
			
			Button btnFermer = new Button();
			btnFermer.setText("Fermer le catalogue");
			btnFermer.setOnAction(e -> stage2.close());
			HBox.setMargin(btnFermer, new Insets(10));
					
			hBoxBtn.getChildren().addAll(btnQuit, btnFermer);
			vBox2.getChildren().addAll(hBoxSearch, tabPane, hBoxBtn);
			root2.setCenter(vBox2);
				
			
//					< / INTERFACE DE CATALOGUE >
//			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public class GestionClick implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e) {
			if (e.getSource() == btnCons) {
				//	IDENTIFICATION CAS OÙ LES CASES SONT VIDES
				
				if ( txtNom.getLength()==0 && txtPrenom.getLength()==0 && txtTel.getLength()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(0);
					txtNom.requestFocus();
				} else if (txtNom.getText().trim().length()!=0 && txtPrenom.getText().trim().length()!=0 && cbConn.isSelected()) {
					if((txtNom.getText().trim().compareTo("admin")==0) && (txtPrenom.getText().trim().compareTo("admin")==0)) {
						Optional<ButtonType> retour = afficherBoiteInfo(10);
						tabAdher.setDisable(false);			// L'admin a toute les options
						tabPrepo.setDisable(false);
						tabPrets.setDisable(false);
						tabUtil.setDisable(false);
						stage2.showAndWait();	
					}
					else if(connectedPrepose(txtNom.getText().trim(), txtPrenom.getText().trim())){
						Optional<ButtonType> retour = afficherBoiteInfo(9);
						tabAdher.setDisable(false);			// Le préposé a toutes les options pour l'instant
						tabPrepo.setDisable(false);
						tabPrets.setDisable(false);
						tabUtil.setDisable(false);
						stage2.showAndWait();
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(12);
						txtNom.requestFocus();
					}
				} else if (txtTel.getLength()!=10 && (txtNom.getText().trim().length()==0 && txtPrenom.getText().trim().length()==0)) {
					Optional<ButtonType> retour = afficherBoiteInfo(1);
					txtTel.requestFocus();
//					CAS OÙ CONNECTION EST BONNE
				} else if ((txtNom.getLength()!=0 && txtPrenom.getLength()!=0) && txtTel.getLength()==10 && !cbConn.isSelected()) {
					if(connectedAdherant(txtNom.getText().trim(), txtPrenom.getText().trim(), txtTel.getText().trim())) {
						Optional<ButtonType> retour = afficherBoiteInfo(9);
						tabAdher.setDisable(false);			// Lorsqu'il est connecté l'adhérant
						tabPrepo.setDisable(true);			// ne peut accèder qu'aux informations
						tabPrets.setDisable(true);			// de son compte et au catalogue
						tabUtil.setDisable(true);
						stage2.showAndWait();
					}
					else {
						Optional<ButtonType> retour = afficherBoiteInfo(12);
						txtNom.requestFocus();
					}
				} 
			}
			
//				BOUTON CONSULTER LA MÉDIATHÈQUE
			if (e.getSource() == btnBiblio) {
				tabAdher.setDisable(true);			// Lorsque l'utilisateur n'est pas 
				tabPrepo.setDisable(true);			// connecté sur aucun compte il n'a 
				tabPrets.setDisable(true);			// accès a rien d'autre que le catalogue
				tabUtil.setDisable(true);
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
				txt3.setText("Votre prénom:");
				txtNom.clear();
				txtPrenom.clear();
				txtTel.clear();
				txtNom.requestFocus();
			}	
			
//				BOUTTON DE AJOUTER UTILISATEUR
			if (e.getSource() == btnAjoutUtil) {
				stage4.showAndWait();
			}
		
//				ENSEMBLE DE RADIO BUTTONS DE AJOUT DE UTILISATEURS
			if (rbAjoutAdh.isSelected()) {
				txtP.setText("Prénom"); tbID.setDisable(true);
				tbN.setVisible(true); tbA.setVisible(true); tbT.setVisible(true);
				txtN.setVisible(true); txtA.setVisible(true); txtT.setVisible(true);
			} else if (rbAjoutPre.isSelected()) {
				txtP.setText("Mot de passe"); tbID.setDisable(false);
				tbN.setVisible(false); tbA.setVisible(false); tbT.setVisible(false);
				txtN.setVisible(false); txtA.setVisible(false); txtT.setVisible(false);
			}
			
//				ENSEMBLE DE RADIO BUTTON DE MODIFICATION DES INFORMATIONS DES UTILISATEURS
			if (rbModifAdr.isSelected()) {
				tbModifU.setDisable(false);
				btnConfirmU.setDisable(false);
			} else if (rbModifTel.isSelected()) {
				tbModifU.setDisable(false);
				btnConfirmU.setDisable(false);
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
				txtAj2.setText("Réalisateur"); txtAj3.setText("Nombre de disques");
				txtAj2.setVisible(true); tbAj2.setVisible(true);txtAj3.setVisible(true); tbAj3.setVisible(true);
			} else if (rbAjoutP.isSelected()) {
				txtAj2.setText("Numéro de volume"); txtAj3.setText("Numéro de périodique");
				txtAj2.setVisible(true); tbAj2.setVisible(true);txtAj3.setVisible(true); tbAj3.setVisible(true);
			}
	
//				BOUTON SE CONNECTER ADHERANT DANS CATALOGUE
			if(e.getSource() == btnSeConnecter) {
				
			}
			
			
			
			if (e.getSource() == btnSearch) {
				if (txtRecherche.getLength()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(11);
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
			alert.setContentText("Veuillez remplir la case de nom et prénom ou le numéro de téléphone pour vous "
					+ "identifier.");
			break;
		case 1:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Format invalide");
			alert.setHeaderText("");
			alert.setContentText("Veuillez assurer que le numéro de téléphone soit composé de 10 caractères.");
			break;
		case 8:
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Information manquante");
			alert.setHeaderText("");
			alert.setContentText("Veuillez assurer toutes les cases soient remplies.");
			break;
		case 9:
			alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Connection effectuée");
			alert.setHeaderText("");
			alert.setContentText("Vous êtes connectés à votre dossier.");
			break;
		case 10:
			alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Connection effectuée");
			alert.setHeaderText("");
			alert.setContentText("Vous êtes connectés comme ADMINISTRATEUR.");
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
			alert.setContentText("La connexion n'a pu être faite. Assurez-vous que les informations que vous rentrez correspondent à celles de votre compte");
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
		Comptes comptes = new Comptes();
		boolean ok = false; 
		
		for(Prepose prep: comptes.getLstPrepose()) {
			if((ID.compareTo(prep.getId()) == 0) && (strMotDePasse.compareTo(prep.getMotDePasse()) == 0)) {
				ok = true;
			}
		}
		
		return ok;
	}
	
	public boolean connectedAdherant(String nom, String prenom, String tel) {
		Comptes comptes = new Comptes();
		boolean ok = false;
		
		for(Adherant adher: comptes.getLstAdherant()) {
			if((nom.compareTo(adher.getNom()) == 0)&&(prenom.compareTo(adher.getPrenom()) == 0)&&(tel.compareTo(adher.getNumTelephone()) == 0)) {
				ok = true;
			}
		}
		
		return ok;
	}
	
	

}	// FIN DE LA CLASSE
