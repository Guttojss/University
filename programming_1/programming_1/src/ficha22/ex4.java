package ficha22;

import java.util.Scanner;

public class ex4 {
        public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}

/*Escreva um programa que receba uma letra minúscula e imprima uma nova minúscula
aleatória com código ASCII menor do que o da letra recebida. Por exemplo, se a entrada for
‘d’, a saída só pode ser ‘a’, ‘b’ ou ‘c’. */