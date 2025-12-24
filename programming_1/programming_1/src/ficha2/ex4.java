package ficha2;

import java.util.Scanner;

public class ex4 {

    static double imc(int peso, double altura)
    {
        altura=altura*altura;
        double imc= peso / altura;
        System.out.println(imc);
        System.out.println(peso);
        System.out.println(altura);
        return(imc);
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o seu peso em KG :");
        int peso = myScanner.nextInt();
        System.out.println("Escreva a sua altura em centimetros : ");
        double altura = myScanner.nextFloat();
        myScanner.close();
        System.out.println(imc(peso,altura));
    }
}