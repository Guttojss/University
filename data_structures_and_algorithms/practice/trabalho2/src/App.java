import java.io.*;
import java.util.Scanner;


public static void insercao(){

}

public static void procura(){

}

public static void eliminar(){
    
}

public class Main {
public static void main(String[] args)
{
    File ficheiro=new File("numeros_teste.csv");
    Scanner	input=null;
    try 
    {
        input =	new Scanner(ficheiro);
    }
    catch (Exception	e)
    {
        e.printStackTrace();
    }

    while(input.hasNextInt())	
    {
        int n=input.nextInt();
        System.out.println(n);
    }

    input.close();
}
}