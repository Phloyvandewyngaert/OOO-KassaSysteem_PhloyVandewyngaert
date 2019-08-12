package ui.view.tab;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableView;

import java.io.FileNotFoundException;

public class ArtTab extends GridPane {

    private TableView kader;
    private Controller controller;

    public ArtTab (Controller controller) throws FileNotFoundException {
        this.controller = controller;
        this.setPadding(new Insets(5,5,5,5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Artikelen"),0,0,1,1);

        TableColumn code = new TableColumn<>("code");
        code.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn omschrijving = new TableColumn<>("omschrijving");
        omschrijving.setCellValueFactory(new PropertyValueFactory<>("omschrijving"));

        TableColumn groep = new TableColumn<>("groep");
        groep.setCellValueFactory(new PropertyValueFactory<>("groep"));

        TableColumn prijs = new TableColumn<>("prijs");
        prijs.setCellValueFactory(new PropertyValueFactory<>("prijs"));

        TableColumn voorraad = new TableColumn<>("voorraad");
        voorraad.setCellValueFactory(new PropertyValueFactory<>("voorraad"));

        kader = new TableView<String>();
        kader.setPrefWidth(REMAINING);
        kader.setItems(controller.getArtiekelen());
        kader.getColumns().addAll(code,omschrijving,groep,prijs,voorraad);
        kader.getSortOrder().add(omschrijving);

        this.add(kader, 0, 1, 2, 6);
    }
}
