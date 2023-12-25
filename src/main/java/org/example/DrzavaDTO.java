package org.example;

public class DrzavaDTO {
    String naziv;
    String glavniGrad;
    public DrzavaDTO(){
        String naziv;
        String glavniGrad;
    }
    public DrzavaDTO(String naziv, String glavniGrad){
        this.naziv=naziv;
        this.glavniGrad=glavniGrad;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(String glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
