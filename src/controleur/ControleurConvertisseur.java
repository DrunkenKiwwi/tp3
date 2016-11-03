package controleur;

import modele.Convertir;
import modele.Distance;
import modele.Poids;
import modele.TypeDistance;
import modele.TypeMesure;
import modele.TypePoids;
import modele.TypeVolume;
import modele.Volume;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControleurConvertisseur extends Application {

	private VBox root = null;
	private Scene scene = null;
	private Convertir modele = null;

	@FXML
	private RadioButton poids;
	@FXML
	private RadioButton volume;
	@FXML
	private RadioButton distance;
	@FXML
	private ComboBox<TypeMesure> listeGauche;
	@FXML
	private ComboBox<TypeMesure> listeDroite;
	@FXML
	private TextField valeurDroite;
	@FXML
	private TextField valeurGauche;
	@FXML
	private ToggleGroup boutons;
	@FXML
	private ImageView fleches;

	public ControleurConvertisseur() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"/vue/VueConvertisseur.fxml"));
		// Chargement du fichier FXML
		root = loader.load();
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Convertisseur...");
		primaryStage.show();
	}

	@FXML
	private void initialize() {
		initPoids();
		poids.setSelected(true);
	}

	private void initPoids() {
		modele = new Poids();
		listeGauche.setItems(TypePoids.getListeType());
		listeGauche.getSelectionModel().select(0);
		listeDroite.setItems(TypePoids.getListeType());
		listeDroite.getSelectionModel().select(1);
		valeurGauche.setText("0");
		valeurDroite.setText("0");
	}

	private void initVolume() {
		modele = new Volume();
		listeGauche.setItems(TypeVolume.getListeType());
		listeGauche.getSelectionModel().select(0);
		listeDroite.setItems(TypeVolume.getListeType());
		listeDroite.getSelectionModel().select(1);
		valeurGauche.setText("0");
		valeurDroite.setText("0");
	}

	private void initDistance() {
		modele = new Distance();
		listeGauche.setItems(TypeDistance.getListeType());
		listeGauche.getSelectionModel().select(0);
		listeDroite.setItems(TypeDistance.getListeType());
		listeDroite.getSelectionModel().select(1);
		valeurGauche.setText("0");
		valeurDroite.setText("0");
	}

	@FXML
	private void changerTypeConvertion(ActionEvent event) {
		if (event.getSource() == poids) {
			initPoids();
		} else if (event.getSource() == volume) {
			initVolume();
		} else if (event.getSource() == distance) {
			initDistance();
		}
	}

	@FXML
	private void changerListeGauche() {
		try {
			if ((listeGauche.getValue() != null)
					&& (listeDroite.getValue() != null)) {
				valeurGauche.setText(modele.getVersUnite(modele.setVersBase(
						Double.parseDouble(valeurDroite.getText()),
						listeDroite.getValue()), listeGauche.getValue())
						+ "");
			}
		} catch (NumberFormatException e) {
		}
	}

	@FXML
	private void editerValeurGauche(KeyEvent event) {
		try {
			valeurDroite.setText(modele.getVersUnite(modele.setVersBase(
					Double.parseDouble(valeurGauche.getText()),
					listeGauche.getValue()), listeDroite.getValue())
					+ "");
		} catch (NumberFormatException e) {
		}
	}

	@FXML
	private void changerListeDroite() {
		try {
			if ((listeGauche.getValue() != null)
					&& (listeDroite.getValue() != null)) {
				valeurDroite.setText(modele.getVersUnite(modele.setVersBase(
						Double.parseDouble(valeurGauche.getText()),
						listeGauche.getValue()), listeDroite.getValue())
						+ "");
			}
		} catch (NumberFormatException e) {
		}
	}

	@FXML
	private void editerValeurDroite(KeyEvent event) {
		try {
			valeurGauche.setText(modele.getVersUnite(modele.setVersBase(
					Double.parseDouble(valeurDroite.getText()),
					listeDroite.getValue()), listeGauche.getValue())
					+ "");
		} catch (NumberFormatException e) {
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
