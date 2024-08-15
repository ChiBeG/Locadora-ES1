package usecases;

import java.sql.SQLException;
import java.util.List;

import domain.Erro;
import domain.VeiculoBuilder;
import domain.VeiculoRepository;

public class CadastroVeiculoCtrl {
    
    private final VeiculoRepository repo;

    public CadastroVeiculoCtrl(VeiculoRepository repo){
        super();
        this.repo = repo;
    }


    public List<Erro> cadastrarVeiculo(VeiculoRequest request){
        
        try{
            var resultado = new VeiculoBuilder().withPlaca(request.codigoPlaca())
                                                .withModelo(request.modelo())
                                                .withAnoFabricacao(request.anoFabricacao())
                                                .withDiaria(request.diaria())
                                                .withQuilometragem(request.quilometragem())
                                                .build();
            if (resultado.sucesso()){

                var veiculo = resultado.valor;

                var outroVeiculo = repo.findByPlaca(veiculo.getPlaca().codigo);

                if (outroVeiculo != null)
                    return List.of(Erro.PLACA_JA_EXISTENTE);

                repo.add(veiculo);

                return null;
            }
            else{
                return resultado.erros;
            }
        }catch (SQLException e){
            return List.of(Erro.ERRO_BD);
        }
    }
}
