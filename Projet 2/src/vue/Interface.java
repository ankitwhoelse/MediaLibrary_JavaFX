package vue;

import java.time.LocalDate;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Document;

public class Interface extends Application{

	BorderPane root, root2;
	Button btnConn, btnBiblio;
	TextField txtPrenom, txtNom, txtTel;
	Scene scene, scene2;
	Stage stage2;

	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) {
		try {
			
//			
//					< INTERFACE DE CONNECTION >
			root = new BorderPane();
			
			VBox vBox = new VBox();
			vBox.setPadding(new Insets(10));
			VBox.setMargin(vBox, new Insets(10));
			
			GridPane gPane = new GridPane();
			GridPane.setHalignment(gPane, HPos.LEFT);
			GridPane.setValignment(gPane, VPos.CENTER);
			gPane.setHgap(5);
			gPane.setVgap(5);
			
			Text txt1 = new Text("Identifiez vous");
			gPane.add(txt1, 0, 0);
			txt1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
			
			Text txt2 = new Text("Votre nom:");
			gPane.add(txt2, 0, 1);
			txtNom = new TextField("");
			txtNom.setPrefWidth(100);
			txtNom.setMinWidth(100);
			gPane.add(txtNom, 1, 1);
			
			Text txt3 = new Text("Votre prénom:");
			gPane.add(txt3, 0, 2);
			txtPrenom = new TextField("");
			txtPrenom.setPrefWidth(100);
			txtPrenom.setMinWidth(100);
			gPane.add(txtPrenom, 1, 2);
			
			Text txt4 = new Text("Votre numéro de téléphone:");
			gPane.add(txt4, 0, 3);
			txtTel = new TextField("");
			txtTel.setPrefWidth(100);
			txtTel.setMinWidth(100);
			gPane.add(txtTel, 1, 3);
			
			
			GestionClick gc = new GestionClick();
			btnConn = new Button();
			btnConn.setText("Connexion");
			btnConn.setOnAction(gc);
			btnConn.setPrefWidth(200);
			btnConn.setMinWidth(200);
			
			btnBiblio = new Button();
			btnBiblio.setText("Consulter la médiathèque");
			btnBiblio.setOnAction(gc);
			btnBiblio.setPrefHeight(200);
			btnBiblio.setMinWidth(200);
			
			vBox.getChildren().addAll(gPane, btnConn, btnBiblio);
			root.setCenter(vBox);
			
			scene = new Scene(root,300,300);
			primaryStage.setTitle("Connexion");
			primaryStage.setScene(scene);
			primaryStage.show();
//					< / INTERFACE DE CONNECTION >
//				
			
			
//			
//					< INTERFACE DE CATALOGUE >		
			root2 = new BorderPane();
			BorderPane.setMargin(root2, new Insets(10));
			scene2 = new Scene(root2, 800, 400);
			stage2 = new Stage();
			stage2.setScene(scene2);
			stage2.setTitle("Mediatheque");
			stage2.initModality(Modality.APPLICATION_MODAL);
			
			TabPane tabPane = new TabPane();
			VBox vBox2 = new VBox();
			vBox2.setSpacing(10);
			
			
//				onglet documents
			Tab tabDoc = new Tab();
			tabDoc.setClosable(false);
			tabDoc.setText("Documents");
//			tabDoc.setGraphic(new ImageView(new Image("icon-collection.png")));
			
			final TableView<Document> tableDoc = new TableView<Document>();
			TableColumn<Document, String> colonneNum1 = new TableColumn<Document, String> ("Numero");
			TableColumn<Document, String> colonneTitre1 = new TableColumn<Document, String> ("Titre");
			TableColumn<Document, LocalDate> colonneParution1 = new TableColumn<Document, LocalDate> ("Date de parution");
			TableColumn<Document, String> colonneDispo1 = new TableColumn<Document, String> ("Disponible");
			tableDoc.getColumns().addAll(colonneNum1, colonneTitre1, colonneParution1, colonneDispo1);
			
			colonneNum1.setPrefWidth(120);
			colonneNum1.setMaxWidth(120);
			colonneTitre1.setPrefWidth(120);
			colonneTitre1.setMaxWidth(120);
			colonneParution1.setPrefWidth(120);
			colonneParution1.setMaxWidth(120);
			colonneDispo1.setPrefWidth(120);
			colonneDispo1.setMaxWidth(120);
			tabDoc.setContent(tableDoc);
			
			
	//			onglet dvd
			Tab tabDvd = new Tab();
			tabDvd.setClosable(false);
			tabDvd.setText("DVD");
	//		tabDoc.setGraphic(new ImageView(new Image("icon-dvd.png")));
			
			final TableView<Document> tableDvd = new TableView<Document>();
			TableColumn<Document, String> colonneNum2 = new TableColumn<Document, String> ("Numero");
			TableColumn<Document, String> colonneTitre2 = new TableColumn<Document, String> ("Titre");
			TableColumn<Document, LocalDate> colonneParution2 = new TableColumn<Document, LocalDate> ("Date de parution");
			TableColumn<Document, String> colonneDispo2 = new TableColumn<Document, String> ("Disponible");
			TableColumn<Document, Integer> colonneDisk = new TableColumn<Document, Integer> ("Nombre de disque");
			TableColumn<Document, String> colonneRealis = new TableColumn<Document, String> ("Realisateur");
			tableDvd.getColumns().addAll(colonneNum2, colonneTitre2, colonneParution2, colonneDispo2, colonneDisk, colonneRealis);
			
			colonneNum2.setPrefWidth(120);
			colonneNum2.setMaxWidth(120);
			colonneTitre2.setPrefWidth(120);
			colonneTitre2.setMaxWidth(120);
			colonneParution2.setPrefWidth(120);
			colonneParution2.setMaxWidth(120);
			colonneDispo2.setPrefWidth(120);
			colonneDispo2.setMaxWidth(120);
			colonneDisk.setPrefWidth(120);
			colonneDisk.setMaxWidth(120);
			colonneRealis.setPrefWidth(120);
			colonneRealis.setMaxWidth(120);
			tabDvd.setContent(tableDvd);
			
						
	//			onglet livre
			Tab tabLivre = new Tab();
			tabLivre.setClosable(false);
			tabLivre.setText("Livre");
	//		tabDoc.setGraphic(new ImageView(new Image("icon-livre.png")));
			
			final TableView<Document> tableLivre = new TableView<Document>();
			TableColumn<Document, String> colonneNum3 = new TableColumn<Document, String> ("Numero");
			TableColumn<Document, String> colonneTitre3 = new TableColumn<Document, String> ("Titre");
			TableColumn<Document, LocalDate> colonneParution3 = new TableColumn<Document, LocalDate> ("Date de parution");
			TableColumn<Document, String> colonneDispo3 = new TableColumn<Document, String> ("Disponible");
			TableColumn<Document, Integer> colonneMCle = new TableColumn<Document, Integer> ("Mots cles");
			TableColumn<Document, String> colonneAuteur = new TableColumn<Document, String> ("Auteur");
			tableLivre.getColumns().addAll(colonneNum3, colonneTitre3, colonneParution3, colonneDispo3, colonneMCle, colonneAuteur);
			
			colonneNum3.setPrefWidth(120);
			colonneNum3.setMaxWidth(120);
			colonneTitre3.setPrefWidth(120);
			colonneTitre3.setMaxWidth(120);
			colonneParution3.setPrefWidth(120);
			colonneParution3.setMaxWidth(120);
			colonneDispo3.setPrefWidth(120);
			colonneDispo3.setMaxWidth(120);
			colonneMCle.setPrefWidth(120);
			colonneMCle.setMaxWidth(120);
			colonneAuteur.setPrefWidth(120);
			colonneAuteur.setMaxWidth(120);
			tabLivre.setContent(tableLivre);
			
			
	//			onglet periodique
			Tab tabPerio = new Tab();
			tabPerio.setClosable(false);
			tabPerio.setText("Periodique");
	//		tabDoc.setGraphic(new ImageView(new Image("icon-livre.png")));
			
			final TableView<Document> tablePerio = new TableView<Document>();
			TableColumn<Document, String> colonneNum4 = new TableColumn<Document, String> ("Numero");
			TableColumn<Document, String> colonneTitre4 = new TableColumn<Document, String> ("Titre");
			TableColumn<Document, LocalDate> colonneParution4 = new TableColumn<Document, LocalDate> ("Date de parution");
			TableColumn<Document, String> colonneDispo4 = new TableColumn<Document, String> ("Disponible");
			TableColumn<Document, Integer> colonneVol = new TableColumn<Document, Integer> ("Numero de volume");
			TableColumn<Document, Integer> colonnePerio = new TableColumn<Document, Integer> ("Numero de periodique");
			tablePerio.getColumns().addAll(colonneNum4, colonneTitre4, colonneParution4, colonneDispo4, colonneVol, colonnePerio);
			
			colonneNum4.setPrefWidth(120);
			colonneNum4.setMaxWidth(120);
			colonneTitre4.setPrefWidth(120);
			colonneTitre4.setMaxWidth(120);
			colonneParution4.setPrefWidth(120);
			colonneParution4.setMaxWidth(120);
			colonneDispo4.setPrefWidth(120);
			colonneDispo4.setMaxWidth(120);
			colonneVol.setPrefWidth(120);
			colonneVol.setMaxWidth(120);
			colonnePerio.setPrefWidth(120);
			colonnePerio.setMaxWidth(120);
			tabPerio.setContent(tablePerio);
			
			
			
			tabPane.getTabs().addAll(tabDoc, tabDvd, tabLivre, tabPerio);
			
			Button btnQuit = new Button();
			btnQuit.setText("Fermer le catalogue");
			btnQuit.setOnAction(e -> stage2.close());
					
			vBox2.getChildren().addAll(tabPane, btnQuit);
			root2.setCenter(vBox2);
			
			
//					< / INTERFACE DE CATALOGUE >
//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public class GestionClick implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e) {
			if (e.getSource() == btnConn) {
				//	CAS OÙ LES CASES SONT VIDES
				if ( txtNom.getLength()==0 && txtPrenom.getLength()==0 && txtTel.getLength()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(0);
					txtNom.requestFocus();
				} else if (txtTel.getLength()!=10 && (txtNom.getLength()==0 && txtPrenom.getLength()==0)) {
					Optional<ButtonType> retour = afficherBoiteInfo(1);
					txtTel.requestFocus();
//					CAS OÙ CONNECTION EST BONNE
				} else if ((txtNom.getLength()!=0 && txtPrenom.getLength()!=0) && txtTel.getLength()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(10);
					stage2.showAndWait();
					
					
				} else {}
				
				
			}
			
			if (e.getSource() == btnBiblio) {
				
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
			
		case 10:
			alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Connection effectuée");
			alert.setHeaderText("");
			alert.setContentText("Vous êtes connectés à votre compte.");
			break;
			
		
		
		default:
			break;
		}
		
		return alert.showAndWait();
	}
	

}	// FIN DE LA CLASSE
