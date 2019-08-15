package ui.application;
	
import controller.Controller;
import controller.LoadSaveFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.view.panels.KassaView;
import ui.view.panels.KlantView;

import java.io.File;

public class Main extends Application {
	private LoadSaveFactory f = new LoadSaveFactory();
	private Controller c = new Controller();

	@Override
	public void start(Stage primaryStage) throws Exception{
		//gegevens inlezen
		f.createLoadSave(c.readFromProperties());

		KassaView kassaView = new KassaView();
		KlantView klantView = new KlantView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
