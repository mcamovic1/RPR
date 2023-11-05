package org.example;

public class Korisnik extends Osoba{
    Racun racun;
    public Korisnik(String ime, String prezime) {
        super(ime, prezime);
    }
    void dodajRacun(Racun r){racun=r;}

}
