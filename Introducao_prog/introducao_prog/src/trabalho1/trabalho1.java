package trabalho1;

import java.util.Scanner;

public class trabalho1{

    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}
    public static void espaco(){System.out.print("    ");}
    
    public static void menuPrincipal(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating)
    {
        clear();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("(V)isualizar");
        System.out.println("(M)arcar / Classificar");
        System.out.println("(E)ditar");
        System.out.println("es(T)atisticas");
        System.out.println("(S)air");
        char opcao = myScanner.next().charAt(0);
        
        switch (opcao) {
            case 'V': menuVisualizar(nItens,titulo,tipo,ano,visto,rating); break;
            case 'M': menuMarcar(nItens,titulo,tipo,ano,visto,rating); break;
            case 'E': menuEditar(nItens,titulo,tipo,ano,visto,rating); break;
            case 'T': menuEstatisticas(nItens,titulo,tipo,ano,visto,rating); break;
            case 'S': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }
    
    public static void menuVisualizar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating){
        clear();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Visulizar por (T)odos");
        System.out.println("Visualiar por (A)no exato");
        System.out.println("Visualiar por (N)ão vistos");
        System.out.println("Visualiar por (P)alavra no título");
        System.out.println("Visualiar por (R)ating mínimo");
        System.out.println("Visualiar por (M)ulticritério");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().charAt(0);
        
        switch (opcao) {
            case 'T': output(nItens,titulo,tipo,ano,visto,rating); break;
            case 'A': break;
            case 'N': break;
            case 'P': break;
            case 'R': break;
            case 'M': break;
            case 'V': menuPrincipal(nItens,titulo,tipo,ano,visto,rating); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }

    public static void menuMarcar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating){
        clear();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Marcar como visto por (P)osição");
        System.out.println("Marcar como visto por (T)itulo");
        System.out.println("(D)esamarcar último marcado como visto");
        System.out.println("(A)atribuir / alterar rating por número");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().charAt(0);
        
        switch (opcao) {
            case 'P': break;
            case 'T': break;
            case 'D': break;
            case 'A': break;
            case 'V': menuPrincipal(nItens,titulo,tipo,ano,visto,rating); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }


    public static void menuEditar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating){
        clear();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("(A)dicionar  item no fim");
        System.out.println("Adicionar (I)tem na posição n");
        System.out.println("Apagar item na (P)osição n");
        System.out.println("Apagar ite(N)s vistos");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().charAt(0);
        
        switch (opcao) {
            case 'A': break;
            case 'I': break;
            case 'P': break;
            case 'N': break;
            case 'V': menuPrincipal(nItens,titulo,tipo,ano,visto,rating); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;

    }
    public static void menuEstatisticas(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating){
        clear();
         Scanner myScanner = new Scanner(System.in);
        System.out.println("(P)ercentagem de vistos");
        System.out.println("(M)édia de rating dos vistos");
        System.out.println("Destribuição por (D)écada");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().charAt(0);
        
        switch (opcao) {
            case 'P': break;
            case 'M': break;
            case 'D': break;
            case 'V': menuPrincipal(nItens,titulo,tipo,ano,visto,rating); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }

    public static void output(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating){
        System.out.print("Nº");espaco();
        System.out.print("Título");espaco();
        System.out.print("Tipo");espaco();
        System.out.print("Ano");espaco();
        System.out.print("Visto");espaco();
        System.out.print("Rating");System.out.println();
        System.out.println("-----------------------------------------------");
        for(int i=0;i!=nItens;i++)
        {
            System.out.print(i+1+"    "+titulo[i]+"   "+tipo[i]+"   "+ano[i]+"    "+visto[i]+"   "+rating[i]);

            System.out.println();
        }
    };
    public static void main(String[] args) {
        int tamMax = 100 ;
        String[] titulo = new String[tamMax];   // Nome do conteudo
        char[] tipo = new char[tamMax];         // Se é Filme(F) Ou Série (S)
        int[] ano = new int[tamMax];            // Ano de lançamento
        boolean[] visto = new boolean[tamMax];  // Se foi visto ou não
        int[] rating = new int[tamMax];         // Classificação da conteudo
        int nItens = 4;
       // menuPrincipal(nItens,titulo,tipo,ano,visto,rating);

        titulo[0] = "The Matrix"; tipo[0] = 'F'; ano[0] = 1999; visto[0] = true; rating[0] = 9;
        titulo[1] = "Breaking Bad"; tipo[1] = 'S'; ano[1] = 2008; visto[1] = true; rating[1] = 10;
        titulo[2] = "Oppenheimer"; tipo[2] = 'F'; ano[2] = 2023; visto[2] = false; rating[2] = 0;
        titulo[3] = "Dark"; tipo[3] = 'S'; ano[3] = 2017; visto[3] = false; rating[3] = 0;

       output(nItens,titulo,tipo,ano,visto,rating);
    }

}

/*
Enunciado:
O MyMediaManager é a primeira versão de uma aplicação simples de gestão de conteúdos multimédia 
(filmes e séries). Um conteúdo ou item é descrito por um título (String), um tipo (filme ou série),
um ano de lançamento (inteiro), informação sobre se já foi ou não visto e uma classificação opcional
atribuída pelo utilizador (valor de 1 a 10; 0 significa “sem classificação”).
O programa deve permitir criar e editar os itens, marcar e desmarcar itens como vistos, 
atribuir/alterar classificações e visualizar a lista de diferentes formas (filtros e pesquisas).
A informação necessária à gestão da aplicação deve ser guardada em diversos arrays, assumindo uma
lista com um máximo de 100 itens. A presença e utilização deste segmento de código no trabalho é 
obrigatória:
*/


/*
Nº   Título          Tipo    Ano     Visto   Rating
----------------------------------------------------------
1    The Matrix      F      1999        X       9
2    Breaking Bad    S      2008        X       10
3    Oppenheimer     F      2023        0       
4    Dark            S      2017        0       
*/