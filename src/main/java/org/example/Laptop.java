package org.example;

import java.io.Serializable;
import java.util.Locale;

public class Laptop implements Serializable {
   public  String brend;
   public String model;
   public double cijena;
   public int ram;
   public  int hdd;
   public int ssd;
   public String procesor;
   public String grafickaKratica;
   public double velicinaEkrana;

    public Laptop(String brend, String model, double cijena, int ram, int hdd,int ssd,String procesor,String grafickaKratica,double velicinaEkrana) {
       this.brend=brend;
       this.model=model;
       this.cijena=cijena;
       this.ram=ram;
       this.hdd=hdd;
       this.procesor=procesor;
       this.grafickaKratica=grafickaKratica;
       this.velicinaEkrana=velicinaEkrana;
    }


    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getGrafickaKratica() {
        return grafickaKratica;
    }

    public void setGrafickaKratica(String grafickaKratica) {
        this.grafickaKratica = grafickaKratica;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }
    @Override
    public String toString() {
        return String.format(Locale.US,
                "Laptop [Brend: %s, Model: %s, Cijena: %.2f, RAM: %dGB, HDD: %dGB, SSD: %dGB, Procesor: %s, Graficka kartica: %s, Velicina ekrana: %.1f\"]",
                brend, model, cijena, ram, hdd, ssd, procesor, grafickaKratica, velicinaEkrana);
    }
}
