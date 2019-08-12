package ui.view.panels;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class KassaMainPane extends BorderPane {
	public KassaMainPane(Pane KassaTab, Pane ArtTab, Pane InstellingenTab){
	    TabPane tabPane = new TabPane(); 	    
        Tab kasTab = new Tab("Kassa", KassaTab);
        Tab artikelTab = new Tab("Artikelen", ArtTab);
        Tab instellingTab = new Tab("Instellingen", InstellingenTab);
        Tab logTab = new Tab("Log");
        tabPane.getTabs().add(kasTab);
        tabPane.getTabs().add(artikelTab);
        tabPane.getTabs().add(instellingTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);
	}
}
