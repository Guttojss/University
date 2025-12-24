package ficha2;

import java.util.Scanner;

    

public class ex11 {

    static double salarioFinal(double salario, double bonus, double comisao, double vendas, double carros)
    {
        
        vendas=vendas*comisao;
        bonus=bonus*carros;
        return(salario+vendas+bonus);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o seu salario base:");
        double salarioBase = myScanner.nextDouble();

        System.out.println("Escreva os carros:");
        double carros = myScanner.nextDouble();

        System.out.println("Escreva a % de comisão:");
        double comisao = myScanner.nextDouble();

         System.out.println("Escreva a % de total de vendas:");
        double vendas = myScanner.nextDouble();

        System.out.println("Escreva o bonus:");
        double bonus = myScanner.nextDouble();
        myScanner.close();
        
        System.out.println(salarioFinal(salarioBase, bonus, comisao, vendas, carros));
    }
}


/*11. Sabendo que num stand automóvel, os vendedores recebem um salário base, um bónus por
cada carro vendido e uma comissão correspondente a uma percentagem do total de vendas,
escreve um programa que calcule o salário de um vendedor a partir do seu salário base. */