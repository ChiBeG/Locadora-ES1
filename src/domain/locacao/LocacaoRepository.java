package domain.locacao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.Repository;
import domain.dao.IClienteDAO;
import domain.dao.ILocacaoDAO;
import domain.dao.IVeiculoDAO;

public class LocacaoRepository implements Repository{
    
    private final ILocacaoDAO dao;


    public LocacaoRepository(ILocacaoDAO locacaoDAO, IVeiculoDAO veiculoDAO, IClienteDAO clienteDAO){
        this.dao = locacaoDAO;
    }

    // public List<Locacao> findAll() throws SQLException{

    //     var dtos = dao.findAll();

    //     var locacoes = new ArrayList<Locacao>();
    //     for (var dto : dtos)
    //         locacoes.add(create(dto));
    //     return locacoes;
    // }

    public void add (Locacao locacao) throws SQLException{
        locacao.setId(UUID.randomUUID().toString());
        dao.insert(locacao);
    }

    // private Locacao create(Locacao dto){
    //     var resultado = new LocacaoBuilder();
    // }
}
