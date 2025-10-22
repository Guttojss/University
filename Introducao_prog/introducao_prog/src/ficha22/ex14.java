package ficha22;

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}
/* . Escreva um programa que dadas duas coordenadas (x1, y1) e (x2, y2), usando valores inteiros,
calcule a distância entre os dois pontos usando a equação:

dist=sqr((x2-x1)^2+(y2-y1)^2)

dist = %.04f

*/