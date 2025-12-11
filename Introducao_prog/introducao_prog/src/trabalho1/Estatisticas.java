package trabalho1;

import java.util.Scanner;

public class Estatisticas {

    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}
    public static void mediaRating(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating)
    {
        int soma = 0;
        int qnt = 0;
        for(int i=0;i!=nItens;i++)
        {
            if(visto[i]==true)
            {
                soma = rating[i] + soma;
                qnt++;
            }
        }
        System.out.println("A Média dos ratings dos itens vistos é : "+ (double) soma/qnt);
    }
     public static void percentagemVistos(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating)
    {
        double soma=0;
        for(int i=0;i!=nItens;i++)
        {
            if(visto[i]==true)
            {
                soma++;
            }
        }
        double percetagem = soma/nItens;
        System.out.println("A percetagem de itens vistos é : "+percetagem*100+"%" );
    }


    public static void destribuicaoDecada(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating)
    {
        for(int i=0;i!=nItens;i++)
        {
            // Preciso saber o ano mais baixo e mais alto.
        }
    }

    public static void menuEstatisticas(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner){
        clear();
        System.out.println("(P)ercentagem de vistos");
        System.out.println("(M)édia de rating dos vistos");
        System.out.println("Destribuição por (D)écada"); // faço depois
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o input.
        
        switch (opcao) {
            case 'P': percentagemVistos(nItens, titulo, tipo, ano, visto, rating); break;
            case 'M': mediaRating(nItens, titulo, tipo, ano, visto, rating); break;
            case 'D': break; // faço depois
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;
    }




    public static void main(String[] args) 
    {
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
        menuEstatisticas(nItens, titulo, tipo, ano, visto, rating, myScanner);

        myScanner.close();
    }
}
