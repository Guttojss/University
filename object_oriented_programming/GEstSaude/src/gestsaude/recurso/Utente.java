package gestsaude.recurso;

/**
 * Representa um Utente. Deve ter um nome, o número de SNS e armazenar as
 * consultas que tem marcadas no futuro.
 */
public class Utente {

    String nome;
    String sns;
    Consulta[] consultas;
    
    private Utente(String nome, String sns,Consulta[] consultas)
    {
        this.nome = nome;
        this.sns = sns;
        this.consultas = consultas;
    }

    // Getters

    public static String getNome(Utente utente)
    {
        return utente.nome;
    }

    public static String getSNS(Utente utente)
    {
        return utente.sns;
    }

    public static Consulta[] getMarcacoes(Utente utente)
    {
        return utente.consultas;
    }

    // Setters

    public void setNome(String nome)
    {
        // Meter aqui regras sobre os nome. ex : Meter a primeira letra sempre em caps
        this.nome = nome;
    }

    public void setSNS(String SNS)
    {
        // Meter aqui regras sobre o SNS ex: Se é valido
        this.sns = SNS;
    }
    
    public void setConsultas(Consulta[] consultas)
    {
        this.consultas = consultas;
    }
}
