package trabalho1;

import java.util.Scanner;

public class trabalho1{

    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}
    
    public static void menuPrincipal()
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
            case 'V': menuVisualizar(); break;
            case 'M': menuMarcar(); break;
            case 'E': menuEditar(); break;
            case 'T': menuEstatisticas(); break;
            case 'S': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }
    
    public static void menuVisualizar(){
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
            case 'T': break;
            case 'A': break;
            case 'N': break;
            case 'P': break;
            case 'R': break;
            case 'M': break;
            case 'V': menuPrincipal(); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }

    public static void menuMarcar(){
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
            case 'V': menuPrincipal(); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }


    public static void menuEditar(){
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
            case 'V': menuPrincipal(); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;

    }
    public static void menuEstatisticas(){
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
            case 'V': menuPrincipal(); break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        myScanner.close();
        return;
    }
    public static void main(String[] args) {
        int tamMax = 100 ;
        String[] titulo = new String[tamMax];   // Nome do conteudo
        char[] tipo = new char[tamMax];         // Se é Filme(F) Ou Série (S)
        int[] ano = new int[tamMax];            // Ano de lançamento
        boolean[] visto = new boolean[tamMax];  // Se foi visto ou não
        int[] rating = new int[tamMax];         // Classificação da conteudo
        int nItens = 0;
        menuPrincipal();
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