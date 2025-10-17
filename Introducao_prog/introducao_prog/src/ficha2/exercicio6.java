package ficha2;

import java.util.Scanner;

public class exercicio6 {
    static double calcRaio(double raio)
    {
        raio=raio*raio;
        return(3.14*raio);
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o raio do ciruclo :");
        double raio = myScanner.nextDouble();
        System.out.println(calcRaio(raio));
    }
}


/*
 * 
 * . Escreve um programa que que calcule e apresente a área de um círculo, conhecido o seu
raio.


pi*r^2
 */