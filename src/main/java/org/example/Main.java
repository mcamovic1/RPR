package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();

        String gradoviInfo = ispisiGradove();
        System.out.println(gradoviInfo);
        glavniGrad();
    }

    private static String ispisiGradove() {
        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        StringBuilder sb = new StringBuilder();
        for (GradDTO grad : geografijaDAO.gradovi()) {
            sb.append(grad.getNaziv()).append(" (").append(grad.getDrzava()).append(") - ")
                    .append(grad.getBrojStanovnika()).append("\n");
        }
        return sb.toString();
    }

    private static void glavniGrad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite naziv države:");
        String drzava = scanner.nextLine();

        GeografijaDAO geografijaDAO = GeografijaDAO.getInstance();
        GradDTO glavniGrad = geografijaDAO.glavniGrad(drzava);

        if (glavniGrad != null) {
            System.out.println("Glavni grad države " + drzava + " je " + glavniGrad.getNaziv());
        } else {
            System.out.println("Nepostojeća država");
        }
    }
    }

