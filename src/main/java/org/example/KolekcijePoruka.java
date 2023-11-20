package org.example;

import java.util.ArrayList;

public class KolekcijePoruka {
    ArrayList<String> poruke;
    KolekcijePoruka(ArrayList<Poruka>poruke){
        this.poruke=new ArrayList<>();
        for(var poruka:poruke){
            this.poruke.add(poruka.postavi());
        }
    }
    ArrayList<String> getPoruke(){return poruke;}
}
