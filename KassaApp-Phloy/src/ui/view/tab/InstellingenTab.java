package ui.view.tab;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.Properties;

public class InstellingenTab extends GridPane{
    private Controller controller;

    public InstellingenTab() {
        this.controller = new Controller();
        this.setPadding(new Insets(5,5,5,5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Ik wil mijn gegeven uithalen via een "), 0, 0, 1, 1);

        TextField text = new TextField();
        Button button = new Button("Opslagen");

        VBox vbox = new VBox(text,button);

        this.add(vbox, 0, 2, 1, 1);

        button.setOnMouseClicked((e) -> {
            String soort = text.getText();

            controller.writeToProperties(soort);
        });
    }
}
