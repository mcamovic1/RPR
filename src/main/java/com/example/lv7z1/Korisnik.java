package com.example.lv7z1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Korisnik {
    private SimpleStringProperty ime, prezime, email, korisnicko_ime, lozinka;
    Korisnik(){
        ime=new SimpleStringProperty("");
        prezime=new SimpleStringProperty("");
        email=new SimpleStringProperty("");
        korisnicko_ime=new SimpleStringProperty("");
        lozinka=new SimpleStringProperty("");
    }
    Korisnik(String ime, String prezime, String email, String korisnicko_ime, String lozinka){
        this.ime=new SimpleStringProperty(ime);
        this.prezime=new SimpleStringProperty(prezime);
        this.email=new SimpleStringProperty(email);
        this.korisnicko_ime=new SimpleStringProperty(korisnicko_ime);
        this.lozinka=new SimpleStringProperty(lozinka);

    }
    @Override
    public String toString() {
        return korisnicko_ime.get(); // Prikazuje korisničko ime u listi
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime.get();
    }

    public SimpleStringProperty korisnicko_imeProperty() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime.set(korisnicko_ime);
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }
}
