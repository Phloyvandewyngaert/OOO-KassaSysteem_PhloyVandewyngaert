package ui.application;
	
import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.db.InMemArtDb;
import ui.view.panels.KassaView;
import ui.view.panels.KlantView;

import java.io.FileNotFoundException;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		KassaView kassaView = new KassaView();
		KlantView klantView = new KlantView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
