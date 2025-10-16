package ficha2;

import java.util.Scanner;

public class exercicio5 {

    static double converter(temperatura)
    {
        return(temperatura*1.8*32);
    }
    public static void main(String[] args) {
         Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva a temperatura :");
        double temperatura = myScanner.nextDouble();
        System.out.println(converter(temperatura));
    }
}
