package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoXMLFileTest {
    @Test
    public void testDodajIProcitajLaptop() throws IOException, ClassNotFoundException {
        LaptopDaoXMLFile laptopDao = new LaptopDaoXMLFile(new File("testLaptopDao.xml"),new ArrayList<>());
        Laptop laptop1 = new Laptop("Acer", "Aspire", 1200.00, 8, 1000, 0, "Intel i5", "NVIDIA GTX 1650", 15.6);
        laptopDao.dodajLaptopUFile(laptop1);
        ArrayList<Laptop> ucitaniLaptopi = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(1, ucitaniLaptopi.size());
        assertEquals(laptop1, ucitaniLaptopi.get(0));
    }
    @Test
    public void testRadSPraznomDatotekom() throws IOException, ClassNotFoundException {
        // Inicijalizacija
        LaptopDaoXMLFile laptopDao = new LaptopDaoXMLFile(new File("testLaptopDaoPrazna.xml"),new ArrayList<>());
        ArrayList<Laptop> ucitaniLaptopi = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(0, ucitaniLaptopi.size());
        Laptop laptop = new Laptop("Acer", "Aspire", 1200.00, 8, 1000, 0, "Intel i5", "NVIDIA GTX 1650", 15.6);
        laptopDao.dodajLaptopUFile(laptop);
        ucitaniLaptopi = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(1, ucitaniLaptopi.size());
        assertEquals(laptop, ucitaniLaptopi.get(0));
    }

}