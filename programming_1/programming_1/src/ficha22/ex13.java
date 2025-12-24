package ficha22;

import java.util.Scanner;

public class ex13 {
        public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }   
}
/* Escreva um programa que, dados dois pontos com coordenadas inteiras (x1, y1) e (x2, y2),
imprima a equação da reta que passa pelos pontos, y = mx + b, sendo que m e b são valores
reais calculados usando as seguintes equações:

m=(y2-y1)/(x2-x1)

b=y1-x1(y2-y1)/(x2-x1)
    */