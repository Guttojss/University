package ficha4;

import java.util.Scanner;

public class ex5 {
    static void juros(double euros, double taxa,int anos)
    {
        double outcome=euros*Math.exp(taxa*anos);
        System.out.println(outcome);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        double euros = myScanner.nextDouble();
        System.out.println("Escreva um numero :");
        double taxa = myScanner.nextDouble();
        System.out.println("Quantos anos?");
        int anos = myScanner.nextInt();
        myScanner.close();
        juros(euros,taxa,anos);
    }
}

/*Assumindo que alguém investe p euros com uma taxa de juro anual r, imprime uma tabela
com o dinheiro que teria desde o ano 1 até ao ano t. O valor é dado pela fórmula p*exp(rt). */