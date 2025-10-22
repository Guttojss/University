package ficha22;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char num1 = myScanner.next("[0-9]").charAt(0);
        myScanner.close();
        System.out.println(num1);
    }
}


/*Escreve um programa que receba um algarismo (carácter de ‘0’ a ‘9’) e imprima o valor inteiro
correspondente.
Valor int = Valor ASCCI? ou converter o char para int?
*/