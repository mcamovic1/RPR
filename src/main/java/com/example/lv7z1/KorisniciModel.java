package com.example.lv7z1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici;
    Korisnik trenutniKorisnik;
    KorisniciModel(){
        korisnici=FXCollections.observableArrayList();
        trenutniKorisnik=new Korisnik();
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }
    public void napuni(Korisnik k){
        korisnici.add(k);
    }
}