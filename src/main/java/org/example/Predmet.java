package org.example;

public class Predmet implements Poruka{
    private String naziv;
    private String opis;
    Predmet(){naziv=" "; opis=" ";}
    Predmet(String naziv,String opis){ this.naziv=naziv; this.opis=opis;}

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    public String postavi(){return naziv+opis;}
}
