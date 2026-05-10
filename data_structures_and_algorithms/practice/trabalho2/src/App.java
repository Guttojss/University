import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// ler ficheiro
public static "Alguma coisa" lerFicheiro("Alguma coisa" numeros)
    {
        File ficheiro = new File("numeros_teste");
        Scanner leitor = null;

        try {leitor = new Scanner(ficheiro); } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Ficheiro não encontrado");
            e.printStackTrace();
        }
        while(leitor.hasNextInt())
        {
            int aux=leitor.nextInt();
            numeros.add(aux);
        }

        leitor.close();
        
        return numeros;
    }
// apaga numeros do ficheiro
public static void eliminar(){
    
}
// Adiciona numeros ao ficheiro
public static void insercao(){
    PrintWritter ficheiro = null;
    try{ficheiro = new PrintWritter("output.csv");}
    catch(Exception e){
        e.printStackTrace();
        System.exit(0);
    }
    ficheiro.print("Isto vai ser escrito");
    ficheiro.close();
}


public static void main(String[] args)
{
    // Timer Inicialização
        long inicio, fim, tempo;
        inicio=System.nanoTime();

        // mudar isto para outro tipo de dados 
        "Alguma coisa" numeros = new "Alguma coisa"(); 
        numeros = lerFicheiro(numeros);

        //timer finalização
        fim=System.nanoTime();
        tempo=fim-inicio;
        System.out.println("tarefa executada em "+tempo+" nanosegundos");
}

/*
Lista Ligada (LL)
• Lista Ligada Ordenada (LL Ord)
• Árvore Binária (AB)
• Árvore Binária Balanceada (AB DSW).

*/