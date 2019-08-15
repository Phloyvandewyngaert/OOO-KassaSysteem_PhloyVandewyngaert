package model.db;

import controller.LoadSaveFactory;
import controller.Observer;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LoadSaveTxtStrategy implements LoadSaveStrategy {
    private LoadSaveFactory loadSaveFactory;

    @Override
    public Map<String, List<String>> load(File file) throws FileNotFoundException {
        System.out.println("TXT");
        Map<String, List<String>> artikeles = new HashMap<>();
        String key = "";

        // pad naar bestand
        //File art = new File("artiekel.txt");
        Scanner scanner = new Scanner(file);

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
/*
    @Override
    public void updateOmschrijving(String code, String omschrijving) throws FileNotFoundException{

        if(this.load(loadSaveFactory.getFile()).containsKey(code)) {//als die art wel bestaat

          List<String> values = this.load(loadSaveFactory.getFile()).get(code);  //nieuwe list het artiekel van die code
          values.set(0,omschrijving);// omschrijving veranderen
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }

    }

    @Override
    public void updateGroep(String code, String groep) throws FileNotFoundException {

        if(this.load(loadSaveFactory.getFile()).containsKey(code)) {

            List<String> values = this.load(loadSaveFactory.getFile()).get(code);
            values.set(1,groep);
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }
    }

    @Override
    public void updatePijs(String code, double prijs) throws FileNotFoundException{

        if(this.load(loadSaveFactory.getFile()).containsKey(code)) {
        String price = ""+ prijs;
            List<String> values = this.load(loadSaveFactory.getFile()).get(code);
            values.set(2,price);
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }
    }

    @Override
    public void updateVoorraad(String code, int voorraad) throws FileNotFoundException{

        if(this.load(loadSaveFactory.getFile()).containsKey(code)) {

            String q = "" + voorraad;
            List <String> values = this.load(loadSaveFactory.getFile()).get(code);
            values.set(3,q);
        }else{
            throw new IllegalArgumentException("deze code bestaat al");
        }
    }
*/
    @Override
    public void save(File file, ArrayList<ArrayList<String>> args) throws IOException {
        for (ArrayList<String> line: args) {
            FileWriter writer = new FileWriter(file);

            int size = args.size();
            for (int i=0;i<size;i++) {
                String str = args.get(i).toString();
                writer.write(str);
                if(i < size-1)//This prevent creating a blank like at the end of the file**
                writer.write("\n");
            }
            writer.close();
        }
        }

}
