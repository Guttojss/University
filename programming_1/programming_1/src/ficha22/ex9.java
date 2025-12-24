package ficha22;

import java.util.Scanner;

public class ex9 {
        public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}


/*Implemente a função de paridade binária de três argumentos. Esta função devolve true se
um número ímpar dos argumentos recebidos for true e false nos outros casos. */