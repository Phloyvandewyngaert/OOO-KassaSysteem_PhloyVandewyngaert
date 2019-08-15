package controller;

import java.io.FileNotFoundException;

public interface Observer {
    // opgeroepen door Observable

    void update(Observable o)throws FileNotFoundException;
    }
