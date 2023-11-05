package org.example;


import java.util.*;

public class Imenik {
    HashMap<String ,TelefonskiBroj> mapa;
    public Imenik (){
        mapa=new HashMap<String, TelefonskiBroj>();
    }
    public void dodaj (String ime, TelefonskiBroj broj){
        mapa.put(ime, broj);
    }
    String dajBroj (String ime){
       return mapa.get(ime).Ispisi();
    }
    String dajIme (TelefonskiBroj broj){
          for(Map.Entry<String, TelefonskiBroj>e: mapa.entrySet()){
              if(e.getValue()==broj) return e.getKey();
          }
          return "";
    }
    String naSlovo (char s) throws NijePronadjenNijedan {
        String imena_na_s="";
        for(Map.Entry<String, TelefonskiBroj>e: mapa.entrySet()){
            int brojac=0;
            if(e.getKey().startsWith("s")){
                brojac++;
                imena_na_s+=brojac+"."+e.getKey()+"-"+e.getValue().Ispisi()+"\n";
            }
        }
        if(imena_na_s=="")throw new NijePronadjenNijedan("Nije pronadjeno nijedno ime na slovo"+s);
        return imena_na_s;
    }
    Set<String> izGrada (Grad g) throws NijePronadjenNijedan {
        Set<String> imena=new HashSet<>();
        for(Map.Entry<String, TelefonskiBroj>e: mapa.entrySet()){
            if(e.getValue().getClass().getName()=="FiksniBroj"){
                FiksniBroj f_br= (FiksniBroj) e.getValue();
                if(f_br.getGrad()==g) imena.add(e.getKey());
            }
        }
        List<String> lista=new ArrayList<>(imena);
        Collections.sort(lista);
        Set<String> sortitana_imena=new TreeSet<>(lista);
        if(sortitana_imena.isEmpty())throw new NijePronadjenNijedan("Nije pronadjen nijedan korisnik iz grada"+g);
        return sortitana_imena;
    }
    Set<TelefonskiBroj> izGradaBrojevi (Grad g) throws NijePronadjenNijedan {
        Set<TelefonskiBroj> brojevi=new HashSet<>();
        for(Map.Entry<String, TelefonskiBroj>e: mapa.entrySet()){
            if(e.getValue().getClass().getName()=="FiksniBroj"){
                FiksniBroj f_br= (FiksniBroj) e.getValue();
                if(f_br.getGrad()==g) brojevi.add(e.getValue());
            }
        }
        class StringComparator implements Comparator{
            @Override
            public int compare(Object o1, Object o2) {
                TelefonskiBroj t1=(TelefonskiBroj)o1;
                TelefonskiBroj t2=(TelefonskiBroj)o2;
                return t1.Ispisi().compareTo(t2.Ispisi());
            }
        }
        List<TelefonskiBroj>lista=new ArrayList<>(brojevi);
        Collections.sort(lista, new StringComparator());
        Set<TelefonskiBroj> sortirani_brojevi=new TreeSet<>(lista);
        if(sortirani_brojevi.isEmpty())throw new NijePronadjenNijedan("Nije pronadjen nijedan broj iz grada "+g);
        return sortirani_brojevi;
    }

}
