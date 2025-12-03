package trabalho1;

import java.util.Scanner;

// Objetivo Fazer todos os outputs em um método : Geral | Ano | Título | Rating | Multicritérios
public class trabalho2 {
    public static String tabela(int nItens,String[] titulo){
        //Maior título
    int maior = 0;
    for (int i = 0; i < nItens; i++) {
        if (titulo[i] != null && titulo[i].length() > maior)
            maior = titulo[i].length();
    }

    //Formato dinâmico
    // %-Xs  → string alinhada à esquerda com X caracteres
    String formato = "%-4s %-"+maior+"s %-6s %-6s %-8s %-6s%n";

    //Cabeçalho
    System.out.printf(formato, "Nº", "Título", "Tipo", "Ano", "Visto", "Rating");

    //linha separadora
    int larguraTotal = 4 + 1 + maior + 1 + 6 + 1 + 6 + 1 + 8 + 1 + 6;
    System.out.println("-".repeat(larguraTotal));
    return formato;
    }
    
    
    public static void output(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner)
    {
        //System.out.println("Quer imprimir TODOS?");
        //boolean filtroTodos = myScanner.nextBoolean();

        System.out.println("Quer pesquisar por ANO?");
        int filtroAno = myScanner.nextInt();
        
        //System.out.println("Quer pesquisar os que NAO VIU?");
        //boolean filtroVistos = myScanner.nextBoolean();

        //System.out.println("Quer pesquisar pelo Titulo?");
        //String filtroTitulo = myScanner.nextLine();

        //System.out.println("Quer pesquisar pelo RATING?");
        //int filtroRating = myScanner.nextInt();


    String formato = tabela(nItens, titulo);
    
    /*if(filtroTodos==true)
    {
    // Mostra a Tabela completa
    for (int i = 0; i < nItens; i++) {
        String vistoOut = visto[i] ? "X" : "O";
        if (titulo[i] != null)
            System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]); 
        }
    }
    //Output os que não foram vistos
    if(filtroVistos==true)
        {
        for (int i = 0; i < nItens; i++) 
            {
            if(visto[i]==false) 
                {
                if (titulo[i] != null) 
                    {
                    String vistoOut = "O";
                    System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i],vistoOut, rating[i]); 
                    }
                }
            }
        }
        // Output pelo Rating
    if(filtroRating!=0)
        {
        for (int i = 0; i < nItens; i++) 
        {
        if(rating[i]>= filtroRating) 
            {
            if (titulo[i] != null) 
                {
                String vistoOut = visto[i] ? "X" : "O";
                System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i],vistoOut, rating[i]); 
                }
            }
        }
        } */
    if(filtroAno!=0)
        {
        for (int i = 0; i < nItens; i++) 
        {
        if(ano[i]==filtroAno) 
            {
            if (titulo[i] != null) 
                {
                String vistoOut = visto[i] ? "X" : "O";
                System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i],vistoOut, rating[i]); 
                }
            }
        }
        }
    }  //System.out.printf(formato,String.valueOf(i + 1),titulo[i],String.valueOf(tipo[i]),String.valueOf(ano[i]),vistoOut,String.valueOf(rating[i]));

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
        output(nItens, titulo, tipo, ano, visto, rating,myScanner);
        myScanner.close();
    }
}
