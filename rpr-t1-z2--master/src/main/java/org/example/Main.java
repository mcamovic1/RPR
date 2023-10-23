package org.example;

import java.util.Scanner;
public class Main {
    public static void sumaCifara(int n){
        for(int i=1;i<=n;i++){
            int zamena=i, suma=0;
            while(zamena!=0){
                suma+=zamena%10;
                zamena/=10;
            }
            if(i%suma==0)System.out.println(i);
        }

    }
    public static void main(String[] args) {
        System.out.println("Unesite broj");
        Scanner unos=new Scanner(System.in);
        int n=unos.nextInt();
        sumaCifara(n);
    }
}