package gestsaude.recurso;

import java.util.Collection;

/**
 * Representa um Utente. Deve ter um nome, o número de SNS e armazenar as
 * consultas que tem marcadas no futuro.
 */
public class Utente {

    String nome;
    String sns;
    Collection<Consulta> consultas;
    
    private Utente(String nome, String sns,Collection<Consulta> consultas)
    {
        this.nome = nome;
        this.sns = sns;
        this.consultas = consultas;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getSNS()
    {
        return this.sns;
    }

    public Collection<Consulta> getMarcacoes()
    {
        return this.consultas ;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setSNS(String SNS)
    {
        this.sns = SNS;
    }
    
    public void setConsultas(Collection<Consulta> consultas)
    {
        this.consultas = consultas;
    }
}
