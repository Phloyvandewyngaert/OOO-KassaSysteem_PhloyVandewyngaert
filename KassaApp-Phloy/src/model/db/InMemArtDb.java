package model.db;

import java.io.File;
import java.util.*;

public class InMemArtDb {

    public static void main(String[] args) throws Exception
    {

        List<String> values = new ArrayList<String> ();
        String key = "";
        Map<String, List> artikeles = new HashMap<String, List>();

        // pad naar bestand
        File art = new File("src\\artiekel.txt");
        Scanner scanner = new Scanner(art);

        while (scanner.hasNextLine()) {
            values.clear(); // values eerst leeg maken
            String[] line = scanner.nextLine().split(","); // elke lijn in een array steken
            key = line[0]; // key = eerste element van de array

            if (values.isEmpty()){ // zolang values leeg is
                for (int i = 1; i < line.length; i++) {// alles behalve eerste element in de list steken
                    values.add(line[i]);
                }
            }

            artikeles.put(key,values); // map maken
        }

    }
}
