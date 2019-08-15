package model.db;

import controller.Observer;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadSaveExcelStrategy implements LoadSaveStrategy{// adapter

    private ExcelPlugin excelPlugin;

    public LoadSaveExcelStrategy() {
        this.excelPlugin = new ExcelPlugin();
    }

    @Override
    public void save(File file, ArrayList<ArrayList<String>> args) throws WriteException, IOException, BiffException {
        excelPlugin.write(file,args);
    }

    @Override
    public Map<String, List<String>> load(File file) {
        System.out.println("XLS");
        String key;
        Map<String, List<String>> artiekels = new HashMap<>();
        List<String> values;

        try {
            for (List l:excelPlugin.read(file)) {
               for (int i = 0; i < l.size(); i++){
                   values = new ArrayList<>();
                   key = (String) l.get(0); // key = eerste element van de array
                   String omschrijving = (String) l.get(1);
                   String groep = (String) l.get(2);
                   String prijs = (String) l.get(3);
                   String voorraad = (String) l.get(4);

                   values.add(omschrijving);
                   values.add(groep);
                   values.add(prijs);
                   values.add(voorraad);

                   artiekels.put(key,values); // map maken
               }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return artiekels;
    }
}
