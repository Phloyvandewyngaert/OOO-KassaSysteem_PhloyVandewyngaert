package controller;

import javafx.collections.ObservableList;
import model.Artiekel;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Service {

    private LoadSaveFactory loadSaveFactory;
    Controller controller;

    public Service() {
        controller = new Controller();
        loadSaveFactory = new LoadSaveFactory();
    }

    public Artiekel getArtikel (String code) throws FileNotFoundException {

        Map<String, List<String>>artiekelen;
        List<String> lijst;
        artiekelen = loadSaveFactory.createLoadSave(controller.readFromProperties()).load(loadSaveFactory.getFile());

               if(bestaandeArt(code)) {
                   lijst = artiekelen.get(code);

                   String omschrijving = lijst.get(0);
                   String groep = lijst.get(1);
                   String prijs = lijst.get(2);
                   String voorraad = lijst.get(3);

                   Artiekel a = new Artiekel();

                   a.setCode(code);
                   a.setOmschrijving(omschrijving);
                   a.setGroep(groep);
                   a.setPrijs(prijs);
                   a.setVoorraad(voorraad);

                   return a;
               }else {
                   throw new IllegalArgumentException("niet bestaande code");
               }
    }

    public boolean bestaandeArt(String code) throws FileNotFoundException {
        Map<String, List<String>> artiekelen = loadSaveFactory.createLoadSave(controller.readFromProperties()).load(loadSaveFactory.getFile());
        return artiekelen.containsKey(code);
    }

    public double getTotalPrice(ObservableList<Artiekel> artiekels){
        double totaal = 0;

        for (Artiekel a:artiekels) {
            totaal += a.getPrijs();
        }
        return totaal;
    }
}
