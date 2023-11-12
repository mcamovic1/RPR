package org.example;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(File file,ArrayList<Laptop> laptopi){
        this.file = file;
        this.laptopi=laptopi;
    }
    public LaptopDaoSerializableFile(){
        laptopi=new ArrayList<Laptop>();
    }


    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);

    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            FileOutputStream f=new FileOutputStream(file);
            ObjectOutputStream o=new ObjectOutputStream(f);
            o.writeObject(laptop);
            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for(var laptop:laptopi){
            if(laptop.getProcesor()==procesor)return laptop;
        }
        throw new NeodgovarajuciProcesorException();
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
         this.laptopi=laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        ArrayList<Laptop>lista=new ArrayList<>();
        FileInputStream f=new FileInputStream(file);
        ObjectInputStream o=new ObjectInputStream(f);
        lista=(ArrayList<Laptop>) o.readObject();
        /*Laptop lt=new Laptop();
        while((lt=(Laptop)o.readObject())!=null){
            lista.add(lt);
        }*/
        o.close();
        f.close();
        return lista;
    }
}
