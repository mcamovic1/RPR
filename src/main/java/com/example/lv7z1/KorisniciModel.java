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
    public void dodaj(Korisnik k){
        korisnici.add(k);
    }
    public void napuni(){
        korisnici.add(new Korisnik("Ana","Anic","aanic@gmail.com","aanic","AnaAnic"));
        korisnici.add(new Korisnik("Mila","Milic","mmilic45@gmail.com","mila_m","MilaMilic"));
        korisnici.add(new Korisnik("Ivan","Ivanovic","ivanovic@gmail.com","ivan_ovic","IvanIvanovic"));
    }
}