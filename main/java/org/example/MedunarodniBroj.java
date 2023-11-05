package org.example;

public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;
    public String getBroj() {
        return broj;
    }
    public MedunarodniBroj(String drzava, String broj){
        this.drzava=drzava;
        this.broj=broj;
    }
    @Override
     public int hashCode(){
        return 1;
    }
    @Override
    public String Ispisi(){
        return drzava+broj;
    }
}
