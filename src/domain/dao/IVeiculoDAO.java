package domain.dao;

import java.sql.SQLException;
import java.util.List;

import domain.Veiculo;

public interface IVeiculoDAO {
    
    void insert(Veiculo veiculo) throws SQLException;
    void update(Veiculo veiculo) throws SQLException;
    void delete(Veiculo veiculo) throws SQLException;

    List<VeiculoDTO> findAll() throws SQLException;

    VeiculoDTO findByPlaca(String codigoPlaca) throws SQLException;


}
