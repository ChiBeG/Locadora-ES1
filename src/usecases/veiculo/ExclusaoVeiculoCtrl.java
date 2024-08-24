package usecases.veiculo;

import java.sql.SQLException;
import java.util.List;

import domain.Erro;
import domain.veiculo.Veiculo;
import domain.veiculo.VeiculoRepository;


public class ExclusaoVeiculoCtrl {

    private final VeiculoRepository repo;

    public ExclusaoVeiculoCtrl(VeiculoRepository repo) {
        super();
        this.repo = repo;
    }

  
    public List<Erro> excluirVeiculoPorPlaca(String placa) {
        try {
         
            Veiculo veiculo = repo.findByPlaca(placa);
            
           
            if (veiculo == null) {
                return List.of(Erro.VEICULO_NAO_ENCONTRADO);
            }
            
           
            repo.remove(veiculo);
            
            return null;
        } catch (SQLException e) {
           
            return List.of(Erro.ERRO_BD);
        }
    }
}
