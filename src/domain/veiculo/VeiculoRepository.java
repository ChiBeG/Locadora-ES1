package domain.veiculo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.Repository;
import domain.dao.IVeiculoDAO;
import domain.dao.VeiculoDTO;

public class VeiculoRepository implements Repository{
    private final IVeiculoDAO dao;

    public VeiculoRepository(IVeiculoDAO dao){
        this.dao = dao;
    }



    public List<Veiculo> findAll(String ordenacao) throws SQLException{
        
        var dtos = dao.findAll(ordenacao);

        var veiculos = new ArrayList<Veiculo>();
        for (var dto : dtos)
            veiculos.add(create(dto));
        return veiculos;
    }

    public Veiculo findByPlaca(String codigoPlaca) throws SQLException{

        var dto = dao.findByPlaca(codigoPlaca);

        if (dto != null)
            return create(dto);

        return null;
    }

        public Veiculo findById(String id) throws SQLException{

        var dto = dao.findById(id);

        if (dto != null)
            return create(dto);

        return null;
    }

    public void add (Veiculo veiculo) throws SQLException{
        if (veiculo.getId() == null){
            veiculo.setId(UUID.randomUUID().toString());
            dao.insert(veiculo);
        }
        else
            dao.update(veiculo);
    }


    public void remove (Veiculo veiculo) throws SQLException{
        if(veiculo.getId() != null){
            dao.delete(veiculo);
            veiculo.setId(null);
        }
    }


    private Veiculo create(VeiculoDTO dto){
        var resultado = new VeiculoBuilder()
                                .withPlaca(dto.codigoPlaca())
                                .withModelo(dto.modelo())
                                .withAnoFabricacao(dto.anoFabricacao())
                                .withDiaria(dto.diaria())
                                .withQuilometragem(dto.quilometragem()).build();

        var veiculo = resultado.valor;

        veiculo.setId(dto.id());
        return veiculo;
    }
}
