package org.example;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;

public class InformacijeONastavniku extends LicneInformacije implements Poruka{
    private String titula;
    private ArrayList<Ocjena> listaOcjena;
    InformacijeONastavniku(){
        super();
        titula=new String();
    }
    InformacijeONastavniku(String ime,String prezime, String titula){
        super(ime,prezime);
        this.titula=titula;
    }
    String getTitula(){return titula;}
    void setTitula(String titula){this.titula=titula;}
    public String postavi(){return getIme()+getPrezime()+getTitula();}
}
