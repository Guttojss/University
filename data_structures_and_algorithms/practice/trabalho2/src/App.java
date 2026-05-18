import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Classe da Arvore Binaria
class arvoreBinaria 
{
    private No raiz;
    private int nElementos;

    arvoreBinaria(int chave) 
    {
        this.raiz = new No(chave);
        this.nElementos = 1;
    }

    arvoreBinaria() 
    {
        this.raiz = null;
        this.nElementos = 0;
    }


// Nos da arvore Binaria
    private class No {

        int chave;
        No esquerda;
        No direita;

        public No(int elemento) {
            this.chave = elemento;
            this.esquerda = null;
            this.direita = null;
        }
    }
}

// Classe da Lista Ligada
class ListaLigada {

    private int nElementos;
    private No cabeca;

    public ListaLigada() {
        this.cabeca = null;
        this.nElementos = 0;
    }

    // Classe de nó da lista
    private class No {

        int elemento;
        No proximo;

        No(int numeros) {
            this.elemento = numeros;
            this.proximo = null;
        }
    }

    public void inserirCabeca(int numeros) {
        No novoNo = new No(numeros);

        novoNo.proximo = cabeca;
        cabeca = novoNo;
        nElementos++;
    }

    public void inserirCauda(int numeros) {
        No novoNo = new No(numeros);

        if (cabeca == null) {
            cabeca = novoNo;
            nElementos++;
            return;
        }

        No ultimo = cabeca;

        while (ultimo.proximo != null) {
            ultimo = ultimo.proximo;
        }

        ultimo.proximo = novoNo;
        nElementos++;
    }

    // Inserção ordenada crescente
    public void inserirOrdem(int numeros) {

        No novoNo = new No(numeros);

        // inserir no início
        if (cabeca == null || cabeca.elemento >= numeros) {
            novoNo.proximo = cabeca;
            cabeca = novoNo;
            nElementos++;
            return;
        }

        No atual = cabeca;

        // Procurar posição correta
        while (atual.proximo != null &&
               atual.proximo.elemento < numeros) {

            atual = atual.proximo;
        }

        // Inserção
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;

        nElementos++;
    }

}

// ler ficheiro
public static ListaLigada lerFicheiro(ListaLigada numeros)
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

        ListaLigada numeros = new ListaLigada();
        numeros = lerFicheiro(numeros);

        //timer finalização
        fim=System.nanoTime();
        tempo=fim-inicio;
        System.out.println("tarefa executada em "+tempo+" nanosegundos");
}

/*
• Lista Ligada (LL)
• Lista Ligada Ordenada (LL Ord)
• Árvore Binária (AB)
• Árvore Binária Balanceada (AB DSW).

*/