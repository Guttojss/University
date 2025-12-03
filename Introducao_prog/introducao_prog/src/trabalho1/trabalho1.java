package trabalho1;

import java.util.Scanner;

/*
        To-Do
- Proteção de dados
    - Menus : transformar as minusculas em MAIOSCULAS.
    - Inputs : Anos terem 4 digitos.
    - Inputs : Filmes / Série apenas aceitar "F,f,S,s" e transformar em minusculas.
    - Inputs : Visto aceitar "S,s,N,n" ou "x,X,o,O" onde S,X = true e N,O = false.s
    - Inputs : Rating aceitar apenas de 0 a 10.
- Funcionalidades todas praticamente


Dúvidas : 
Não podemos ter o Scanner como váriavel global?

*/

public class trabalho1{
    // Utilitários.
    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}
    /*
    // Adiciona Conteudos aos arrays.
    public static int adicionar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating, Scanner myScanner)
    {
        clear();
        nItens+=1;
        System.out.println("Qual o Título : ");
        titulo[nItens] = myScanner.nextLine();
        System.out.println("É uma série ou um filme?");
        tipo[nItens] = myScanner.next().charAt(0);
        System.out.println("Qual o ano de lançamento?");
        ano[nItens] = myScanner.nextInt();
        System.out.println("Já foi visto?");
        visto[nItens] = myScanner.nextBoolean();
        System.out.println("Qual a nota de 0 a 10?");
        rating[nItens] = myScanner.nextInt();
        System.out.println("Item Adicionado com sucesso!");
        menuPrincipal(nItens, titulo, tipo, ano, visto, rating,myScanner);
        return nItens;
    }
    */

    // Menu Principal.
    public static void menuPrincipal(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner)
    {
        char opcao;
        do {
        clear();
        System.out.println("(V)isualizar");
        System.out.println("(M)arcar / Classificar");
        System.out.println("(E)ditar");
        System.out.println("es(T)atisticas");
        System.out.println("(S)air");
        opcao = myScanner.next().toUpperCase().charAt(0);
        
        switch (opcao) {
            case 'V': menuVisualizar(nItens,titulo,tipo,ano,visto,rating,myScanner); break;
            case 'M': menuMarcar(nItens,titulo,tipo,ano,visto,rating,myScanner); break;
            case 'E': menuEditar(nItens,titulo,tipo,ano,visto,rating,myScanner); break;
            case 'T': menuEstatisticas(nItens,titulo,tipo,ano,visto,rating,myScanner); break;
            case 'S': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        }while(opcao!='S');
        return;
    }
    
    public static void menuVisualizar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner){
        clear();
        System.out.println("Visulizar por (T)odos");
        System.out.println("Visualiar por (A)no exato");
        System.out.println("Visualiar por (N)ão vistos");
        System.out.println("Visualiar por (P)alavra no título");
        System.out.println("Visualiar por (R)ating mínimo");
        System.out.println("Visualiar por (M)ulticritério");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        
        switch (opcao) {
            case 'T': output(nItens,titulo,tipo,ano,visto,rating); break;
            case 'A': break;
            case 'N': break;
            case 'P': break;
            case 'R': break;
            case 'M': break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;
    }

    public static void menuMarcar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner){
        clear();
        System.out.println("Marcar como visto por (P)osição");
        System.out.println("Marcar como visto por (T)itulo");
        System.out.println("(D)esamarcar último marcado como visto");
        System.out.println("(A)atribuir / alterar rating por número");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        
        switch (opcao) {
            case 'P': break;
            case 'T': break;
            case 'D': break;
            case 'A': break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;
    }


    public static void menuEditar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner){
        clear();
        System.out.println("(A)dicionar  item no fim");
        System.out.println("Adicionar (I)tem na posição n");
        System.out.println("Apagar item na (P)osição n");
        System.out.println("Apagar ite(N)s vistos");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        
        switch (opcao) {
            case 'A': /*adicionar(nItens, titulo, tipo, ano, visto, rating,myScanner);*/break;
            case 'I': break;
            case 'P': break;
            case 'N': break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;

    }
    public static void menuEstatisticas(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner){
        clear();
        System.out.println("(P)ercentagem de vistos");
        System.out.println("(M)édia de rating dos vistos");
        System.out.println("Destribuição por (D)écada");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        
        switch (opcao) {
            case 'P': break;
            case 'M': break;
            case 'D': break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;
    }

    public static void output(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating)
    {
    // 1. Descobrir a maior largura do título
    int maior = 0;
    for (int i = 0; i < nItens; i++) {
        if (titulo[i] != null && titulo[i].length() > maior)
            maior = titulo[i].length();
    }

    // 2. Criar formato dinâmico
    // %-Xs  → string alinhada à esquerda com X caracteres
    String formato = "%-4s %-"+maior+"s %-6s %-6s %-8s %-6s%n";

    // 3. Cabeçalho
    System.out.printf(formato, "Nº", "Título", "Tipo", "Ano", "Visto", "Rating");

    // linha separadora
    int larguraTotal = 4 + 1 + maior + 1 + 6 + 1 + 6 + 1 + 8 + 1 + 6;
    System.out.println("-".repeat(larguraTotal));

    // 4. Linhas da tabela
    for (int i = 0; i < nItens; i++) {
        String vistoOut = visto[i] ? "X" : "O";
        if (titulo[i] != null)
            System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
        
        //System.out.printf(formato,String.valueOf(i + 1),titulo[i],String.valueOf(tipo[i]),String.valueOf(ano[i]),vistoOut,String.valueOf(rating[i]));
    }

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

        menuPrincipal(nItens,titulo,tipo,ano,visto,rating,myScanner);
        myScanner.close();
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
lista com um máximo de 100 itens.
 */