package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Veiculo;
import domain.dao.IVeiculoDAO;
import domain.dao.VeiculoDTO;

public class VeiculoDAO implements IVeiculoDAO{
    
    @Override
    public void insert(Veiculo veiculo) throws SQLException{

        try (var conn = DBConnection.get(); 
             var stmt = conn.prepareStatement("insert into veiculos values (?,?,?,?,?,?)")){

            stmt.setString(1, veiculo.getId());
            stmt.setString(2, veiculo.getPlaca().codigo);
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getAnoFabricacao());
            stmt.setDouble(5, veiculo.getDiaria());
            stmt.setInt(6, veiculo.getQuilometragem());

            stmt.execute();    
        }
    }


    @Override
    public void update(Veiculo veiculo) throws SQLException{

        try (var conn = DBConnection.get(); 
             var stmt = conn.prepareStatement("update veiculos set placa = ?, modelo = ?, anoFabricacao = ?, diaria = ?, quilometragem = ? where id = ?")){

            
            stmt.setString(1, veiculo.getPlaca().codigo);
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAnoFabricacao());
            stmt.setDouble(4, veiculo.getDiaria());
            stmt.setInt(5, veiculo.getQuilometragem());
            stmt.setString(6, veiculo.getId());

            stmt.execute();    
        }
        
    }

    @Override
    public void delete (Veiculo veiculo) throws SQLException{
        try (var conn = DBConnection.get(); 
             var stmt = conn.prepareStatement("delete from veiculos where id=?")){

            stmt.setString(1, veiculo.getId());

            stmt.execute();    
        }
    }
    @Override
    public List<VeiculoDTO> findAll(String ordenacao) throws SQLException{
        
        String querry = "select * from veiculos order by " + ordenacao;
        try(var conn = DBConnection.get();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(querry)){
            
            var mapper = new VeiculoMapper();
            var veiculos = new ArrayList<VeiculoDTO>();
            
            while(rs.next())
                veiculos.add(mapper.map(rs));
            return veiculos;

        }
    }
    @Override
    public VeiculoDTO findByPlaca(String codigoPlaca) throws SQLException{
        try (var conn = DBConnection.get(); 
        var stmt = conn.prepareStatement("select * from veiculos where placa = ?")){

            stmt.setString(1, codigoPlaca);

            try(var rs = stmt.executeQuery()){

                var mapper = new VeiculoMapper();

                if (rs.next())
                    return mapper.map(rs);

                return null;
            }

        
        }
    }
}
