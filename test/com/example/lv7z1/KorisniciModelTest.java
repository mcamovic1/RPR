package com.example.lv7z1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {
    KorisniciModel korisnici=new KorisniciModel();

    @Test
    void setTrenutniKorisnik() {
        Korisnik novi=new Korisnik("Ime","Prezime","Email","Korisnicko_ime","Sifra");
        korisnici.setTrenutniKorisnik(novi);
        assertEquals("Korisnicko_ime",korisnici.getTrenutniKorisnik().getKorisnicko_ime());
    }

    @Test
    void dodaj() {
        korisnici.dodaj(new Korisnik("Ime","Prezime","Email","Korisnicko_ime","Sifra"));
        assertEquals(1,korisnici.broj());
    }

    @Test
    void napuni() {
        korisnici.napuni();
        assertEquals(3,korisnici.broj());
    }
}