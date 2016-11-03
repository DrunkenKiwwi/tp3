package deplacer_forme_fxml.controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import deplacer_forme_fxml.modele.Deplacement;
import deplacer_forme_fxml.modele.Direction;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CtrlDeplacerForme extends Application implements Initializable {
	@FXML
	private Rectangle rectangle;

	@FXML
	private AnchorPane stackp;

	private Deplacement deplacement;

	private Stage stage;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) {

		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/deplacer_forme_fxml/vue/VueDeplacerForme.fxml"));

			stackp = (AnchorPane) loader.load();

			Scene scene = new Scene(stackp);

			stage.setTitle("D�placer Forme");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rectangle.layoutXProperty().bind(deplacement.getDepx());
		rectangle.layoutYProperty().bind(deplacement.getDepy());

	}

	@FXML
	private void handletouche(KeyEvent event) {
		KeyCode code = event.getCode();
		switch (code) {
		case UP:
			deplacement.setDirection(Direction.HAUT);
			break;
		case DOWN:
			deplacement.setDirection(Direction.BAS);
			break;
		case LEFT:
			deplacement.setDirection(Direction.GAUCHE);
			break;
		case RIGHT:
			deplacement.setDirection(Direction.DROITE);
			break;
		case ESCAPE:
			deplacement.setDirection(Direction.ESCAPE);
		default:
			break;
		}
	}

}
