package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class Controller {

    public void writeToProperties(String s){
        Properties prop = new Properties();

        // set key and value
        prop.setProperty("type", s);

        File file = new File("KassaApp-Phloy/propertiesFile");
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

        File file = new File("KassaApp-Phloy/propertiesFile");
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
