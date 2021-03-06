package convertisseur_fxml.controleur;

import convertisseur_fxml.modele.Convertir;
import convertisseur_fxml.modele.Distance;
import convertisseur_fxml.modele.Poids;
import convertisseur_fxml.modele.TypeDistance;
import convertisseur_fxml.modele.TypeMesure;
import convertisseur_fxml.modele.TypePoids;
import convertisseur_fxml.modele.TypeVolume;
import convertisseur_fxml.modele.Volume;
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

	/**
	 * Est appelée au début de l'application, pour afficher la fenêtre
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"/convertisseur_fxml/vue/VueConvertisseur.fxml"));
		// Chargement du fichier FXML
		root = loader.load();
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Convertisseur...");
		primaryStage.show();
	}

	/**
	 * Met les poids comme unités par défaut
	 */
	@FXML
	private void initialize() {
		initPoids();
		poids.setSelected(true);
	}

	/**
	 * Remplit les listes avec les unités de poids
	 */
	private void initPoids() {
		modele = new Poids();
		listeGauche.setItems(TypePoids.getListeType());
		listeGauche.getSelectionModel().select(0);
		listeDroite.setItems(TypePoids.getListeType());
		listeDroite.getSelectionModel().select(1);
		valeurGauche.setText("0");
		valeurDroite.setText("0");
	}

	/**
	 * Remplit les listes avec les unités de volume
	 */
	private void initVolume() {
		modele = new Volume();
		listeGauche.setItems(TypeVolume.getListeType());
		listeGauche.getSelectionModel().select(0);
		listeDroite.setItems(TypeVolume.getListeType());
		listeDroite.getSelectionModel().select(1);
		valeurGauche.setText("0");
		valeurDroite.setText("0");
	}

	/**
	 * Remplit les listes avec les unités de distance
	 */
	private void initDistance() {
		modele = new Distance();
		listeGauche.setItems(TypeDistance.getListeType());
		listeGauche.getSelectionModel().select(0);
		listeDroite.setItems(TypeDistance.getListeType());
		listeDroite.getSelectionModel().select(1);
		valeurGauche.setText("0");
		valeurDroite.setText("0");
	}

	/**
	 * Change les listes quand on clique sur un bouton radio
	 * @param event
	 */
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

	/**
	 * Change la valeur à gauche quand on change l'unité à gauche
	 */
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

	/**
	 * Change la valeur droite quand la valeur gauche est éditée
	 * @param event
	 */
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

	/**
	 * Change la valeur à droite quand on change l'unité à droite
	 */
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

	/**
	 * Change la valeur gauche quand la valeur droite est éditée
	 * @param event
	 */
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

	/**
	 * Méthode qui est exécutée quand le programme commence, qui appelle launch()
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
