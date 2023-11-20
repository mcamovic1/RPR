package org.example;

import java.util.ArrayList;

public class KolekcijaImena {
    ArrayList<String> kolekcija; //format "Ime Prezime"
    KolekcijaImena(){
        kolekcija=new ArrayList<>();
    }
    void dodaj (String k){
        kolekcija.add(k);
    }
    String getNajduzi(){
        String min=kolekcija.get(0);
        for(int i=0;i< kolekcija.size()-1;i++){
            if(kolekcija.get(i).length()<min.length())min=kolekcija.get(i);
        }
        return min;
    }
}
