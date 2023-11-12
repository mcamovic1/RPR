package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //ZA FILE
        File file = new File("laptopi.txt");
        LaptopDaoSerializableFile laptopDao = new LaptopDaoSerializableFile(file, new ArrayList<>());

        // Kreiranje nekoliko laptopa
        Laptop laptop1 = new Laptop("Acer", "Aspire", 1200.00, 8, 1000, 0, "Intel i5", "NVIDIA GTX 1650", 15.6);
        Laptop laptop2 = new Laptop("Dell", "XPS", 1800.00, 16, 500, 512, "Intel i7", "NVIDIA GTX 1660 Ti", 13.3);
        Laptop laptop3 = new Laptop("HP", "Envy", 1500.00, 12, 256, 0, "AMD Ryzen 7", "AMD Radeon RX Vega", 13.3);

        // Dodavanje laptopa u listu i datoteku
        laptopDao.dodajLaptopUListu(laptop1);
        laptopDao.dodajLaptopUFile(laptop2);
        laptopDao.dodajLaptopUListu(laptop3);

        // Čitanje i ispisivanje podataka iz datoteke
        ArrayList<Laptop> ucitaniLaptopi = laptopDao.vratiPodatkeIzDatoteke();
        System.out.println("Učitani laptopi iz datoteke:");
        for (Laptop laptop : ucitaniLaptopi) {
            System.out.println(laptop);
        }

        // Pretraživanje laptopa po procesoru
        try {
            Laptop trazeniLaptop = laptopDao.getLaptop("Intel i7");
            System.out.println("Pronađeni laptop: " + trazeniLaptop);
        } catch (NeodgovarajuciProcesorException e) {
            System.out.println(e.getMessage());
        }

        //za XML
        File xmlFile = new File("laptopi.xml");
        LaptopDaoXMLFile laptopDaoXml = new LaptopDaoXMLFile(xmlFile,new ArrayList<>());

        // Dodavanje laptopa u listu i datoteku
        laptopDaoXml.dodajLaptopUListu(laptop1);
        laptopDaoXml.dodajLaptopUFile(laptop2);
        laptopDaoXml.dodajLaptopUListu(laptop3);

        // Čitanje i ispisivanje podataka iz datoteke
        ArrayList<Laptop> ucitaniLaptopiXml = laptopDaoXml.vratiPodatkeIzDatoteke();
        System.out.println("Učitani laptopi iz XML datoteke:");
        for (Laptop laptop : ucitaniLaptopiXml) {
            System.out.println(laptop);
        }

        //za JSON
        File jsonFile = new File("laptopi.json");
        LaptopDaoJSONFile laptopDaoJson = new LaptopDaoJSONFile(jsonFile, new ArrayList<>());


        // Dodavanje laptopa u listu i datoteku
        laptopDaoJson.dodajLaptopUListu(laptop1);
        laptopDaoJson.dodajLaptopUFile(laptop2);
        laptopDaoJson.dodajLaptopUListu(laptop3);

        // Čitanje i ispisivanje podataka iz datoteke
        ArrayList<Laptop> ucitaniLaptopiJson = laptopDaoJson.vratiPodatkeIzDatoteke();
        System.out.println("\nUčitani laptopi iz JSON datoteke:");
        for (Laptop laptop : ucitaniLaptopiJson) {
            System.out.println(laptop);
        }
    }
}