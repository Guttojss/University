package ficha22;

import java.util.Scanner;

public class ex15 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}
/* Escreva um programa que, dado um total de segundos, os converta para horas, minutos e
segundos e os apresente exatamente no formato hh:mm:ss, preenchendo com 0 os
espaços não utilizados.
*/