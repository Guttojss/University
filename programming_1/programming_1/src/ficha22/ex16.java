package ficha22;

import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}
/* . Escreva um programa que converta, sem recorrer à biblioteca matemática, um valor em
graus para um valor em radianos (radianos = graus/180*pi) e um valor em grados (grados
= graus/90*100). Os graus devem ser apresentados com uma casa decimal, os radianos
com quatro casas decimais e os grados com duas casas decimais.*/