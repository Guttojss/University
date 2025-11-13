package ficha4;

import java.util.Scanner;

public class ex2 {

    static void tabuada(int n)
    {
        for(int i=0;i<=10;i++)
        {
            System.out.println(i*n);
        }
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        myScanner.close();
        tabuada(num1);
    }
}

// 1. Escreve um programa que receba dois números m e n, e imprima todos valores entre eles.