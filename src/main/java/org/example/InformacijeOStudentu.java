package org.example;

public class InformacijeOStudentu extends LicneInformacije implements Poruka{
    String godinaStudija;
    String brojIndexa;
    InformacijeOStudentu(){
        super();
        godinaStudija=new String();
        brojIndexa=new String();
    }
    InformacijeOStudentu(String ime,String prezime,String godinaStudija,String brojIndexa){
        super(ime,prezime);
        godinaStudija=this.godinaStudija;
        brojIndexa=this.brojIndexa;
    }
    String getGodinaStudija(){ return godinaStudija;}
    String getBrojIndexa(){return brojIndexa;}
    void setGodinaStudija(String godinaStudija){this.godinaStudija=godinaStudija;}
    void setBrojIndexa(String brojIndexa){this.brojIndexa=brojIndexa;}
    public String postavi(){return  getIme()+getPrezime()+godinaStudija+brojIndexa;}
}
