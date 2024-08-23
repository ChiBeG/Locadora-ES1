package usecases;

import java.sql.SQLException;
import java.util.List;
import domain.Cliente;
import domain.ClienteRepository;
import domain.Erro;

/**
 * Classe que implementa a funcionalidade de exclusão de clientes
 */
public class ExclusaoClienteCtrl {

    private final ClienteRepository repo;

    public ExclusaoClienteCtrl(ClienteRepository repo) {
        super();
        this.repo = repo;
    }

    /**
     * Exclui um cliente com base no CPF.
     * 
     * @param cpf CPF do cliente
     * @return Lista de códigos de erro ou null em caso de sucesso
     */
    public List<Erro> excluirClientePorCPF(Long cpf) {
        try {
            // 1 - Busca o cliente pelo CPF
            Cliente cliente = repo.findByCPF(cpf);
            
            // 2 - Verifica se o cliente existe
            if (cliente == null) {
                return List.of(Erro.CPF_INVALIDO); // Ou você pode criar um erro específico como CLIENTE_NAO_ENCONTRADO
            }
            
            // 3 - Remove o cliente do repositório
            repo.remove(cliente);
            
            // 4 - Avisa que a exclusão foi bem-sucedida, retornando null para indicar que não há erros
            return null;
        } catch (SQLException e) {
            // Se ocorrer alguma exceção no BD, avisa
            return List.of(Erro.ERRO_BD);
        }
    }
}