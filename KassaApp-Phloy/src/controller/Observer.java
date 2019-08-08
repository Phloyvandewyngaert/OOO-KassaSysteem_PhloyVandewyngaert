package controller;

import java.io.FileNotFoundException;

public interface Observer {
    // opgeroepen door Observable

    void updateOmschrijving(String code, String omschrijving)throws FileNotFoundException;
    void updateGroep(String code, String groep)throws FileNotFoundException;
    void updatePijs(String code, double prijs)throws FileNotFoundException;
    void updateVoorraad(String code, int voorraad)throws FileNotFoundException;
}
