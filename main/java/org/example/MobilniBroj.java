package org.example;

public class MobilniBroj extends TelefonskiBroj{
    private int mobilnaMreza;
    private String broj;
    public String getBroj() {
        return broj;
    }



    public MobilniBroj(int mobilnaMreza, String broj){
        this.mobilnaMreza=mobilnaMreza;
        this.broj=broj;
    }
    @Override
    public int hashCode(){
        return mobilnaMreza;
    }
    @Override
    public String Ispisi(){
        return "0"+hashCode()+"/"+broj;
    }

}
