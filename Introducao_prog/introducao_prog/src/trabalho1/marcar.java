package trabalho1;

import java.util.Scanner;



public class marcar {
    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}


    public static void marcar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,int pos,String nome, Scanner myScanner,int id)
    {
        // Marca como visto por posição.
        if(pos!=0)
            if(titulo[pos]!=null)
                visto[pos]=true;

        //if(nome!=null)
            // chama a função Visualizar por Titulo.
         // pede o Id ao utilizador do item certo.
         // faz visto[id]=true;

         //alterar por id
         if(id!=-1)
         {
            System.out.println("Qual é o novo rating?");
            rating[id]=myScanner.nextInt();
         }

         //Ultimo como visto.
         if(ultimovisto!=0)
         {
            for(int i=0;i!=nItens;i++)
                if(visto[i]!=false)
                    //
         }
    }

    public static int menuMarcar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner)
    {
        clear();
        System.out.println("Marcar como visto por (P)osição"); int pos = 0; 
        System.out.println("Marcar como visto por (T)itulo"); String nome=null;
        System.out.println("(D)esamarcar último marcado como visto");
        System.out.println("(A)atribuir / alterar rating por número"); int id=-1;
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o input.
        
        switch (opcao) {
            case 'P': System.out.println("Qual é a posição?"); pos = myScanner.nextInt();
            marcar(nItens, titulo, tipo, ano, visto, rating, pos, nome,myScanner,id);break;
            case 'T': System.out.println("Qual é o Titulo?"); nome = myScanner.nextLine();
            marcar(nItens, titulo, tipo, ano, visto, rating, pos, nome,myScanner,id);break;
            case 'D': break;
            case 'A': System.out.println("Qual é o numero?"); id = myScanner.nextInt();
            marcar(nItens, titulo, tipo, ano, visto, rating, pos, nome,myScanner,id);break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return 0;
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
    
    Visualizar.menuVisualizar(nItens, titulo, tipo, ano, visto, rating, myScanner);
    
    myScanner.close();
    }
}


}
