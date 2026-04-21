import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class trabalho1{
    
    //Ler o palavras.txt
    public static ArrayList<String> lerFicheiro(ArrayList<String> palavras)
    {
        // To-Do : Mudar o Path para outra forma sem mostrar o PATH inteiro
        File ficheiro = new File("University\\data_structures_and_algorithms\\practice\\trabalho1\\palavras.txt");
        Scanner leitor = null;

        try 
        {
            leitor = new Scanner(ficheiro); 
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Ficheiro não encontrado");
            e.printStackTrace();
        }
        while(leitor.hasNext())
        {
            String aux=leitor.next();
            palavras.add(aux);
        }

        leitor.close();
        
        return palavras;
    }
    
    // Organizar
    // Seleção
    public static ArrayList<String> selecao(ArrayList<String> palavras)
    {
        //Ordena do minimo para o max
        int min;
        String temp;
            for(int i=0;i!=palavras.size();i++)
            {
                min=i;
                for(int j=i+1;j!=palavras.size();j++)
                    if(palavras.get(j).compareTo(palavras.get(min)) < 0)
                        min=j;

                if(i!=min)
                {
                    temp=palavras.get(i);
                    palavras.set(i,palavras.get(min));
                    palavras.set(min,temp);
                }
            }
        return palavras;
    } 
    
    //Inserção
    public static ArrayList<String> insercao(ArrayList<String> palavras)
    {
        String temp;
        for(int i=1;i!=palavras.size();i++)
        {
            temp = palavras.get(i);
            int j=i;    
            while(j > 0 && palavras.get(j - 1).compareTo(temp) > 0)
            {
                palavras.set(j, palavras.get(j - 1));
                j--;
            }
            if(j!=i)
                palavras.set(j, temp);
        }
            return palavras;
    }

    //Permutação or BubbleSorte
    public static ArrayList<String> bubblesort(ArrayList<String> palavras)
    {
        boolean trocado=false;
        String temp;

        for(int i=0;i!=palavras.size()-1;i++)
        {
            trocado=false;
            for(int j=0;j!=palavras.size()-1;j++)
                if(palavras.get(j).compareTo(palavras.get(j + 1)) > 0)
                {
                    temp = palavras.get(j);
                    palavras.set(j, palavras.get(j + 1));
                    palavras.set(j + 1, temp);
                    trocado=true;
                }
                
                if (trocado==false) {
                    break;
                }
        }
        return palavras;
    }

    // Quick Sort
    public static void quickSort(ArrayList<String> palavras, int inicio, int fim)
    {
        if(inicio < fim)
        {
            int pivoIndex = partition(palavras, inicio, fim);

            quickSort(palavras, inicio, pivoIndex - 1);
            quickSort(palavras, pivoIndex + 1, fim);
        }
    }

    private static int partition(ArrayList<String> palavras, int inicio, int fim)
    {
        String pivo = palavras.get(fim);
        int i = inicio - 1;

        for(int j = inicio; j < fim; j++)
        {
            if(palavras.get(j).compareTo(pivo) <= 0)
            {
                i++;

                // troca
                String temp = palavras.get(i);
                palavras.set(i, palavras.get(j));
                palavras.set(j, temp);
            }
        }

        // colocar o pivô no sítio certo
        String temp = palavras.get(i + 1);
        palavras.set(i + 1, palavras.get(fim));
        palavras.set(fim, temp);

        return i + 1;
    }

    // Merge Sort
    public static void mergeSort(ArrayList<String> palavras, int inicio, int fim)
    {
        if(inicio < fim)
        {
            int meio = (inicio + fim) / 2;

            mergeSort(palavras, inicio, meio);
            mergeSort(palavras, meio + 1, fim);
            merge(palavras, inicio, meio, fim);
        }
    }

    private static void merge(ArrayList<String> palavras, int inicio, int meio, int fim)
    {
        ArrayList<String> esquerda = new ArrayList<>();
        ArrayList<String> direita = new ArrayList<>();

        for(int i = inicio; i <= meio; i++)
            esquerda.add(palavras.get(i));

        for(int i = meio + 1; i <= fim; i++)
            direita.add(palavras.get(i));

        int i = 0;
        int j = 0;
        int k = inicio;

        while(i < esquerda.size() && j < direita.size())
        {
            if(esquerda.get(i).compareTo(direita.get(j)) <= 0)
            {
                palavras.set(k, esquerda.get(i));
                i++;
            }
            else
            {
                palavras.set(k, direita.get(j));
                j++;
            }
            k++;
        }

        while(i < esquerda.size())
        {
            palavras.set(k, esquerda.get(i));
            i++;
            k++;
        }

        while(j < direita.size())
        {
            palavras.set(k, direita.get(j));
            j++;
            k++;
        }
    }

    // Procuras 
    //Procura linear
    public static int procuraLinear(ArrayList<String> palavras,String valor)
    {
        int index = -1;
        for(int i = 0; i < palavras.size(); i++)
              if(palavras.get(i).compareTo(valor) == 0)
                index = i;
        return index;
    }

    //Procura binaria
    public static int procuraBinaria(ArrayList<String> palavras, String valor)
    {
        int min = 0;
        int max = palavras.size() -1;

        while (min <= max)
        {
            int metade = (min + max) / 2;
            int comparacao = palavras.get(metade).compareTo(valor);

            if (comparacao == 0)
            {
                return metade;
            }
            else if (comparacao < 0)
            {
                min = metade + 1;
            }
            else
            {
                max = metade - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        // Timer Inicialização
        long inicio, fim, tempo;
        inicio=System.currentTimeMillis();

        ArrayList<String> palavras = new ArrayList<>(); 
        palavras = lerFicheiro(palavras);
       
        //selecao(palavras);
        //insercao(palavras);
        //bubblesort(palavras);
        mergeSort(palavras, 0, palavras.size()-1);
        //quickSort(palavras, 0, palavras.size()-1);

        System.out.println(procuraLinear(palavras, "Xarões")); // Linear Desorganizado
        //System.out.println(procuraBinaria(palavras, "Xarões")); // Binario Organizado
       
        //timer finalização
        fim=System.currentTimeMillis();
        tempo=fim-inicio;
        System.out.println("tarefa executada em "+tempo+" milisegundos");
    }
}
// Existem :
// arruinai 123
// capitel 109
// curso 112
// eslavo 143
// gravataria 153
// longo 144
// obtenhais 130
// progenitor 158
// seria 136
// vaca 132

// Nao Existem :
// algoritmo 110
// condicional 133
// direita 127
// esquerda
// grande
// livros
// prata
// silencio
// verde
// Xarões