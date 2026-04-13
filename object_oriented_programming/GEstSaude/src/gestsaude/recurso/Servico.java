package gestsaude.recurso;

import java.util.Collection;

/**
 * Representa um serviço. Deve ter o id, uma descrição, a sala. Deve ter uma
 * lista das senhas que ainda terão de ser atendidas.
 */
public class Servico {

    /**
     * Retorna a próxima senha a ser atendida por este serviço
     * 
     * @return a próxima senha a ser atendida por este serviço, null se não tiver
     *         mais senhas
     */
    public Senha getProximaSenha() {
        // TODO implementar este método
        return null;
    }

    /**
     * o utente não responde à chamada? A sua senha passa para o fim da lista.
     */
    public void saltaProximaSenha() {
        // TODO implementar este método
    }

    /**
     * a senha termina a consulta neste serviço
     * 
     * @param s a senha que terminou o serviço
     */
    public void terminaConsulta(Senha s) {
        // TODO implementar este método
    }

    /**
     * Retorna as senhas que estão em lista de espera para serem atendidas neste
     * serviço
     * 
     * @return as senhas que estão em lista de espera para serem atendidas
     */
    public Collection<Senha> getEmEspera() {
        // TODO implementar este método
        return null;
    }
}
