package deplacer_forme_fxml.controleur;

import java.io.IOException;

import deplacer_forme_fxml.modele.Deplacement;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CtrlDeplacerForme {
	@FXML
	private Rectangle rectangle;

	@FXML
	private StackPane stackp;
	
	private Deplacement deplacement;

	private Stage stage;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("VueDeplacerForme.fxml"));

			stackp = (StackPane) loader.load();

			Scene scene = new Scene(stackp);

			stage.setTitle("Déplacer Forme");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void handletouche(KeyEvent event) {
		KeyCode code = event.getCode();
		switch (code) {
		case UP:
			rectangle.yProperty().bind();
			break;
		case DOWN:
			rectangle.yProperty().bind();
			break;
		case LEFT:
			rectangle.xProperty().bind();
			break;
		case RIGHT:
			rectangle.xProperty().bind();
			break;
		default:
			break;
		}
	}
}
