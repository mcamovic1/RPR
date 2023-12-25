package org.example;

public class GradDTO {
    String naziv, drzava;
    int brojStanovnika;
    public GradDTO(){
        naziv=new String("");
        drzava=new String("");
        brojStanovnika=0;
    }
    public GradDTO(String naziv,  String drzava,int brojStanovnika){
        this.naziv=naziv;
        this.brojStanovnika=brojStanovnika;
        this.drzava=drzava;
    }
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

}
