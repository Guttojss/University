package ficha22;

import java.util.Scanner;

public class ex5 {
        public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}

/*Escreva um programa que imprima no terminal a seguinte figura:
 * 
 *   0
 * / | \
 * "(0-"=
 * _/ \_
 * 
 */