package ficha22;

import java.util.Scanner;

public class ex2 {
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}

/*Escreva um programa que receba uma letra maiúscula e devolva a minúscula
correspondente, apenas manipulando o código do carácter. */