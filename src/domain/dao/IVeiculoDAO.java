package domain.dao;

import java.sql.SQLException;
import java.util.List;

import domain.veiculo.Veiculo;

public interface IVeiculoDAO {
    
    void insert(Veiculo veiculo) throws SQLException;
    void update(Veiculo veiculo) throws SQLException;
    void delete(Veiculo veiculo) throws SQLException;

    List<VeiculoDTO> findAll(String ordenacao) throws SQLException;

    VeiculoDTO findByPlaca(String codigoPlaca) throws SQLException;
    VeiculoDTO findById(String id) throws SQLException;


}
