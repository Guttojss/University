package trabalho1;

import java.util.Scanner;
import trabalho1.Visualizar;

public class Editar {
    // Utilitários.
    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}
    
    // Adiciona Conteudos aos arrays.
    public static int adicionar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating, Scanner myScanner, int tamMax,int pos)
    {
        clear();
        if(pos==-1) 
        {
            if(nItens>tamMax) {System.out.println("Atingiu o limite de Itens."); return -1;}    
                System.out.println("Qual o Título : ");
                titulo[nItens] = myScanner.nextLine();
                System.out.println("É uma série ou um filme?");
                tipo[nItens] = myScanner.next().toUpperCase().charAt(0);
                System.out.println("Qual o ano de lançamento?");
                ano[nItens] = myScanner.nextInt();
                System.out.println("Já foi visto?");
                visto[nItens] = myScanner.nextBoolean();
                System.out.println("Qual a nota de 0 a 10?");
                rating[nItens] = myScanner.nextInt();
                System.out.println("Item Adicionado com sucesso!");
                nItens++;
        }
        

        if(pos!=-1) // Adiciona na posição
        {
            for(int i=nItens;i>=pos;i--)
            { 
                if(pos >= 0 && pos<=tamMax) // Verifica se o item existe.
                {   
                    if(i!=pos)
                    {
                            titulo[i]=titulo[i-1]; tipo[i]=tipo[i-1]; ano[i]=ano[i-1]; visto[i]=visto[i-1]; rating[i]=rating[i-1];
                    }
                    else 
                    {
                        System.out.println("Qual o Título : ");
                        titulo[pos] = myScanner.nextLine();
                        System.out.println("É uma série ou um filme?");
                        tipo[pos] = myScanner.next().toUpperCase().charAt(0);
                        System.out.println("Qual o ano de lançamento?");
                        ano[pos] = myScanner.nextInt();
                        System.out.println("Já foi visto?");
                        visto[pos] = myScanner.nextBoolean();
                        System.out.println("Qual a nota de 0 a 10?");
                        rating[pos] = myScanner.nextInt();
                        nItens++;
                    }
                    
                } else System.out.println("Atingiu o limite de Itens.");
            }
        }
        return nItens;
    }
    // Apaga arrays
    public static int apagar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner,int pos)
    {   
        if(pos==-1) // Apaga os que já foram vistos
        {
            for(int i=0;i!=nItens;i++)
            {   
                if(visto[i]==false) 
                {
                    for(int j=i;j!=nItens;j++)
                    {
                        titulo[j]=titulo[i]; tipo[j]=tipo[i]; ano[j]=ano[i]; visto[j]=visto[i]; rating[j]=rating[i];
                    }
                    nItens--;
                    i--;
                }
            }
        }
        if(pos!=-1) // apaga na posição
        {
            for(int i=1;i!=nItens-1;i++)
            { 
                if(pos<nItens && pos >= 0) // Verifica se o item existe.
                {   
                    if(i!=pos)
                    {
                            titulo[i]=titulo[i+1]; tipo[i]=tipo[i+1]; ano[i]=ano[i+1]; visto[i]=visto[i+1]; rating[i]=rating[i+1];
                    }
                    
                } else System.out.println("Não existe esse item.");
            }
            nItens--;
        }
        return nItens;
    }

    public static int menuEditar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner,int tamMax){
        clear();
        System.out.println("(A)dicionar  item no fim");
        System.out.println("Adicionar (I)tem na posição n");
        System.out.println("Apagar item na (P)osição n"); int pos=0;
        System.out.println("Apagar ite(N)s vistos");
        System.out.println("(V)oltar"); 
        char opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o Input
        
        switch (opcao) {
            case 'A': pos=-1; nItens=adicionar(nItens, titulo, tipo, ano, visto, rating,myScanner,tamMax,pos);break;
            case 'I': System.out.println("Qual é a posição?"); pos= myScanner.nextInt(); pos--;
            myScanner.nextLine(); // limpa o input
            nItens=adicionar(nItens, titulo, tipo, ano, visto, rating,myScanner,tamMax,pos); break;
            case 'P': System.out.println("Qual é a posição?"); pos= myScanner.nextInt(); pos--;
            myScanner.nextLine(); // limpa o input 
            nItens=apagar(nItens, titulo, tipo, ano, visto, rating, myScanner, pos); break;
            case 'N': pos=-1; nItens=apagar(nItens, titulo, tipo, ano, visto, rating,myScanner,pos); break;
            case 'V': break;
            default:  System.out.println("Escreva um caracter Válido"); break;
        }
        return nItens;

    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int tamMax = 100 ;
        String[] titulo = new String[tamMax];   // Nome do conteudo
        char[] tipo = new char[tamMax];         // Se é Filme(F) Ou Série (S)
        int[] ano = new int[tamMax];            // Ano de lançamento
        boolean[] visto = new boolean[tamMax];  // Se foi visto ou não
        int[] rating = new int[tamMax];         // Classificação da conteudo
        //Adiciona 4 elementos a todos os arrays.
        int nItens = 4;
        titulo[0] = "The Matrix"; tipo[0] = 'F'; ano[0] = 1999; visto[0] = true; rating[0] = 9;
        titulo[1] = "Breaking Bad"; tipo[1] = 'S'; ano[1] = 2008; visto[1] = true; rating[1] = 10;
        titulo[2] = "Oppenheimer"; tipo[2] = 'F'; ano[2] = 2023; visto[2] = false; rating[2] = 0;
        titulo[3] = "Dark"; tipo[3] = 'S'; ano[3] = 2017; visto[3] = false; rating[3] = 0;
        nItens= menuEditar(nItens,titulo,tipo,ano,visto,rating,myScanner,tamMax);
        
        Visualizar.menuVisualizar(nItens, titulo, tipo, ano, visto, rating, myScanner);
    
    myScanner.close();
    }
}

