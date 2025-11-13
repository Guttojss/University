package ficha4;

import java.util.Scanner;

public class ex3 {

    static void somatorio(int num)
    {   
        int soma=0;
        for(int i=1;i<=num;i++)
        {
            soma=soma+1;
        }
        System.out.println(soma);
    }
     public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva um numero :");
        int num1 = myScanner.nextInt();
        myScanner.close();
        somatorio(num1);
    }
}
/*3. Escreve um programa que vá somando os números inteiros a partir de 1, até que a soma
ultrapasse um limite introduzido pelo utilizador. O programa deve imprimir quantos números
foram somados. */