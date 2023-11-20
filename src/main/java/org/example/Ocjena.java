package org.example;

public class Ocjena {
    LicneInformacije osoba;
    int ocjena;
    void setOcjena(int ocjena){
        if(ocjena>0 && ocjena<10)this.ocjena=ocjena;
    }
    Ocjena(LicneInformacije osoba, int ocjena){
        this.ocjena=ocjena;
        this.osoba=osoba;
    }
}
