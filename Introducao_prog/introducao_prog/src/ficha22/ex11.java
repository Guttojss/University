package ficha22;

import java.util.Scanner;

public class ex11 {
        public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}
/* Escreva um programa que dado um ângulo x em graus, confirme, para esse ângulo, que
sen2
x + cos2
x = 1.*/