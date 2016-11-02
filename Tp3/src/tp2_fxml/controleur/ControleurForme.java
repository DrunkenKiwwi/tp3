package tp2_fxml.controleur;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tp2_fxml.exception.FormeException;
import tp2_fxml.exception.ZoneDessinException;
import tp2_fxml.modele.DataFactory;
import tp2_fxml.modele.Forme;
import tp2_fxml.modele.FormesFactory;

public class ControleurForme {

	@FXML
	private BorderPane borderp;

    @FXML
    private Canvas canevas;
	
	@FXML
	private Button butt1;

	@FXML
	private Button butt2;

	@FXML
	private Button butt3;

	@FXML
	private ListView<String> listv;

	@FXML
	private ColorPicker choiceb;

	@FXML
	private CheckBox checkb;

	@FXML
	private TextField textf3;

	@FXML
	private TextField textf4;

	@FXML
	private TextField textf;

	@FXML
	private TextField textf1;

	@FXML
	private TextField textf2;

	@FXML
	private Slider slider;
	
	private DropShadow effetShadow = new DropShadow(20, Color.BLACK);
	
	private GraphicsContext gc = canevas.getGraphicsContext2D();

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Logiciel de dessin");

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/EventHandlerDemo.fxml"));

			borderp = (BorderPane) loader.load();
			// initialize();

			Scene scene = new Scene(borderp);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			System.err.println("Error loading EventHandlerDemo.fxml!");
			e.printStackTrace();
		}
	}

	@FXML
	void genererForme(ActionEvent event) {
		// TODO
		// Caller la méthode qui nous fait une forme
		// Créer un data avec infos, formesfact avec data, data fait forme, tout
		// remonte
		DataFactory data = null;
		if (getListView().getSelectionModel().getSelectedItem().equals("Triangle")) {
			data = new DataFactory(Integer.parseInt(getTextFdata().getText()),
					Integer.parseInt(getTextF1data().getText()), Integer.parseInt(getTextF2data().getText()),
					getColorPicker().getValue(), Integer.parseInt(getTextF3data().getText()),
					Integer.parseInt(getTextF4data().getText()), getListView().getSelectionModel().getSelectedItem());
		} else {
			data = new DataFactory(Integer.parseInt(getTextFdata().getText()),
					Integer.parseInt(getTextF1data().getText()), getColorPicker().getValue(),
					Integer.parseInt(getTextF3data().getText()), Integer.parseInt(getTextF4data().getText()),
					getListView().getSelectionModel().getSelectedItem());
		}
		FormesFactory formesF = new FormesFactory(600, 600);
		try {
			Forme formedessin = formesF.getInstance(data);
			ajouterForme(data);
		} catch (FormeException e) {
			// popper fenêtre forme invalide
			Alert dialogW = new Alert(AlertType.WARNING);
			dialogW.setTitle("Error");
			dialogW.setHeaderText(null);
			dialogW.setContentText("Forme non valide");
			dialogW.showAndWait();
		} catch (ZoneDessinException e) {
			// popper fenêtre forme out of bounds

			Alert dialogW = new Alert(AlertType.WARNING);
			dialogW.setTitle("Error");
			dialogW.setHeaderText(null);
			dialogW.setContentText("Forme à l'extérieur des bordures");
			dialogW.showAndWait();
		}
	}

	public TextField getTextFdata() {
		return textf;
	}

	public TextField getTextF1data() {
		return textf1;
	}

	public TextField getTextF2data() {
		return textf2;
	}

	public TextField getTextF3data() {
		return textf3;
	}

	public TextField getTextF4data() {
		return textf4;
	}

	public ListView<String> getListView() {
		return listv;
	}

	public ColorPicker getColorPicker() {
		return choiceb;
	}

	public CheckBox getCheckbox() {
		return checkb;
	}

	@FXML
	void mettreEffet(ActionEvent event) {
		if (this.getCheckbox().isSelected()) {
			gc.applyEffect(effetShadow);
			effetShadow.setColor(Color.BLACK);
		} else {
			effetShadow.setColor(Color.TRANSPARENT);

		}
	}

	@FXML
	void resetAffichage(ActionEvent event) {
		gc.clearRect(0, 0, 600, 600);
	}

	@FXML
	void shutdown(ActionEvent event) {
		Stage stage = (Stage) borderp.getScene().getWindow();
		stage.close();

	}

	public void ajouterForme(DataFactory data) {
		String forme = data.getType();
		switch (forme) {
		case "Ligne":
			gc.setStroke(data.getCouleur());
			gc.strokeLine(data.getPosX(), data.getPosY(), data.getPosX() + data.getLargeur(),
					data.getPosY() + data.getHauteur());
			break;
		case "Ovale":
			gc.setFill(data.getCouleur());
			gc.fillOval(data.getPosX(), data.getPosY(), data.getLargeur(), data.getHauteur());
			break;
		case "Rectangle":
			gc.setFill(data.getCouleur());
			gc.fillRect(data.getPosX(), data.getPosY(), data.getLargeur(), data.getHauteur());
			break;
		case "Triangle":
			gc.setFill(data.getCouleur());
			gc.fillPolygon(data.getPointsTriangleX(), data.getPointsTriangleY(), 3);
			break;
		default:
			break;
		}
	}
	
}
