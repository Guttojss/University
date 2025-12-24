
package ficha22;

import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        char carac = myScanner.next().charAt(0);
        myScanner.close();
        
        System.out.println();
    }
}

/* Escreve um programa que dado o preço (em euros) de um produto e a percentagem de
desconto (inteiro de 0 a 100), apresente a seguinte informação com a formatação exata
especificada a seguir:
Preço: <preço> (5 espaços + 2 casas decimais)
% Desconto: <desconto>% (a % deve ficar na mesma coluna dos .)
2 1 dist = (x - x ) + ( y - y )
Preço final: <preço final> (formatação igual ao preço)
Desconto: <valor de desconto> (igual ao preço>*/