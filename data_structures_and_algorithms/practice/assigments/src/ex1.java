package practice.assigments.src;


public class ex1 {
    //Cria um vetor : vetor[1] = 1 | vetor[2]=2 ...
    public static int[] criarVetorOrdenado(int[] vetor,int tam)
    {
        for(int i=0;i!=tam;i++)
           vetor[i]=i;
        
        return vetor;       
    }
    //Mostra o vetor
    public static void imprimirVetor(int[] vetor,int tam)
    {
        for(int i=0;i!=tam;i++)
        {
            if(i>20)
            {
                System.out.println("...");
                break;
            }
            System.out.printf("Vetor[%d]=%d %n",i,vetor[i]);

        }
    }
    //Embaralha o vetor fazendo troca de 2 valores em cada loop.
    public static int[] embaralharVetor(int[] vetor,int tam, int trocas)
    {
        int temp;
        for(int i=0;i!=trocas;i++)
        {
            //Escolhe quais vao ser trocados
            int a = (int) (Math.random()*tam);
            int b = (int) (Math.random()*tam);
            //Troca
            temp = vetor[a];
            vetor[a] = vetor[b];
            vetor[b] = temp; 
        }
        return vetor;
    }
    // faz a soma de todos os valores do array.
    public static int somaVetor(int[] vetor,int tam)
    {
        int soma=0;
        for(int i=0;i!=tam;i++)
            soma=soma+vetor[i];

        return soma;
    }

    // procura o indice onde esta o maior valor ex . 100
    public static int indiceMaior(int[] vetor, int tam)
    {
        int maiorIndice=0;
        for(int i=0;i!=tam;i++)
            if(vetor[maiorIndice]<vetor[i])
                maiorIndice=i;
        return maiorIndice;
    }
    //Procura o indice onde esta o menor valor ex : 0
    public static int indiceMenor(int[] vetor, int tam)
    {
        int menorIndice=0;
        for(int i=0;i!=tam;i++)
            if(vetor[menorIndice]>vetor[i])
                menorIndice=i;
        return menorIndice;
    }

    //Procura linear
    public static int procuraLinear(int[] vetor,int tam,int valor)
    {
        int index = -1;

        for(int i=0;i!=tam;i++)
            if(vetor[i]==valor)
                index=i;
        return index;
    }
    //Procura binaria
    public static int procuraBinaria(int[] vetor, int tam,int valor)
    {
        int min=0;
        int max=tam;
        
        do{
            int metade = max+(max-min)/2;
            if(vetor[metade]==valor)
                return metade;

            if(vetor[metade]<valor)
                min=metade+1;

        }while(metade!=valor);
        return -1;
    }
    
    // Seleção
    public static int[] selecao(int[] vetor, int tam)
    {
        //Ordena do minimo para o max
        int min,temp;
            for(int i=0;i!=tam;i++)
            {
                min=i;
                for(int j=i+1;j!=tam;j++)
                    if(vetor[j]<vetor[min])
                        min=j;

                if(i!=min)
                {
                    temp=vetor[i];
                    vetor[i]=vetor[min];
                    vetor[min]=temp;
                }
            }
        return vetor;
    } 
    
    
    //Inserção
    public static int[] insercao(int[] vetor, int tam)
    {
        int temp=0;
        for(int i=1;i!=tam;i++)
        {
            temp= vetor[i];
            int j=i;    
            while(j>0 && vetor[j-1]>temp)
            {
                vetor[j]=vetor[j-1];
                j--;
            }
            if(j!=i)
                vetor[j]=temp;
        }
            return vetor;
    }
    //Permutação or BubbleSorte
    public static int[] bubblesort(int[] vetor, int tam)
    {
        boolean trocado=false;
        int temp=0;

        for(int i=0;i!=tam-1;i++)
        {
            trocado=false;
            for(int j=0;j!=tam-1;j++)
                if(vetor[j]>vetor[j+1])
                {
                    temp=vetor[j];
                    vetor[j]=vetor[j+1];
                    vetor[j+1]=temp;
                    trocado=true;
                }
                
                if (trocado==false) {
                    break;
                }
        }
        return vetor;
    }
}
