package persistence;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import domain.dao.ILocacaoDAO;
import domain.dao.LocacaoDTO;
import domain.locacao.Locacao;

public class LocacaoDAO implements ILocacaoDAO{

    @Override
    public void delete(Locacao locacao) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public List<LocacaoDTO> findAll() throws SQLException {

        try(var conn = DBConnection.get();
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery("select * from locacoes")){
                var mapper = new LocacaoMapper();
                var locacoes = new ArrayList<LocacaoDTO>();

                while (rs.next())
                    locacoes.add(mapper.map(rs));
                
                return locacoes;
            }
    }

    @Override
    public void insert(Locacao locacao) throws SQLException {
        
        try(var conn = DBConnection.get();
            var stmt = conn.prepareStatement("insert into locacoes values (?, ?, ?, ?)")){

                var df = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
                
                stmt.setString(1, locacao.getId());
                stmt.setString(2, locacao.getCliente().getId());
                stmt.setString(3, locacao.getVeiculo().getId());
                stmt.setString(4, df.format(locacao.getData()));

                stmt.execute();
            }
        
    }

    @Override
    public void update(Locacao locacao) throws SQLException {
        // TODO Auto-generated method stub
        
    }
    
}
