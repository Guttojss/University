package ficha1;

public class exercicio2 {
    
    static void Hello(){
        System.out.println("Olá Alunos!\n\nBem Vindos á disciplina de \"Algoritmia e Programação\"");
    }

    static void Creditos(){
        /* Objetivo Final : 
            ***************************************
            * Programa elaborado por:             *
            * nome 1                              *
            * nome 2                              *
            *************************************** 
        */
        int coluna=24, linha=4;
        for(int i=0; i!=coluna; i++){
            System.out.print("*");  
        }
        for(int j=0; j!=linha; j++) {
                System.out.println("*");
            }

        for(int i=-1; i!=coluna; i++){
            System.out.print("*");  
        }
    }
    public static void main(String[] args) {
        Hello();
      //  Creditos();
        

    }
}
