package usecases.cliente;

import java.sql.SQLException;
import java.util.List;

import domain.Erro;
import domain.cliente.Cliente;
import domain.cliente.ClienteRepository;


public class ExclusaoClienteCtrl {

    private final ClienteRepository repo;

    public ExclusaoClienteCtrl(ClienteRepository repo) {
        super();
        this.repo = repo;
    }

    
    public List<Erro> excluirClientePorCPF(Long cpf) {
        try {
            
            Cliente cliente = repo.findByCPF(cpf);
            
            
            if (cliente == null) {
                return List.of(Erro.CLIENTE_NAO_ENCONTRADO);
            }
            
         
            repo.remove(cliente);
            
           
            return null;
        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }
}