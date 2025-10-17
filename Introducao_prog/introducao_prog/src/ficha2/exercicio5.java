package ficha2;

import java.util.Scanner;

public class exercicio5 {

    static double farTemp(double num1)
    {
        return(num1*1.8+32);
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva a temperatura :");
        double temperatura = myScanner.nextDouble();
        System.out.println(farTemp(temperatura));
    }
}