package ficha2;

import java.util.Scanner;

public class exercicio9 {
    static double calcSegundos(int horas, int minutos, int segundos)
    {
        horas=horas*3600;
        minutos=minutos*60;
        return(horas+minutos+segundos);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escreva uma hora :");
        int horas = myScanner.nextInt();
        System.out.println("Escreva um minuto :");
        int minutos = myScanner.nextInt();
        System.out.println("Escreva um segundo :");
        int segundos = myScanner.nextInt();
        System.out.println(calcSegundos(horas,minutos,segundos));
    }
}
