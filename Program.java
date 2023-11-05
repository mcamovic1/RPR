package org.example;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int nastavak=1;
        Imenik imenik=new Imenik();
        while(nastavak == 1) {
            System.out.println("Unesite svoje ime i prezime");
            Scanner unos = new Scanner(System.in);
            var ime = unos.nextLine();
            System.out.println("""
                      Izaberite opciju za unos broja:
                      1.Fiksni broj
                      2.Mobilni broj
                      3.Medunarodni broj
                    """);
            int opcija = unos.nextInt();
            TelefonskiBroj br;
            if (opcija == 1) {
                System.out.println("Unesite grad:");
                Grad grad = Grad.valueOf(unos.nextLine());
                System.out.println("Unesite broj:");
                String broj = unos.nextLine();
                br = new FiksniBroj(grad, broj);
                imenik.dodaj(ime,br);
            } else if (opcija == 2) {
                System.out.println("Unesite mobilnu mrezu:");
                int mreza = unos.nextInt();
                System.out.println("Unesite broj:");
                String broj = unos.nextLine();
                br = new MobilniBroj(mreza, broj);
                imenik.dodaj(ime,br);
            } else if (opcija == 3) {
                System.out.println("Unesite drzavu:");
                String drzava = unos.nextLine();
                System.out.println("Unesite broj:");
                String broj = unos.nextLine();
                br = new MedunarodniBroj(drzava, broj);
                imenik.dodaj(ime,br);
            }
            System.out.println("Unesite 0-za prekid ili 1-za nastavak unosa");
            nastavak= unos.nextInt();
            if(nastavak==0)break;
        }
        try {
            System.out.println(imenik.naSlovo('A'));
        } catch (NijePronadjenNijedan e) {
            e.getMessage();
        }
    }

}