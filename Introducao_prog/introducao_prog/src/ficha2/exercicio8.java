package ficha2;

import java.util.Scanner;

public class exercicio8 {

    static double media(double num1, double num2, double num3)
    {
        return((num1+num2+num3)/3);
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva as notas :");
        double nota1 = myScanner.nextDouble();
        double nota2 = myScanner.nextDouble();
        double nota3 = myScanner.nextDouble();
        System.out.println(media(nota1, nota2, nota3));
    }
}


/*Escreve um programa que calcule e apresente a nota final de uma disciplina, sabendo que
corresponde à média de três testes realizados. */