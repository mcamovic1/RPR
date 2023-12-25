package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        ArrayList<GradDTO> gradovi = geografijaDAO.gradovi();
        System.out.println("Gradovi ubazi podataka:");
        for (GradDTO grad : gradovi) {
            System.out.println(grad.getNaziv() + ", " + grad.getDrzava() + ", Broj stanovnika: " + grad.getBrojStanovnika());
        }
        GradDTO noviGrad = new GradDTO("Berlin", "Njemačka", 3700000);
        geografijaDAO.dodajGrad(noviGrad);

        gradovi = geografijaDAO.gradovi();
        System.out.println("\nGradovi nakon dodavanja novog grada:");
        for (GradDTO grad : gradovi) {
            System.out.println(grad.getNaziv() + ", " + grad.getDrzava() + ", Broj stanovnika: " + grad.getBrojStanovnika());
        }
    }
    }

