package ficha2;

import java.util.Scanner;

public class exercicio2 {
    static int soma(int num1, int num2, int num3){
        return num1+num2+num3;
    }
    public static void main(String[] args) {
        System.out.println("Escreva 3 numeros inteiros:");
        Scanner myScanner = new Scanner(System.in);
        int num1 = myScanner.nextInt();
        int num2 = myScanner.nextInt();
        int num3 =  myScanner.nextInt();
        System.out.println(soma(num1,num2,num3));
    }
}
