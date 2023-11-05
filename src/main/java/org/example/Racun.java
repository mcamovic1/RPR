package org.example;

public class Racun {
    long brojRacuna;
    Osoba korisnikRacuna;
    boolean odobrenjePrekoracenja;
    double stanjeRacuna;
    double prekoracenje;
    public Racun(long br, Osoba k){brojRacuna=br; korisnikRacuna=k;}
    private boolean provjeriOdobrenjePrekoracenja (double n){
        return this.prekoracenje>n;
    }
    public boolean izvrsiUplatu (double br){
        stanjeRacuna+=br;
        return true;
    }
    public boolean izvrsiIsplatu (double br){
       if(stanjeRacuna+prekoracenje>br){stanjeRacuna-=br; return true; }
       return false;
    }
    public void OdobriPrekoracenje(double n){
        odobrenjePrekoracenja=true;
         prekoracenje=n;
    }
}
