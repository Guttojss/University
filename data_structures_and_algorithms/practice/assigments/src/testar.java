import practice.assigments.src.ex1;
import practice.assigments.src.ex2;

public class testar {
public static void main()
    {
        int tam=20;
        int trocas=50;
        //int valor=19;
        int[] vetor = new int[tam];


        ex1.criarVetorOrdenado(vetor,tam); 
        ex1.embaralharVetor(vetor, tam, trocas);
        ex1.imprimirVetor(vetor, tam);
        //System.out.println(ex1.somaVetor(vetor, tam)); // soma todos os elementos
        //System.out.println(ex1.indiceMaior(vetor, tam)); // procura o maior elemento
        //System.out.println(ex1.indiceMenor(vetor, tam)); //Procura o menor elemento
        //System.out.println(ex1.procuraLinear(vetor, tam, valor)); // Procura linear
        //System.out.println(ex1.procuraLinear(vetor, tam, valor));
        //ex1.selecao(vetor, tam);
        //ex1.insercao(vetor, tam);
        //ex1.bubblesort(vetor, tam);
        
        // --- Exercicio 2 ---
        //ex2.mergesort(vetor, tam);
        //ex2.quicksort(vetor, tam);
        ex1.imprimirVetor(vetor, tam);

        
        
    }
}
