package ficha2;

import java.util.Scanner;

public class ex7 {
    static double desconto(double num1)
    {
        return(num1*0.80);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva o preco :");
        double preco = myScanner.nextDouble();
        myScanner.close();
        System.out.println(desconto(preco));
    }
}
