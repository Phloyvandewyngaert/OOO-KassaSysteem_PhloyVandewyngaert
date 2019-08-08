package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Artiekel;
import model.db.InMemArtDb;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {

    private InMemArtDb artieken;

    //getAllArticles
    public ObservableList<Artiekel> getArtiekelen() throws FileNotFoundException {
        artieken = new InMemArtDb();

        ObservableList<Artiekel>artiekels = FXCollections.observableArrayList();

        artieken.getArtiekels().forEach((key, value) -> {
            ArrayList<String> test = new ArrayList<String>();

            try {// Artikel maken adhv key + value in de map

                String code = key;
                String omschrijving = value.get(0);
                String groep = value.get(1);
                String prijs = value.get(2);
                String voorraad = value.get(3);

                Artiekel a = new Artiekel();

                a.setCode(code);
                a.setOmschrijving(omschrijving);
                a.setGroep(groep);
                a.setPrijs(prijs);
                a.setVoorraad(voorraad);

                artiekels.add(a);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        return artiekels;
    }
}
