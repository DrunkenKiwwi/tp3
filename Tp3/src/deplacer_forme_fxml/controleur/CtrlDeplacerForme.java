package deplacer_forme_fxml.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import deplacer_forme_fxml.modele.Deplacement;
import deplacer_forme_fxml.modele.Direction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CtrlDeplacerForme {
	@FXML
	private Rectangle rectangle;

	@FXML
	private AnchorPane anchorp;

	@FXML
	private StackPane stackp;

	private Deplacement deplacement;

	private Stage stage;

	@FXML
	public void initialize() {
		deplacement = new Deplacement(0.0, 0.0);
		rectangle.xProperty().bind(deplacement.getDepx());
		rectangle.yProperty().bind(deplacement.getDepy());
		rectangle.setManaged(false);
		deplacement.start();

	}

	@FXML
	private void handletouche(KeyEvent event) {
		System.out.println("ok");
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
