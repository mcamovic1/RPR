package org.example;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ImenikTestMocking {
         @Test
        public void testDajBrojKoristenjemMock() {
            HashMap<String, TelefonskiBroj> mockMapa = mock(HashMap.class);

            Imenik imenik = new Imenik(mockMapa);

            FiksniBroj fiksniBroj = new FiksniBroj(Grad.SARAJEVO, "123-456");
            imenik.dodaj("Osoba1", fiksniBroj);

            when(mockMapa.get("Osoba1")).thenReturn(fiksniBroj);

            assertEquals("033/123-456", imenik.dajBroj("Osoba1"));
        }
    @Test
    public void testIzGradaKoristenjemMock() {
        HashMap<String, TelefonskiBroj> mockMapa = mock(HashMap.class);

        Imenik imenik = new Imenik(mockMapa);

        FiksniBroj fiksniBroj1 = new FiksniBroj(Grad.SARAJEVO, "123-456");
        FiksniBroj fiksniBroj2 = new FiksniBroj(Grad.SARAJEVO, "789-012");
        MobilniBroj mobilniBroj = new MobilniBroj(61, "345-678");

        imenik.dodaj("Ana", fiksniBroj1);
        imenik.dodaj("Maja", fiksniBroj2);
        imenik.dodaj("Melisa", mobilniBroj);

        Set<Map.Entry<String, TelefonskiBroj>> mockSet = null;
        when(mockMapa.entrySet()).thenReturn(mockSet);

        Set<String> rezultat = null;
        try {
            rezultat = imenik.izGrada(Grad.SARAJEVO);
        } catch (NijePronadjenNijedan e) {
            throw new RuntimeException(e);
        }
        assertTrue(rezultat.contains("Ana"));
        assertTrue(rezultat.contains("Maja"));
        assertFalse(rezultat.contains("Melisa"));
    }

}
