package org.example;

import java.util.ArrayList;
import java.util.List;

public class Banka {
    private long brojRacuna;
    List<Korisnik> korisnici;
    List<Uposlenik> uposlenici;

    public Banka() {
        brojRacuna=1;
        korisnici=new ArrayList<>();
        uposlenici=new ArrayList<>();
    }
    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        var k=new Korisnik(ime,prezime);
        korisnici.add(k);
        return k;
    }
    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        var u=new Uposlenik(ime,prezime);
        uposlenici.add(u);
        return u;
    }
    public Racun kreirajRacunZaKorisnika(Korisnik k){
           brojRacuna+=1;
           return new Racun(brojRacuna,k);
    }
}
