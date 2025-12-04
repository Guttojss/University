package trabalho1;

import java.util.Scanner;

public class Visualizar {
    // Utilitários.
    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}


// Talvez refazer o menuVisualizar para que seja MultiCondicional?
// isto é, pedir todos os filtros primeiro e depois imprimir.

    public static void output(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating, int filtroAno,boolean filtroVistos,String filtroPalavra,int filtroRating )
    {
    //A maior largura do título
    int maior = 0;
    for (int i = 0; i < nItens; i++) {
        if (titulo[i] != null && titulo[i].length() > maior)
            maior = titulo[i].length();
    }

    // Cria formato dinâmico
    String formato = "%-4s %-"+maior+"s %-6s %-6s %-8s %-6s%n";

    //Cria o Cabeçalho
    System.out.printf(formato, "Nº", "Título", "Tipo", "Ano", "Visto", "Rating");

    // linha separadora
    int larguraTotal = 4 + 1 + maior + 1 + 6 + 1 + 6 + 1 + 8 + 1 + 6;
    System.out.println("-".repeat(larguraTotal));
    
    // Tabela Completa
    if(filtroVistos==false && filtroAno==0 && filtroPalavra==null && filtroRating==0)
    {
        for (int i = 0; i < nItens; i++) 
        {
            String vistoOut = visto[i] ? "X" : "O";
            if (titulo[i] != null)
            System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
        }
    }
    // Tabela por ano
    if (filtroAno!=0) 
        {
        for (int i = 0; i < nItens; i++) 
            {
            if(filtroAno==ano[i])
                {
                String vistoOut = visto[i] ? "X" : "O";
                if (titulo[i] != null)
                System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
                }
            }
        }
        // Tabela por Vistos
        if (filtroVistos==true) 
        {
        for (int i = 0; i < nItens; i++) 
            {
            if(visto[i]==false)
                {
                String vistoOut = visto[i] ? "X" : "O";
                if (titulo[i] != null)
                System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
                }
            }
        }
        // Tabela por Titulo
        if (filtroPalavra!=null) 
            {
            for (int i = 0; i < nItens; i++) 
                {
                if(titulo[i].contains(filtroPalavra))
                    {
                    String vistoOut = visto[i] ? "X" : "O";
                    if (titulo[i] != null)
                    System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
                    }
                }
            }
        // Tabela por Rating
        if (filtroRating!=0) 
        {
        for (int i = 0; i < nItens; i++) 
            {
            if(filtroRating<=rating[i])
                {
                String vistoOut = visto[i] ? "X" : "O";
                if (titulo[i] != null)
                System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
                }
            }
        }
    }

    public static void menuVisualizar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner){
        clear();
        System.out.println("Visulizar por (T)odos");
        System.out.println("Visualiar por (A)no exato"); int filtroAno = 0;
        System.out.println("Visualiar por (N)ão vistos"); boolean filtroVistos = false;
        System.out.println("Visualiar por (P)alavra no título"); String filtroPalavra=null;
        System.out.println("Visualiar por (R)ating mínimo"); int filtroRating = 0 ;
        System.out.println("Visualiar por (M)ulticritério"); // falta fazer este
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o input.
        
        switch (opcao) {
            case 'T': output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating); break;
            case 'A': System.out.println("Qual o ano?"); filtroAno = myScanner.nextInt(); 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating); break;
            case 'N': filtroVistos = true; 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating); break;
            case 'P':  System.out.println("Qual a Palavra?"); filtroPalavra = myScanner.nextLine(); 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating); break;
            case 'R': System.out.println("Qual o Rating Minmo?"); filtroRating = myScanner.nextInt(); 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating); break;
            case 'M': 
            break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;
    }
    /*public static void main(String[] args) {
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
        menuVisualizar(nItens, titulo, tipo, ano, visto, rating, myScanner);
        myScanner.close();
    }*/
}
