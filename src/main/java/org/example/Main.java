package org.example;

public class Main {
    public static void main(String[] args) {
        //test klase KolekcijaImena
        KolekcijaImena kolekcija=new KolekcijaImena();
        kolekcija.dodaj("Melida Camovic");
        kolekcija.dodaj("Elida Camovic");
        System.out.println(kolekcija.getNajduzi());
        //test klase Pobjednik
        Pobjednik p=new Pobjednik(kolekcija);
        System.out.println(p.getIme());
        System.out.println(p.getPrezime());
        System.out.println(p.getBrojZnakova());
        //test klase PolekcijaImenaIPrezimena
        KolekcijaImenaIPrezimena k=new KolekcijaImenaIPrezimena();
        k.dodaj("Melida","Camovic");
        k.dodaj("Elida","Camovic");
        k.dodaj("Mellida","Camovic");
        System.out.println(k.getImeIPrezime(k.getIndexNajduzegPara()));
    }
}