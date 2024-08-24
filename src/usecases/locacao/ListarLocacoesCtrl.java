package usecases.locacao;

import java.util.List;

import domain.Resultado;
import domain.cliente.ClienteRepository;
import domain.locacao.Locacao;
import domain.locacao.LocacaoRepository;
import domain.veiculo.VeiculoRepository;

public class ListarLocacoesCtrl {
    private final LocacaoRepository locacaoRepo;
    private final VeiculoRepository veiculoRepo;
    private final ClienteRepository clienteRepository;

    public ListarLocacoesCtrl(LocacaoRepository locacaoRepository, VeiculoRepository veiculoRepository, ClienteRepository clienteRepository){
        super();
        this.locacaoRepo = locacaoRepository;
        this.clienteRepository = clienteRepository;
        this.veiculoRepo = veiculoRepository;
    }

    // public Resultado<List<Locacao>> recuperarTodasLocacoes(){
    //     try{
    //         var locacoes = locacaoRepo.findAll();
    //     }
    }

}
