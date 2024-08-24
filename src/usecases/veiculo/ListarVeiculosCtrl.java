package usecases.veiculo;

import java.sql.SQLException;
import java.util.List;


import domain.Erro;
import domain.Resultado;
import domain.veiculo.Veiculo;
import domain.veiculo.VeiculoRepository;

public class ListarVeiculosCtrl {


    private final VeiculoRepository repo;
    
    public ListarVeiculosCtrl(VeiculoRepository repo){
        super();
        this.repo = repo;
    }

    public Resultado<List<Veiculo>> recuperarTodosVeiculos(String ordenacao){
        try{
            var veiculos = repo.findAll(ordenacao);

            return Resultado.ok(veiculos);
        } catch(SQLException e){
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }
    
}
