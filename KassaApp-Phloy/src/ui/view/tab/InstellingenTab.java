package ui.view.tab;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

        Label label = new Label("Ik wil mijn gegeven uithalen via een ");

        TextField text = new TextField();
        Button button = new Button("Opslagen");

        HBox hbox = new HBox(label,text,button);

        this.add(hbox, 0, 2, 1, 1);

        button.setOnMouseClicked((e) -> {
            String soort = text.getText();

            controller.writeToProperties(soort);
        });
    }
}
