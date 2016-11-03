package deplacer_forme_fxml.application;

import java.io.IOException;

import deplacer_forme_fxml.controleur.CtrlDeplacerForme;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppDeplacerForme extends Application {

	private CtrlDeplacerForme CDF = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/deplacer_forme_fxml/vue/VueDeplacerForme.fxml"));

		AnchorPane root = (AnchorPane) loader.load();
		CDF = loader.getController();

		Scene scene = new Scene(root);
		
		
		stage.setTitle("Déplacer Forme");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}
}
