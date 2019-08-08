package model.db;

import controller.Observer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class InMemArtDb implements Observer {


    public Map<String, List<String>> getArtiekels() throws FileNotFoundException {
        Map<String, List<String>> artikeles = new HashMap<>();
        String key = "";

        // pad naar bestand
        File art = new File("artiekel.txt");
        Scanner scanner = new Scanner(art);

        while (scanner.hasNextLine()) {
            List<String> values = new ArrayList<>();
            String[] line = scanner.nextLine().split(","); // elke lijn in een array steken

            key = line[0]; // key = eerste element van de array
            String omschrijving = line[1];
            String groep = line[2];
            String prijs = line[3];
            String voorraad = line[4];

            values.add(omschrijving);
            values.add(groep);
            values.add(prijs);
            values.add(voorraad);

            artikeles.put(key,values); // map maken
        }
        return artikeles;
    }

    @Override
    public void updateOmschrijving(String code, String omschrijving) throws FileNotFoundException{
        if(this.getArtiekels().containsKey(code)) {//als die art wel bestaat

          List<String> values = this.getArtiekels().get(code);  //nieuwe list het artiekel van die code
          values.set(0,omschrijving);// omschrijving veranderen
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }

    }

    @Override
    public void updateGroep(String code, String groep) throws FileNotFoundException {
        if(this.getArtiekels().containsKey(code)) {

            List<String> values = this.getArtiekels().get(code);
            values.set(1,groep);
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }
    }

    @Override
    public void updatePijs(String code, double prijs) throws FileNotFoundException{
        if(this.getArtiekels().containsKey(code)) {
        String price = ""+ prijs;
            List<String> values = this.getArtiekels().get(code);
            values.set(2,price);
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }
    }

    @Override
    public void updateVoorraad(String code, int voorraad) throws FileNotFoundException{
        if(this.getArtiekels().containsKey(code)) {

            String q = "" + voorraad;
            List <String> values = this.getArtiekels().get(code);
            values.set(3,q);
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }
    }
}
