package vue;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Connexion extends Application{

	BorderPane root;
	Button btnConn;
	Button btnBiblio;
	TextField txtPrenom;
	TextField txtNom;
	TextField txtTel;
	
	Stage stageCata;

	private BorderPane contruireInterface() {
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
		
		Text txt3 = new Text("Votre pr�nom:");
		gPane.add(txt3, 0, 2);
		txtPrenom = new TextField("");
		txtPrenom.setPrefWidth(100);
		txtPrenom.setMinWidth(100);
		gPane.add(txtPrenom, 1, 2);
		
		Text txt4 = new Text("Votre num�ro de t�l�phone:");
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
		btnBiblio.setText("Consulter la m�diath�que");
		btnBiblio.setOnAction(gc);
		btnBiblio.setPrefHeight(200);
		btnBiblio.setMinWidth(200);
		
		
		vBox.getChildren().addAll(gPane, btnConn, btnBiblio);
		root.setCenter(vBox);
		return root;
	}
	
	public class GestionClick implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent e) {
			if (e.getSource() == btnConn) {
				//	CAS O� LES CASES SONT VIDES
				if ( txtNom.getLength()==0 && txtPrenom.getLength()==0 && txtTel.getLength()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(0);
					txtNom.requestFocus();
				} else if (txtTel.getLength()!=10 && (txtNom.getLength()==0 && txtPrenom.getLength()==0)) {
					Optional<ButtonType> retour = afficherBoiteInfo(1);
					txtTel.requestFocus();
//					CAS O� CONNECTION EST BONNE
				} else if ((txtNom.getLength()!=0 && txtPrenom.getLength()!=0) && txtTel.getLength()==0) {
					Optional<ButtonType> retour = afficherBoiteInfo(10);
					
//					AJOUTE CATALOGUE STAGE BUILDER ICI OU QQPART, M�ME CLASSE
					
					
				} else {}
				
				
			}
			
			if (e.getSource() == btnBiblio) {
				
			}
			
		}
	

	}
	
	public Optional<ButtonType> afficherBoiteInfo(int cas) {
		String entete=null;
		String texte=null;
		String titre=null;
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
			alert.setContentText("Veuillez assurer que le num�ro de t�l�phone soit compos� de 10 caract�res.");
			break;
			
		case 10:
			alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Connection effectu�e");
			alert.setHeaderText("");
			alert.setContentText("Vous �tes connect�s � votre compte.");
			break;
			
		
		
		default:
			break;
		}
		
		return alert.showAndWait();
	}
	
	public void start(Stage primaryStage) {
		try {
			root = contruireInterface();
			Scene scene = new Scene(root,300,300);
			primaryStage.setTitle("Connexion");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}	// FIN DE LA CLASSE
