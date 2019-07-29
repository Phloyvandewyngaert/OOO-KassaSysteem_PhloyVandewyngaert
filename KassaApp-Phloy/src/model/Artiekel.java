package model;

public class Artiekel {

    private int code;
    private String omschijving, groep;
    private double prijs;
    private int voorraad;

    public Artiekel() {
    }

    public Artiekel(int code, String omschijving, String groep, double prijs, int voorraad) {
        this.setCode(code);
        this.setOmschijving(omschijving);
        this.setGroep(groep);
        this.setPrijs(prijs);
        this.setVoorraad(voorraad);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        if(code <= 0 ) throw new IllegalArgumentException("code mag niet negatief zijn");
        this.code = code;
    }

    public String getOmschijving() {
        return omschijving;
    }

    public void setOmschijving(String omschijving) {
        if(omschijving.trim().isEmpty()) throw new IllegalArgumentException("omschrijving mag iet leeg zijn");
        this.omschijving = omschijving;
    }

    public String getGroep() {
        return groep;
    }

    public void setGroep(String groep) {
        if(groep.trim().isEmpty()) throw new IllegalArgumentException("groep mag iet leeg zijn");
        this.groep = groep;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        if(prijs <= 0 ) throw new IllegalArgumentException("prijs mag niet negatief zijn");
        this.prijs = prijs;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        if(voorraad <= 0 ) throw new IllegalArgumentException("voorraad mag niet negatief zijn");
        this.voorraad = voorraad;
    }
}
