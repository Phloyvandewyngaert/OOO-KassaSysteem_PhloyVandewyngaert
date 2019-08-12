package ui.view.panels;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.view.tab.ArtTab;
import ui.view.tab.InstellingenTab;

import java.io.FileNotFoundException;

public class KassaView {
	private Stage stage = new Stage();		
		
	public KassaView() throws FileNotFoundException {
		stage.setTitle("KASSA VIEW");
		stage.setResizable(false);		
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 750, 500);

		Controller c = new Controller();
		ArtTab at = new ArtTab(c);
		InstellingenTab it = new InstellingenTab();
		BorderPane borderPane = new KassaMainPane(at, it);

		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
