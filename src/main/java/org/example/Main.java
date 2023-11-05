package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Unesite broj za faktorijel: ");
        Scanner unos=new Scanner(System.in);
        int n= unos.nextInt();
        int f=Math.factoriel(n);
        System.out.println("Faktorijel unesenog broja glasi:");




    }

}