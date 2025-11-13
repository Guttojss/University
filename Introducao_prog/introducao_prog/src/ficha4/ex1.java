package ficha4;

import java.util.Scanner;

public class ex1 {

    static void valoresentre(int n, int m)
    {
        for(int i=n;i<=m;i++)
        {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        System.out.println("Escreva um numero :");
        int num2 = myScanner.nextInt();
        myScanner.close();
        valoresentre(num1,num2);
    }
}

// 1. Escreve um programa que receba dois números m e n, e imprima todos valores entre eles.