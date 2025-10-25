package ficha22;

import java.util.Scanner;

public class ex2 {
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva uma MAIUSCULA :");
        String carac = myScanner.next().toLowerCase();
        myScanner.close();
        
        System.out.println(carac);
    }
}

/*Escreva um programa que receba uma letra maiúscula e devolva a minúscula
correspondente, apenas manipulando o código do carácter. */