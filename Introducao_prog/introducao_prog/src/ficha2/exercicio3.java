package ficha2;

import java.util.Scanner;

public class exercicio3 {
    static int produto(int num1, int num2)
    {
        return(num1*num2);
    }

    static double divisao(int num1, int num2)
    {
        return(num1/num2);
    }

    static double resto(int num1, int num2)
    {
        return(num1%num2);
    }

    static int quadrado(int num1)
    {
        return(num1*num1);
    }

    public static void main(String[] args) {
        System.out.println("Escreva 2 numeros inteiros:");
        Scanner myScanner = new Scanner(System.in);
        int num1 = myScanner.nextInt();
        int num2 = myScanner.nextInt();
        System.out.println(produto(num1,num2));
        System.out.println(divisao(num1,num2));
        System.out.println(resto(num1,num2));
        System.out.println(quadrado(num1));
        System.out.println(quadrado(num2));
    }
}