package application;

import domain.cliente.ClienteRepository;
import domain.locacao.LocacaoRepository;
import domain.veiculo.VeiculoRepository;
import persistence.ClienteDAO;
import persistence.LocacaoDAO;
import persistence.VeiculoDAO;
import ui.MenuPresenter;
import ui.MenuView;
import ui.Presenter;
import ui.cliente.CadastroClientePrt;
import ui.cliente.CadastroClienteView;
import ui.cliente.ExclusaoClientePrt;
import ui.cliente.ExclusaoClienteView;
import ui.cliente.ListarClientesPrt;
import ui.cliente.ListarClientesView;
import ui.locacao.ListarLocacoesPrt;
import ui.locacao.ListarLocacoesView;
import ui.locacao.LocarVeiculoPrt;
import ui.locacao.LocarVeiculoView;
import ui.veiculo.CadastroVeiculoPrt;
import ui.veiculo.CadastroVeiculoView;
import ui.veiculo.ExclusaoVeiculoPrt;
import ui.veiculo.ExclusaoVeiculoView;
import ui.veiculo.ListarVeiculosPrt;
import ui.veiculo.ListarVeiculosView;
import usecases.cliente.CadastroClienteCtrl;
import usecases.cliente.ExclusaoClienteCtrl;
import usecases.cliente.ListarClientesCtrl;
import usecases.locacao.ListarLocacoesCtrl;
import usecases.locacao.LocarVeiculoCtrl;
import usecases.veiculo.CadastroVeiculoCtrl;
import usecases.veiculo.ExclusaoVeiculoCtrl;
import usecases.veiculo.ListarVeiculosCtrl;

/**
 * Classe responsável por criar os presenters e sua estrutura
 */
public class PresenterFactory {

	/**
	 * Tipo do presenter
	 */
	public enum Type { MENU, 
		               CADASTRAR_CLIENTE, 
		               EXCLUIR_CLIENTE, 
		               LISTAR_CLIENTE,
					   CADASTRAR_VEICULO,
					   LISTAR_VEICULO,
					   EXCLUIR_VEICULO,
					   LOCAR_VEICULO,
					   LISTAR_LOCACAO };
	
    /**
     * Cria um presenter de acordo com o tipo solicitado
     * 
     * @param type Tipo do presenter
     * @return Presenter
     */
	public static Presenter get(Type type) {
		switch(type) {
			case MENU -> {
				var view = new MenuView(); 
				
				return new MenuPresenter(view);
			}
		
			case CADASTRAR_CLIENTE -> {
				var repository = new ClienteRepository(new ClienteDAO());
				var view = new CadastroClienteView();
				var controller = new CadastroClienteCtrl(repository);

				return new CadastroClientePrt(view, controller);

			}
		
			case EXCLUIR_CLIENTE -> {
				var repository = new ClienteRepository(new ClienteDAO());
				var view = new ExclusaoClienteView();
				var controller = new ExclusaoClienteCtrl(repository);

				return new ExclusaoClientePrt(view, controller);
			}
		
			case LISTAR_CLIENTE -> {
				var repository = new ClienteRepository(new ClienteDAO());
				var view = new ListarClientesView();
				var controller = new ListarClientesCtrl(repository);

				return new ListarClientesPrt(view, controller);
			}

			case CADASTRAR_VEICULO -> {
				var repository = new VeiculoRepository(new VeiculoDAO());
				var view = new CadastroVeiculoView();
				var controller = new CadastroVeiculoCtrl(repository);

				return new CadastroVeiculoPrt(view, controller);
			}

			case LISTAR_VEICULO -> {
				var repository = new VeiculoRepository(new VeiculoDAO());
				var view = new ListarVeiculosView();
				var controller = new ListarVeiculosCtrl(repository);

				return new ListarVeiculosPrt(view, controller);
			}

			case EXCLUIR_VEICULO -> {
				var repository = new VeiculoRepository(new VeiculoDAO());
				var view = new ExclusaoVeiculoView();
				var controller = new ExclusaoVeiculoCtrl(repository);

				return new ExclusaoVeiculoPrt(view, controller);
			}

			case LOCAR_VEICULO -> {
				var clienteRepository = new ClienteRepository(new ClienteDAO());
				var veiculoRepository = new VeiculoRepository(new VeiculoDAO());
				var locacaoRepository = new LocacaoRepository(new LocacaoDAO(), clienteRepository, veiculoRepository);
				var view = new LocarVeiculoView();
				var controller = new LocarVeiculoCtrl(clienteRepository, veiculoRepository, locacaoRepository);

				return new LocarVeiculoPrt(view, controller);
			}

			case LISTAR_LOCACAO -> {
				var clienteRepository = new ClienteRepository(new ClienteDAO());
				var veiculoRepository = new VeiculoRepository(new VeiculoDAO());
				var locacaoRepository = new LocacaoRepository(new LocacaoDAO(), clienteRepository, veiculoRepository);
				var view = new ListarLocacoesView();
				var controller = new ListarLocacoesCtrl(locacaoRepository);

				return new ListarLocacoesPrt(view, controller);
			}
		};
		return null;
	}
}
