package domain.locacao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.Repository;
import domain.dao.ILocacaoDAO;
import domain.dao.LocacaoDTO;
import domain.cliente.ClienteRepository;
import domain.veiculo.VeiculoRepository;

/**
 * Classe que representa um repositório de locações.
 * A partir dessa classe, as locações são armazenadas ou recuperadas do BD.
 */
public class LocacaoRepository implements Repository {
    
    private final ILocacaoDAO dao;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    public LocacaoRepository(ILocacaoDAO dao, ClienteRepository clienteRepository, VeiculoRepository veiculoRepository) {
        this.dao = dao;
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
    }

    /**
     * Retorna todas as locações
     * 
     * @return Lista de locações
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public List<Locacao> findAll() throws SQLException {
        // Busca todas as locações do repositório
        var dtos = dao.findAll();
        
        // Converte os DTOs vindos do repositório em locações
        var locacoes = new ArrayList<Locacao>();
        
        for (var dto : dtos)
            locacoes.add(create(dto));
        
        return locacoes;
    }

    /**
     * Adiciona/atualiza uma locação no repositório
     * 
     * @param locacao Locação a ser inserida/atualizada
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public void add(Locacao locacao) throws SQLException {
        // Se a locação NÃO tem ID, então NÃO veio do BD
        if (locacao.getId() == null) {
            // Cria um ID artificial baseado no UUID        
            locacao.setId(UUID.randomUUID().toString());
            
            // Insere a locação no BD
            dao.insert(locacao);
        } else {
            // Locação já existe: atualiza no BD
            dao.update(locacao);
        }
    }

    /**
     * Remove uma locação do repositório
     * 
     * @param locacao Locação a ser removida
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    public void remove(Locacao locacao) throws SQLException {
        // Se a locação TEM ID, então deleta do BD
        if (locacao.getId() != null) {
            dao.delete(locacao);
            
            // Seta o ID do objeto para nulo, porque ele não está mais no BD
            locacao.setId(null);
        }
    }

    /**
     * Cria uma locação a partir do LocacaoDTO
     * 
     * @param dto Dados da locação vindos do BD
     * @return Locação
     * @throws SQLException Exceção em caso de problemas no acesso ao BD
     */
    private Locacao create(LocacaoDTO dto) throws SQLException {
        // Recupera o cliente e o veículo associados à locação
        var cliente = clienteRepository.findById(dto.idCliente()); 
        var veiculo = veiculoRepository.findById(dto.idVeiculo());

        if (cliente == null || veiculo == null) {
            throw new SQLException("Cliente ou Veículo não encontrado.");
        }

        // Usa o builder para construir a locação com os dados vindos do BD
        var resultado = new LocacaoBuilder()
                .withCliente(cliente)
                .withVeiculo(veiculo)
                .withData(dto.data())
                .build();

        // Assume que a criação foi bem-sucedida, 
        // pois os dados do BD devem estar consistentes
        var locacao = resultado.valor;

        // Seta o ID do objeto, pois ele veio do BD
        locacao.setId(dto.id());

        return locacao;
    }
}
