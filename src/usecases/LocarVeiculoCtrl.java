package usecases;

import java.sql.SQLException;
import java.util.List;
import domain.Cliente;
import domain.Veiculo;
import domain.ClienteRepository;
import domain.VeiculoRepository;
import domain.Erro;

/**
 * Classe que implementa a funcionalidade de locação de veículos
 */
public class LocarVeiculoCtrl {

    private final ClienteRepository clienteRepo;
    private final VeiculoRepository veiculoRepo;

    public LocarVeiculoCtrl(ClienteRepository clienteRepo, VeiculoRepository veiculoRepo) {
        super();
        this.clienteRepo = clienteRepo;
        this.veiculoRepo = veiculoRepo;
    }

    /**
     * Realiza a locação de um veículo.
     * 
     * @param cpf CPF do cliente
     * @param placa Placa do veículo
     * @return Lista de códigos de erro ou null em caso de sucesso
     */
    public List<Erro> locarVeiculo(Long cpf, String placa) {
        try {
            // 1 - Verifica se o cliente existe
            Cliente cliente = clienteRepo.findByCPF(cpf);
            if (cliente == null) {
                return List.of(Erro.CPF_INVALIDO); // Cliente não encontrado
            }

            // 2 - Verifica se o veículo existe
            Veiculo veiculo = veiculoRepo.findByPlaca(placa);
            if (veiculo == null) {
                return List.of(Erro.PLACA_INVALIDA); // Veículo não encontrado
            }

            // 3 - Realiza a locação (aqui você deve implementar a lógica de locação)
            // Isso pode incluir salvar a locação em um repositório de locações, 
            // marcar o veículo como alugado, etc.

            // Avisa que a locação foi bem-sucedida, retornando null para indicar que não há erros
            return null;
        } catch (SQLException e) {
            // Se ocorrer alguma exceção no BD, avisa
            return List.of(Erro.ERRO_BD);
        }
    }
}
