package ficha22;

import java.util.Scanner;

public class ex3 {
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        myScanner.close();
        
        System.out.println((char)num1);
    }
}

/*3. Escreve um programa que solicite um valor inteiro ao utilizador e imprima o caráter com o
código correspondente. */