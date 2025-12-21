package trabalho1;

import java.util.Scanner;
public class trabalho1{
    // Utilitários.
    //Limpa o CMD.
    public static void clear(){System.out.println("\n\n\n\n\n\n\n\n\n\n\n");}

    //Leitura de Ints.
    public static int lerInt(int minimo,int maximo,Scanner myScanner){
        int inteiro=0;
        while (true) 
        {
            inteiro = myScanner.nextInt();
            if (inteiro >= minimo && inteiro<=maximo) 
            {
                return inteiro;
            } 
            else 
            {
                System.out.print("Erro: Escreva um inteiro dentro dos limites. ");
            }
        }
    }
    //Leitura de Bools.
    public static boolean lerBool(Scanner myScanner){
        String bool=null;
        while (true) 
        {
            bool = myScanner.nextLine().trim().toLowerCase();
            if (bool=="true" || bool=="sim" || bool=="yes" || bool=="y" || bool=="x") 
            {
                return true;
            }else 
            if(bool=="no" || bool=="nao" || bool=="não" || bool=="n" || bool=="false" || bool=="o") 
                return false;
            else 
            {
                System.out.print("Erro: Escreva algo válido.");
            }
        }
    }

        public static char lerTipo(Scanner myScanner){
        String carac=null;
        while (true) 
        {
            carac = myScanner.nextLine().toLowerCase();
            if (carac=="filme" || carac=="f") 
            {
                return 'f';
            }else 
            if(carac=="serie" || carac=="série" || carac=="s") 
                return 's';
            else 
            {
                System.out.print("Erro: Escreva algo válido.");
            }
        }
    }


    //Menus e Metodos dos Menus.

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
                tipo[nItens] = lerTipo(myScanner);
                System.out.println("Qual o ano de lançamento?");
                ano[nItens] = lerInt(0,2040,myScanner);
                System.out.println("Já foi visto?");
                visto[nItens] = lerBool(myScanner);
                System.out.println("Qual a nota de 0 a 10?");
                rating[nItens] = lerInt(0,10,myScanner);
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
                        tipo[pos] = lerTipo(myScanner);
                        System.out.println("Qual o ano de lançamento?");
                        ano[pos] = lerInt(0,2040, myScanner);
                        System.out.println("Já foi visto?");
                        visto[pos] = lerBool(myScanner);
                        System.out.println("Qual a nota de 0 a 10?");
                        rating[pos] = lerInt(0, 10, myScanner);
                        nItens++;
                    }
                    
                } else System.out.println("Atingiu o limite de Itens.");
            }
        }
        return nItens;
    }
    // Apaga arrays
    public static int apagar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,int pos)
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

    public static void marcar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,int pos,String nome, Scanner myScanner,int id,int ultimovisto)
    {
        // Marca como visto por posição.
        if(pos!=0)
            if(titulo[pos]!=null)
                visto[pos]=true;

        if(nome!=null)
        {
        //Chama menu visualizar por titulo com filtro nome.
        System.out.println("Qual é a posição do Item?");
        pos=lerInt(-1, 100, myScanner);
        visto[pos]=true; 
        }

         //alterar por id
         if(id!=-1)
         {
            System.out.println("Qual é o novo rating?");
            rating[id]=lerInt(0, 10, myScanner);
         }

         //Ultimo como visto.
         if(ultimovisto!=0)
         {
            for(int i=0;i!=nItens;i++)
                if(visto[i]!=false)
                    ultimovisto=i;
            visto[ultimovisto]=false;
         }
    }

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


    public static void destribuicaoDecada(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,int tamMax)
    {
        int[] anoTemp = new int[tamMax];

        int ano_maior=0;
        int ano_menor=9999;
        for(int i=0;i<nItens;i++)
        {   
            //Verificar os décimais exemplo 1992 -> 199,2 logo -> 1990
            anoTemp[i] = (ano[i]/10)*10;
            //Descobre o menor e maior ano.
            if(anoTemp[i]>ano_maior) { ano_maior=anoTemp[i]; }
            if(anoTemp[i]<ano_menor) { ano_menor=anoTemp[i]; }
        }

        //Conta os itens por decada
        for(int d=ano_menor;d<=ano_maior;d=d+10)
        {
            int contAno=0;
            for(int i=0;i!=nItens;i++)
            {
                
                if(anoTemp[i]==d) contAno++;
            }
            // Dá output
            if(contAno>0)
                {
                    System.out.printf("%d -> %d | %d Itens \n",d,d+9,contAno);
                }
        } 
    }
    
    
    
    public static void menuVisualizar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner){
        clear();
        System.out.println("Visulizar por (T)odos"); char filtroTipo=' ';
        System.out.println("Visualiar por (A)no exato"); int filtroAno = 0;
        System.out.println("Visualiar por (N)ão vistos"); boolean filtroVistos = false;
        System.out.println("Visualiar por (P)alavra no título"); String filtroPalavra=null;
        System.out.println("Visualiar por (R)ating mínimo"); int filtroRating = 0 ;
        System.out.println("Visualiar por (M)ulticritério"); int multi=0;
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o input.
        
        switch (opcao) {
            case 'T': output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating, multi,filtroTipo); break;
            case 'A': System.out.println("Qual o ano?"); filtroAno = lerInt(0, 2040, myScanner); 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating, multi,filtroTipo); break;
            case 'N': filtroVistos = true; 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating, multi,filtroTipo); break;
            case 'P':  System.out.println("Qual a Palavra?"); filtroPalavra = myScanner.nextLine(); 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating, multi,filtroTipo); break;
            case 'R': System.out.println("Qual o Rating Minmo?"); filtroRating = lerInt(0, 10, myScanner); 
            output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating, multi,filtroTipo); break;
            case 'M': menuMulticriterios(nItens,titulo,tipo,ano,visto,rating,myScanner,multi); break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;
    }
    public static void menuMulticriterios(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner,int multi)
    {
        char opcao;
        String filtroPalavra=null;
        int filtroAno = 0;
        char filtroTipo=' ';
        boolean filtroVistos = false;
        int filtroRating = 0 ;
        do
        {
        System.out.println("Visualiar por (P)alavra no título"); 
        System.out.println("Visualiar por (A)no exato"); 
        System.out.println("Visualizar por (T)ipo"); 
        System.out.println("Visualiar por (N)ão Vistos"); 
        System.out.println("Visualiar por (R)ating mínimo"); 
        System.out.println("(V)oltar");
        System.out.println("Quando acabar de escolher, use o \"(V)oltar\"");
        opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o input.

        switch (opcao) {
            case 'P': System.out.println("Qual a Palavra?"); filtroPalavra = myScanner.nextLine();break;
            case 'A': System.out.println("Qual o ano?"); filtroAno = lerInt(0, 2040, myScanner); break;
            case 'T': System.out.println("Qual o tipo"); filtroTipo=lerTipo(myScanner); break;
            case 'N': filtroVistos = true; break;
            case 'R': System.out.println("Qual o Rating Minmo?"); filtroRating = lerInt(0, 10, myScanner);break;
            default:
                System.out.println("Insira uma opcão válida.");break;
        }
        }while(opcao!='V');
        output(nItens,titulo,tipo,ano,visto,rating,filtroAno,filtroVistos,filtroPalavra,filtroRating, multi,filtroTipo);
    }

    public static int menuMarcar(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner)
    {
        clear();
        System.out.println("Marcar como visto por (P)osição"); int pos = 0; 
        System.out.println("Marcar como visto por (T)itulo"); String nome=null;
        System.out.println("(D)esamarcar último marcado como visto"); int uvisto=0;
        System.out.println("(A)atribuir / alterar rating por número"); int id=-1;
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o input.
        
        switch (opcao) {
            case 'P': System.out.println("Qual é a posição?"); pos = lerInt(0, 100, myScanner);
            marcar(nItens, titulo, tipo, ano, visto, rating, pos-1, nome,myScanner,id,uvisto);break;
            case 'T': System.out.println("Qual é o Titulo?"); nome = myScanner.nextLine();
            marcar(nItens, titulo, tipo, ano, visto, rating, pos, nome,myScanner,id,uvisto);break;
            case 'D': uvisto=-1; marcar(nItens, titulo, tipo, ano, visto, rating, pos, nome,myScanner,id,uvisto);break;
            case 'A': System.out.println("Qual é o numero?"); id = lerInt(0, 100, myScanner);
            marcar(nItens, titulo, tipo, ano, visto, rating, pos, nome,myScanner,id,uvisto);break;
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return 0;
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
            nItens=apagar(nItens, titulo, tipo, ano, visto, rating, pos); break;
            case 'N': pos=-1; nItens=apagar(nItens, titulo, tipo, ano, visto, rating,pos); break;
            case 'V': break;
            default:  System.out.println("Escreva um caracter Válido"); break;
        }
        return nItens;

    }
    public static void menuEstatisticas(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating,Scanner myScanner,int tamMax){
        clear();
        System.out.println("(P)ercentagem de vistos");
        System.out.println("(M)édia de rating dos vistos");
        System.out.println("Destribuição por (D)écada");
        System.out.println("(V)oltar");
        char opcao = myScanner.next().toUpperCase().charAt(0);
        myScanner.nextLine(); // Limpa o input.
        
        switch (opcao) {
            case 'P': percentagemVistos(nItens, titulo, tipo, ano, visto, rating); break;
            case 'M': mediaRating(nItens, titulo, tipo, ano, visto, rating); break;
            case 'D': destribuicaoDecada(nItens, titulo, tipo, ano, visto, rating,tamMax);break; // faço depois
            case 'V': break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        return;
    }

    public static void output(int nItens,String[] titulo,char[] tipo,int[] ano,boolean[] visto,int[] rating, int filtroAno,boolean filtroVistos,String filtroPalavra,int filtroRating,int multi, char filtroTipo)
    {
        if(nItens<0)
            System.out.println("Não há itens!");
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
    if(filtroVistos==false && filtroAno==0 && filtroPalavra==null && filtroRating==0 && multi==0)
    {
        for (int i = 0; i < nItens; i++) 
        {
            String vistoOut = visto[i] ? "X" : "O";
            if (titulo[i] != null)
            System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
        }
    }
    //MultiCondional
    if(multi==1)
    {
        for (int i = 0; i < nItens; i++) 
                {
                if(titulo[i].contains(filtroPalavra)  || ano[i] == filtroAno || tipo[i]==filtroTipo || visto[i]==filtroVistos || rating[i] >= filtroRating )
                    {
                    String vistoOut = visto[i] ? "X" : "O";
                    if (titulo[i] != null)
                    System.out.printf(formato, i + 1, titulo[i], tipo[i], ano[i], vistoOut, rating[i]);
                    }
                }
    }
    else 
    {
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
        do{
        clear();
        char opcao;
        System.out.println("\n\n");
        System.out.println("(V)isualizar");
        System.out.println("(M)arcar / Classificar");
        System.out.println("(E)ditar");
        System.out.println("es(T)atisticas");
        System.out.println("(S)air");
        opcao = myScanner.next().toUpperCase().charAt(0);
        
        switch (opcao) {
            case 'V': menuVisualizar(nItens,titulo,tipo,ano,visto,rating,myScanner); break; // Falta Output Condional
            case 'M': menuMarcar(nItens,titulo,tipo,ano,visto,rating,myScanner); break; //
            case 'E': nItens=menuEditar(nItens,titulo,tipo,ano,visto,rating,myScanner,tamMax); break; // Falta Proteção de dados
            case 'T': menuEstatisticas(nItens,titulo,tipo,ano,visto,rating,myScanner,tamMax); break; // Finalizado
            case 'S': nItens=-1; break;
            default:
                System.out.println("Escreva um caracter Válido");break;
        }
        }
        while(nItens!=-1);

        myScanner.close();
    }
}