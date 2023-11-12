package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {
    @Test
    public void testDodajJedanLaptopUFile() throws IOException, ClassNotFoundException {
        File file = new File("laptopi1.txt");
        LaptopDaoSerializableFile laptopFile = new LaptopDaoSerializableFile(file,new ArrayList<>());

        Laptop laptop = new Laptop("Acer", "Aspire", 1200.00, 8, 1000, 0, "Intel i5", "NVIDIA GTX 1650", 15.6);
        laptopFile.dodajLaptopUFile(laptop);

        ArrayList<Laptop> ucitaniLaptopi = laptopFile.vratiPodatkeIzDatoteke();
        assertEquals(1, ucitaniLaptopi.size());
        assertEquals(laptop, ucitaniLaptopi.get(0));
    }
    @Test
    public void testDodajViseLaptopaUFile() throws IOException, ClassNotFoundException {
        File file = new File("laptopi2.txt");
        LaptopDaoSerializableFile laptopFile = new LaptopDaoSerializableFile(file, new ArrayList<>());

        Laptop laptop1 = new Laptop("Acer", "Aspire", 1200.00, 8, 1000, 0, "Intel i5", "NVIDIA GTX 1650", 15.6);
        Laptop laptop2 = new Laptop("Dell", "XPS", 1800.00, 16, 500, 512, "Intel i7", "NVIDIA GTX 1660 Ti", 13.3);

        laptopFile.dodajLaptopUFile(laptop1);
        laptopFile.dodajLaptopUFile(laptop2);

        ArrayList<Laptop> ucitaniLaptopi = laptopFile.vratiPodatkeIzDatoteke();
        assertEquals(2, ucitaniLaptopi.size());
        assertEquals(laptop1, ucitaniLaptopi.get(0));
        assertEquals(laptop2, ucitaniLaptopi.get(1));
    }

    }
