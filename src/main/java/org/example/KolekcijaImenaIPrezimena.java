package org.example;

import java.util.ArrayList;

public class KolekcijaImenaIPrezimena {
    private ArrayList<String> ime, prezime;
    KolekcijaImenaIPrezimena(){
        ime=new ArrayList<>();
        prezime=new ArrayList<>();
    }
    void dodaj(String i,String p){
       ime.add(i);
       prezime.add(p);
    }
    int getIndexNajduzegPara(){
        int max=0;
        int index=0;
        for(int i=0;i<ime.size() && i<prezime.size();i++){
            if(ime.get(i).length()+prezime.get(i).length()>max){
                max=ime.get(i).length()+prezime.get(i).length();
                index=i;
            }
        }
            return index;
    }
    String getImeIPrezime(int i){
        return ime.get(i)+" "+prezime.get(i);
    }
}
