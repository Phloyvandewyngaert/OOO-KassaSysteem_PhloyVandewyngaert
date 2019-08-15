package ui.view.panels;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.view.tab.KlantenTab;

public class KlantView {
	private Stage stage = new Stage();		
		
	public KlantView(){			
		stage.setTitle("KLANT VIEW");
		stage.setResizable(false);		
		stage.setX(775);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);

		Controller c = new Controller();
		KlantenTab kt = new KlantenTab();

		BorderPane borderPane = new KlantenMainPain(kt);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);

		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
