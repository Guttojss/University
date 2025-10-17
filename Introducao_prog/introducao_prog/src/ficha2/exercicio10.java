package ficha2;

import java.util.Scanner;

public class exercicio10 {
    static double gastado(double gasto)
    {
        for(int i=0;i < 3; i++) {
            double dia=gasto*0.10;
            gasto=gasto+dia;
        }

        return(gasto);
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva quanto foi gasto :");
        double gasto = myScanner.nextDouble();
        System.out.println(gastado(gasto));
    }
}
