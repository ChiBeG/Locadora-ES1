package usecases;

import java.sql.SQLException;
import java.util.List;


import domain.Erro;
import domain.Resultado;
import domain.Veiculo;
import domain.VeiculoRepository;

public class ListarVeiculosCtrl {


    private final VeiculoRepository repo;
    
    public ListarVeiculosCtrl(VeiculoRepository repo){
        super();
        this.repo = repo;
    }

    public Resultado<List<Veiculo>> recuperarTodosVeiculos(){
        try{
            var veiculos = repo.findAll();

            return Resultado.ok(veiculos);
        } catch(SQLException e){
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }
    
}
