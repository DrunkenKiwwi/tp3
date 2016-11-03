package tp2_fxml.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tp2_fxml.controleur.ControleurForme;

public class AppTp2 extends Application  {

	private BorderPane borderp = null;
	private ControleurForme AT = null;

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Logiciel de dessin");

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/tp2_fxml/vue/tp3_FXML.fxml"));
			borderp = (BorderPane) loader.load();
			AT = (ControleurForme) loader.getController();

			

			Scene scene = new Scene(borderp);
			primaryStage.setScene(scene);

			ObservableList<String> items = FXCollections.observableArrayList("Ovale", "Rectangle", "Triangle", "Ligne");
			AT.getListView().setItems(items);
			
			
			primaryStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	
}
