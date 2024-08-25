package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import domain.dao.LocacaoDTO;

public class LocacaoMapper {

    public LocacaoDTO map(ResultSet rs) throws SQLException{
        
        var df = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        
        return new LocacaoDTO(rs.getString("id"),
                               rs.getString("idCliente"), 
                              rs.getString("idVeiculo"),
                              LocalDateTime.from(df.parse(rs.getString("data"))));
    }
    
}
