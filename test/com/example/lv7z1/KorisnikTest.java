package com.example.lv7z1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisnikTest {
    Korisnik k=new Korisnik();
    @Test
    void setIme() {
        assertEquals("",k.getIme());
        k.setIme("Ana");
        assertEquals("Ana",k.getIme());
    }

    @Test
    void setPrezime() {
        assertEquals("",k.getPrezime());
        k.setPrezime("Anic");
        assertEquals("Anic",k.getPrezime());
    }

    @Test
    void setEmail() {
        assertEquals("",k.getEmail());
        k.setEmail("aanic@gmail.com");
        assertEquals("aanic@gmail.com",k.getEmail());
    }

    @Test
    void setKorisnicko_ime() {
        assertEquals("",k.getKorisnicko_ime());
        k.setKorisnicko_ime("aanic");
        assertEquals("aanic",k.getKorisnicko_ime());
    }
}