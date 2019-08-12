package controller;

import com.sun.xml.internal.bind.util.Which;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Artiekel;
import model.db.LoadSaveTxtStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Controller {

    private LoadSaveFactory loadSaveFactory;

    //getAllArticles
    public ObservableList<Artiekel> getArtiekelen() throws FileNotFoundException {
        loadSaveFactory = new LoadSaveFactory();

        ObservableList<Artiekel>artiekels = FXCollections.observableArrayList();

        loadSaveFactory.createLoadSave(readFromProperties()).load(loadSaveFactory.getFile()).forEach((key, value) -> {
            //ArrayList<String> test = new ArrayList<String>();

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

    public void writeToProperties(String s){
        Properties prop = new Properties();

        // set key and value
        prop.setProperty("type", s);

        File file = new File("propertiesFile");
        OutputStream output = null;
        try {
            output = new FileOutputStream(file);

            // save a properties file
            prop.store(output, "File");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFromProperties() throws FileNotFoundException {

        String bestand = "";

        File file = new File("propertiesFile");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){

          String line = scanner.nextLine();
          if(!line.startsWith("#")){
              switch (line.substring(5)){
                  case "txt":
                      bestand = "txt";
                      break;
                  case "xls":
                      bestand = "xls";
                      break;
                  default:
                      throw new IllegalArgumentException("verkerde soort bestand");
              }
          }
        }

        return bestand;
    }
}
