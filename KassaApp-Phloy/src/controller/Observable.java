package controller;

import java.io.FileNotFoundException;

public interface Observable {

    void addObserver(Observer o);
    void removerObserver(Observer o);
    void notifyObersver() throws FileNotFoundException;
}
