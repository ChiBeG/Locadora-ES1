package usecases.locacao;

import java.sql.SQLException;
import java.util.List;
import domain.locacao.Locacao;
import domain.locacao.LocacaoRepository;
import domain.Erro;
import domain.Resultado;

/**
 * Classe que implementa a funcionalidade de consulta de locações
 */
public class ListarLocacoesCtrl {

    private final LocacaoRepository repo;

    public ListarLocacoesCtrl(LocacaoRepository repo) {
        super();
        this.repo = repo;
    }

    /**
     * Recupera todas as locações do cadastro
     * 
     * @return Resultado com a lista de locações ou erro de acesso ao BD
     */
    public Resultado<List<Locacao>> recuperarTodasLocacoes() {
        try {
            var locacoes = repo.findAll();
            return Resultado.ok(locacoes);
        } catch (SQLException e) {
            // Se ocorrer alguma exceção no BD, avisa
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }
}
