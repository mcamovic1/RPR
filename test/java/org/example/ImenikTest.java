package org.example;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    @org.junit.jupiter.api.Test
    void dodaj() {
        Imenik p=new Imenik();
        p.dodaj("Medina",new FiksniBroj(Grad.SARAJEVO,"12345"));
        p.dodaj("Ana",new FiksniBroj(Grad.TUZLA,"56789"));
        assertEquals(2,p.BrojClanova());
    }

    @org.junit.jupiter.api.Test
    void naSlovo() {
        TelefonskiBroj t=new MobilniBroj(63,"5656");
        Imenik p=new Imenik();
        p.dodaj("Ana Anic",t);
        p.dodaj("Amina Amic",t);
        String s="1.Ana Anic-063/5656"+"\n"+"2.Amina Amic-063/5656"+"\n";
        try{
            assertEquals(s,p.naSlovo('A'));
        }catch (NijePronadjenNijedan e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    void izGrada() {
    }
}