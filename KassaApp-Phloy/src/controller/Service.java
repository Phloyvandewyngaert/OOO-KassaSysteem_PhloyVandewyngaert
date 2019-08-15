package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.Artiekel;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Service implements Observable {

    private LoadSaveFactory loadSaveFactory;
    private Controller controller;
    private List<Observer> observers;
    private ObservableList<Artiekel> artiekels;


    public Service() throws FileNotFoundException {
        controller = new Controller();
        loadSaveFactory = new LoadSaveFactory();
        observers = new ArrayList<>();
        artiekels = FXCollections.observableArrayList();
    }

    public ObservableList<Artiekel> addArtToObList(String code) throws FileNotFoundException {

        if(bestaandeArt(code)){
            artiekels.add(getArtikelFromBestand(code));
        }else throw new IllegalArgumentException("code bestaat niet");
        return artiekels;
    }

    public ObservableList<Artiekel> getArtiekelenObList() throws FileNotFoundException {

        ObservableList<Artiekel>artiekels = FXCollections.observableArrayList();
        //artiekelen halen uit een map
        loadSaveFactory.createLoadSave(controller.readFromProperties()).load(loadSaveFactory.getFile()).forEach((key, value) -> {


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

                artiekels.add(a);// toevoegen aan de obervable list
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        return artiekels;
    }

    public Artiekel getArtikelFromBestand(String code) throws FileNotFoundException {

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

    public double getTotalPriceFromObList(){
        double totaal = 0;

        for (Artiekel a:this.artiekels) {
            totaal += a.getPrijs();
        }
        return totaal;
    }

    public ObservableList<Artiekel> deleteArtiekel (String code) throws FileNotFoundException {
        //artiekels = FXCollections.observableArrayList();

        List<Artiekel> artList = new ArrayList<>();
        artList.addAll(artiekels);

        if(this.bestaandeArt(code)){

            Iterator i = artList.iterator();
            Artiekel art = new Artiekel();
            while (i.hasNext()) {
                art = (Artiekel) i.next();
                if (art.getCode().equals(code)) {
                    i.remove();
                    break;
                }
            }
            artiekels.clear();
            artiekels.addAll(artList);
            return  artiekels;
        }else {
                throw new IllegalArgumentException("code bestaat niet");
            }

    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removerObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObersver() throws FileNotFoundException {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
