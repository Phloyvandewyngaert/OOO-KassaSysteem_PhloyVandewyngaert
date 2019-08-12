package ui.view.tab;

import controller.Controller;
import controller.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Artiekel;

import java.io.FileNotFoundException;

public class KassaTab extends GridPane {

    private Service service;
    private TableView kader;
    private ObservableList<Artiekel> artiekels = FXCollections.observableArrayList();

    public KassaTab() {
        this.service = new Service();
        this.setPadding(new Insets(5,5,5,5));
        this.setVgap(5);
        this.setHgap(5);

        Label label = new Label("Artiekel code ");
        TextField text = new TextField();
        Button button = new Button("bevestig");

        Label error = new Label("Deze code bestaat niet");
        error.setVisible(false);

        HBox hbox = new HBox(label,text,button,error);

        this.add(hbox, 0, 2, 1, 1);

        Label totaal = new Label();

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                totaal.setText("");
                String code = text.getText();

                try {
                    if (!service.bestaandeArt(code)) {
                       error.setVisible(true);
                    }

                    error.setVisible(false);
                    TableColumn omschrijving = new TableColumn<>("omschrijving");
                    omschrijving.setCellValueFactory(new PropertyValueFactory<>("omschrijving"));

                    TableColumn prijs = new TableColumn<>("prijs");
                    prijs.setCellValueFactory(new PropertyValueFactory<>("prijs"));

                    kader = new TableView<String>();
                    kader.setPrefWidth(REMAINING);
                    //try {
                        artiekels.add(service.getArtikel(code));
                        kader.setItems(artiekels);
                    //} catch (FileNotFoundException e1) {
                      //  e1.printStackTrace();
                   // }
                    kader.getColumns().addAll(omschrijving, prijs);

                    totaal.setText("Totaal " + service.getTotalPrice(artiekels));

                    VBox vbox = new VBox(kader, totaal);

                    add(vbox, 0, 6, 2, 2);
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IllegalArgumentException e) {
                    error.setVisible(true);
                }
            }
        });
    }
}
