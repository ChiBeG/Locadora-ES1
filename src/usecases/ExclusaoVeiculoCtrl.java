package usecases;

import java.sql.SQLException;
import java.util.List;
import domain.Veiculo;
import domain.VeiculoRepository;
import domain.Erro;

/**
 * Classe que implementa a funcionalidade de exclusão de veículos
 */
public class ExclusaoVeiculoCtrl {

    private final VeiculoRepository repo;

    public ExclusaoVeiculoCtrl(VeiculoRepository repo) {
        super();
        this.repo = repo;
    }

    /**
     * Exclui um veículo com base na placa.
     * 
     * @param placa Código da placa do veículo
     * @return Lista de códigos de erro ou null em caso de sucesso
     */
    public List<Erro> excluirVeiculoPorPlaca(String placa) {
        try {
            // 1 - Busca o veículo pela placa
            Veiculo veiculo = repo.findByPlaca(placa);
            
            // 2 - Verifica se o veículo existe 
            if (veiculo == null) {
                return List.of(Erro.VEICULO_NAO_ENCONTRADO);
            }
            
            // 3 - Remove o veículo do repositório
            repo.remove(veiculo);
            
            // 4 - Avisa que a exclusão foi bem-sucedida, retornando null para indicar que não há erros
            return null;
        } catch (SQLException e) {
            // Se ocorrer alguma exceção no BD, avisa
            return List.of(Erro.ERRO_BD);
        }
    }
}
