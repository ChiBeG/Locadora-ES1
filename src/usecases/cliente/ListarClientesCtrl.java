package usecases.cliente;

import java.sql.SQLException;
import java.util.List;

import domain.Erro;
import domain.Resultado;
import domain.cliente.Cliente;
import domain.cliente.ClienteRepository;

/**
 * Classe que implementa a funcionalidade de consulta de clientes
 */
public class ListarClientesCtrl {

	private final ClienteRepository repo;
	
	public ListarClientesCtrl(ClienteRepository repo) {
		super();
		this.repo = repo;
	}

	/**
	 * Recupera todos os clientes do cadastro
	 * 
	 * @return Lista de clientes ou erro de acesso ao BD
	 */
	public Resultado<List<Cliente>> recuperarTodosClientes(String ordenacao) {
		
		try {
			var clientes = repo.findAll(ordenacao);
			
			return Resultado.ok(clientes);
		} catch (SQLException e) {
			// Se ocorrer alguma exceção no BD, avisa
			return Resultado.erro(List.of(Erro.ERRO_BD));
		}
	}
}
