package org.example;
public class Math {
    public final static double PI = 3.14159265358979323846;
    public static double power(double input, int pow){
        double product = 1;
        for(int i=0; i<pow; i++){
            product *= input;
        }
        return product;
    }
    public static int factoriel (int broj){
        for(int i=broj-1; i>0;i--)broj*=i;
        return broj;
    }
    public static double sin(double input){
        double sum = 0;
        for (int i = 0; i <= 5; i++) {
            sum += power(-1, i) * (power(input, 2 * i + 1) / factoriel(2 * i + 1));
        }
        return sum;
    }

}
