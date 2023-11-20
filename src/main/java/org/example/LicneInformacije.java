package org.example;

public class LicneInformacije implements Poruka{
    private String ime;
    private String prezime;
    LicneInformacije(String ime, String prezime){
        this.ime=ime;
        this.prezime=prezime;
    }
    LicneInformacije(){
        ime=new String();
        prezime=new String();
    }
    String getIme(){return ime;}
    String getPrezime(){return prezime;}
    void setIme(String ime){this.ime=ime;}
    void setPrezime(String prezime){this.prezime=prezime;}
    public String postavi(){return ime+prezime;}
}
