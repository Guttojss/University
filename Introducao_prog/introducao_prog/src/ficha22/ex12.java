package ficha22;

import java.util.Scanner;

public class ex12 {
        public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}
/* 2. Escreva um programa que, dadas a longitude e a latitude de duas cidades em graus, (x1, y1)
e (x2, y2), calcule a distância entre elas no globo usando a seguinte fórmula: d =
60arccos(sin(x1)sin(x2) + cos(x1) cos(x2)cos(y1 - y2)). Use o programa para calcular a distância
entre Paris (48.87° N, -2.33° W) e São Francisco (37.8° N, 122.4° W).*/