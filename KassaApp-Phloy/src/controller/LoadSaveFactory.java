package controller;

import model.db.LoadSaveExcelStrategy;
import model.db.LoadSaveStrategy;
import model.db.LoadSaveTxtStrategy;

import java.io.File;
import java.io.FileNotFoundException;


public class LoadSaveFactory {

    private LoadSaveStrategy l;
    public LoadSaveStrategy createLoadSave(String type) {


        switch (type.toLowerCase()) {
            case "xls":
                l = new LoadSaveExcelStrategy();
                break;
            case "txt":
                l = new LoadSaveTxtStrategy();
                break;
            default:
                throw new IllegalArgumentException("verkeerde bestandstype");
        }
        return l;
    }

    public File getFile () throws FileNotFoundException {
        File f;

        if (l instanceof LoadSaveExcelStrategy){
            f = new File("artikel.xls");
        }else if(l instanceof LoadSaveTxtStrategy){
            f = new File ("artiekel.txt");
        }else throw new FileNotFoundException("somthing whent wrong");
        return f;
    }

}
