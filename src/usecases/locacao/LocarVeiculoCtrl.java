package usecases.locacao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.cliente.Cliente;
import domain.cliente.ClienteRepository;
import domain.locacao.LocacaoBuilder;
import domain.locacao.LocacaoRepository;
import domain.veiculo.Veiculo;
import domain.veiculo.VeiculoRepository;
import domain.Erro;


public class LocarVeiculoCtrl {

    private final ClienteRepository clienteRepo;
    private final VeiculoRepository veiculoRepo;
    private final LocacaoRepository locacaoRepo;

    public LocarVeiculoCtrl(ClienteRepository clienteRepo, VeiculoRepository veiculoRepo, LocacaoRepository locacaoRepo) {
        super();
        this.clienteRepo = clienteRepo;
        this.veiculoRepo = veiculoRepo;
        this.locacaoRepo = locacaoRepo;
    }

   
    public List<Erro> locarVeiculo(LocacaoRequest request) {
        
        List<Erro> erros = new ArrayList<>();

        try {
          
            Cliente cliente = clienteRepo.findByCPF(request.cpf());
            if (cliente == null) {
                erros.add(Erro.CLIENTE_NAO_ENCONTRADO); 
            }

           
            Veiculo veiculo = veiculoRepo.findByPlaca(request.placa());
            if (veiculo == null) {
                erros.add(Erro.VEICULO_NAO_ENCONTRADO); 
            }

            if(!erros.isEmpty())
                return erros;

            LocalDateTime data = LocalDateTime.now();
            
            var resultado = new LocacaoBuilder().withCliente(cliente)
                                                .withVeiculo(veiculo)
                                                .withData(data).build();
            if (resultado.sucesso()){
                var locacao = resultado.valor;
                locacaoRepo.add(locacao);
                return null;
            }
            else{
                return resultado.erros;
            }
        } catch (SQLException e) {
          
            return List.of(Erro.ERRO_BD);
        }
    }
}
