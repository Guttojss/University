package ficha22;

import java.util.Scanner;

public class ex6 {
        public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}
/* Escreve um programa que simule o lançamento de um dado, devolvendo um valor inteiro
aleatório ente 1 e 6.*/