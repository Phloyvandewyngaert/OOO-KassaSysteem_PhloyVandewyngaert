package ui.view.tab;

import controller.Observable;
import controller.Observer;
import controller.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class KassaTab extends GridPane implements Observer {

    private Service service;
    private TableView<Artiekel> kader;
    private TextField codeTextField;
    private Label codeLabel;
    private Button bevestig;
    private Button delete;
    private Label error;
    private Label totaal;

    public KassaTab() throws FileNotFoundException {
        this.service = new Service();
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);


        codeLabel = new Label("Artiekel code ");
        codeTextField = new TextField();
        bevestig = new Button("bevestig");
        delete = new Button("delete");
        error = new Label("Deze code bestaat niet");
        error.setVisible(false);
        totaal = new Label();
        kader = new TableView<>();
        this.kader.setPrefWidth(REMAINING);
        TableColumn omschrijving = new TableColumn<>("omschrijving");
        omschrijving.setCellValueFactory(new PropertyValueFactory<>("omschrijving"));
        TableColumn prijs = new TableColumn<>("prijs");
        prijs.setCellValueFactory(new PropertyValueFactory<>("prijs"));
        kader.getColumns().addAll(omschrijving, prijs);

        HBox hbox = new HBox(codeLabel, codeTextField, bevestig, error, delete);
        this.add(hbox, 0, 2, 1, 1);


        bevestig.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                totaal.setText("");
                totaal.setText("Totaal " + service.getTotalPriceFromObList());
                String artCode = codeTextField.getText();

                try {
                    if (!service.bestaandeArt(artCode)) {
                        error.setVisible(true);
                    }
                    error.setVisible(false);
                    //artiekel toevoegen
                    kader.setItems(service.addArtToObList(artCode));
                    VBox vbox = new VBox(kader, totaal);

                    add(vbox, 0, 6, 2, 2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    error.setVisible(true);
                }
            }
        });

        delete.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                String artCode = codeTextField.getText();

                try {
                    if (!service.bestaandeArt(artCode)) {
                        error.setVisible(true);
                    }
                    error.setVisible(false);

                    kader.setItems(service.deleteArtiekel(artCode));

                    totaal.setText("Totaal " + service.getTotalPriceFromObList());

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

    @Override
    public void update(Observable o) throws FileNotFoundException {
        if (o instanceof Service) {
                //updateArticleOverviewTable(o);
            }
        }

    }
