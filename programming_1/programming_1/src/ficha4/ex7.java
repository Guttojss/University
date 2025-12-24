package ficha4;

import java.util.Scanner;

public class ex7 {

    static void fatorial(int num1)
    {
        int fac=1;
        for(int i=num1;i>1;i--)
        {
            fac=fac*i;
        }
        System.out.println(fac);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        myScanner.close();
        fatorial(num1);
    }
}
