package ficha4;

import java.util.Scanner;

public class ex25 {
    static void cima(int num1)
    {
        for(int i=1;i<=num1;i++)
        {
            for(int j=i;j<=num1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void baixo(int num1)
    {
        for(int i=1;i<=num1;i++)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        myScanner.close();
        cima(num1);
        System.out.println("----------------------");
        baixo(num1);
    }
}
