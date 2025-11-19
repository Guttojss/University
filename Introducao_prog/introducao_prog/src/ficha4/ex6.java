package ficha4;

import java.util.Scanner;

public class ex6 {
    static int sla(int num1, int num2)
    {
        int resultado =0;
        if (num1 <= 0 || num2 <= 0){
            return 0;
        }
        else {
            for(int i=1;i<=num2;i++)
            {
                resultado = i*num1;
            }
            return resultado;
        }
            
    }
    public static void main(String[] args) {
        System.out.println("NUm 1:");
        Scanner myScanner = new Scanner(System.in);
        int num1 = myScanner.nextInt();
        System.out.println("Num 2 : ");
        int num2 = myScanner.nextInt();
        myScanner.close();
        System.out.println(sla(num1, num2));
    }
}
