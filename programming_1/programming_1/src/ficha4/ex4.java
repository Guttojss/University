package ficha4;

import java.util.Scanner;

public class ex4 {
    static void fibonaci(int num)
    {
        for(int i=0;i<=num;i++)
        {
            i=i+(i-1)+(i-2);
            System.out.println(i);
        }
    }
       public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        myScanner.close();
        fibonaci(num1);
    }

}


 // Not done | Need to think about this for a sec