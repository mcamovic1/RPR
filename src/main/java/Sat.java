public class Sat {
    int sati, minute, sekunde;

    public void Postavi(int sati1, int minute1, int sekunde1) {
        sati = sati1;
        minute = minute1;
        sekunde = sekunde1;
    }

    Sat(int sati1, int minute1, int sekunde1) {
        Postavi(sati1, minute1, sekunde1);
    }

    public  void Sljedeci() {
        sekunde++;
        if (sekunde == 60) {
            sekunde = 0;
            minute++;
        }
        if (minute == 60) {
            minute = 0;
            sati++;
        }
        if (sati == 24) sati = 0;
    }
    public void Prethodni() {
        sekunde--;
        if (sekunde == -1) {
            sekunde = 59;
            minute--;
        }
        if (minute == -1) {
            minute = 59;
            sati--;
        }
        if (sati == -1) sati = 23;
    }
    public void PomjeriZa(int pomak) {
        if (pomak>0) for (int i=0; i<pomak; i++) Sljedeci();
        else for (int i=0; i<-pomak; i++) Prethodni();
    }
    int DajSate()  { return sati; }
    int DajMinute()  { return minute; }
    int DajSekunde()  { return sekunde; }
    void Ispisi() { System.out.println(sati);}
}
