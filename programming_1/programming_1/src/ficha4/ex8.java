package ficha4;

import java.util.Scanner;

public class ex8 {
    static void sla(int num1)
    {
        for(int i=1;i<=num1;i++)
        {
            System.out.print("*");
        }
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        myScanner.close();
        sla(num1);
    }
}
