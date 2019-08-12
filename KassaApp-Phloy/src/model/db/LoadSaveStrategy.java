package model.db;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface LoadSaveStrategy {

   void save(File file, ArrayList<ArrayList<String>> args) throws WriteException, IOException, BiffException;
   Map<String, List<String>> load(File file) throws FileNotFoundException;
}
