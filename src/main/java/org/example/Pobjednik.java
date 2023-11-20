package org.example;

public class Pobjednik {
    private String ime, prezime;
    private int brojZnakova;
    private KolekcijaImena kolekcijaImena;
    Pobjednik(KolekcijaImena kolekcijaImena){
         var n=kolekcijaImena.getNajduzi();
         brojZnakova=n.length();
         this.kolekcijaImena=kolekcijaImena;
         String[] niz=n.split(" ");
         ime=niz[0];
         prezime=niz[1];
    }

    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public int getBrojZnakova() {
        return brojZnakova;
    }

}
