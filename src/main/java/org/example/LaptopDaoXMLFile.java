package org.example;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao{
    File file;
    ArrayList<Laptop>laptopi;

    public LaptopDaoXMLFile(File file, ArrayList<Laptop>laptopi) {
        this.file = file;
        this.laptopi=laptopi;
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
       try{
           XmlMapper objectMapper = new XmlMapper();
           objectMapper.writeValue(file, laptop);
       } catch (JsonMappingException e) {
           throw new RuntimeException(e);
       } catch (JsonGenerationException e) {
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
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
