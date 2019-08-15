package model;

import controller.Observable;
import controller.Observer;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Artiekel {

    // lijst van alle observers (users die geintresserd zijn in het weten wanneer een nieuwe artikel komt)
    private ArrayList<Observer> users = new ArrayList<Observer>();

    private String code;
    private String omschrijving, groep;
    private double prijs;
    private int voorraad;

    public Artiekel() {
    }

    public Artiekel( String code, String omschrijving, String groep, double prijs, int voorraad) throws FileNotFoundException {
        this.setCode(code);
        this.setOmschrijving(omschrijving);
        this.setGroep(groep);
        this.setPrijs(prijs);
        this.setVoorraad(voorraad);
    }

    public Artiekel(String code, String omschrijving, String groep, String prijs, String voorraad) throws FileNotFoundException {
        this.setCode(code);
        this.setOmschrijving(omschrijving);
        this.setGroep(groep);
        this.setPrijs(prijs);
        this.setVoorraad(voorraad);
    }

    public String getCode() {

        return this.code;
    }

    public void setCode(String code) throws FileNotFoundException {
        if(code.trim().isEmpty()) throw new IllegalArgumentException("code mag iet leeg zijn");
        this.code = code;
       // notifyObersver();
    }


    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        if(omschrijving.trim().isEmpty()) throw new IllegalArgumentException("omschrijving mag iet leeg zijn");
        this.omschrijving = omschrijving;
    }

    public String getGroep() {
        return groep;
    }

    public void setGroep(String groep) throws FileNotFoundException {
        if(groep.trim().isEmpty()) throw new IllegalArgumentException("groep mag iet leeg zijn");
        this.groep = groep;
        //notifyObersver();
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) throws FileNotFoundException {
        if(prijs.trim().isEmpty()) throw new IllegalArgumentException("prijs mag iet leeg zijn");
        double nieuwePrijs = Double.parseDouble(prijs);
        if(nieuwePrijs <= 0 ) throw new IllegalArgumentException("prijs mag niet negatief zijn");
        this.prijs = nieuwePrijs;
        //notifyObersver();
    }

    public void setPrijs(double prijs) throws FileNotFoundException {

        if(prijs <= 0 ) throw new IllegalArgumentException("prijs mag niet negatief zijn");
        this.prijs = prijs;
        //notifyObersver();
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(String voorraad) throws FileNotFoundException {
        if(voorraad.trim().isEmpty()) throw new IllegalArgumentException("voorraad mag iet leeg zijn");
        int nieuweVoorraad = Integer.parseInt(voorraad);
        if(nieuweVoorraad <= 0 ) throw new IllegalArgumentException("voorraad mag niet negatief zijn");
        this.voorraad = nieuweVoorraad;
        //notifyObersver();
    }

    public void setVoorraad(int voorraad) throws FileNotFoundException {

        if(voorraad <= 0 ) throw new IllegalArgumentException("voorraad mag niet negatief zijn");
        this.voorraad = voorraad;
       // notifyObersver();
    }
/*
    @Override // user toevoegen
    public void addObserver(Observer o) {
        users.add(o);
    }

    @Override // user verwijderen
    public void removerObserver(Observer o) {
        users.remove(o);
    }

    @Override // users vermelden
    public void notifyObersver() throws FileNotFoundException {
        for (Observer user : users) {

            user.updateOmschrijving(this.code, this.omschrijving);
            user.updateGroep(this.code, this.groep);
            user.updatePijs(this.code, this.prijs);
            user.updateVoorraad(this.code, this.voorraad);
        }
    }

    @Override
    public String toString() {
        return "Artiekel{" +
                ", code='" + code + '\'' +
                ", omschrijving='" + omschrijving + '\'' +
                ", groep='" + groep + '\'' +
                ", prijs=" + prijs +
                ", voorraad=" + voorraad +
                '}';
    }

    @Override
    public int compareTo(Artiekel o) {

        if(getOmschrijving().toLowerCase().equals(o.getOmschrijving().toLowerCase())){
            return 0;
        }else {
            return getOmschrijving().toLowerCase().compareTo(o.getOmschrijving().toLowerCase());
        }


    }
    */
}
