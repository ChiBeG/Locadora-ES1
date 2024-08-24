package application;

import domain.ClienteRepository;
import domain.VeiculoRepository;
import persistence.ClienteDAO;
import persistence.VeiculoDAO;
import ui.CadastroClientePrt;
import ui.CadastroClienteView;
import ui.CadastroVeiculoPrt;
import ui.CadastroVeiculoView;
import ui.ExclusaoClientePrt;
import ui.ExclusaoClienteView;
import ui.ExclusaoVeiculoView;
import ui.ExclusaoVeiculoPrt;
import ui.ListarClientesPrt;
import ui.ListarClientesView;
import ui.ListarVeiculosPrt;
import ui.ListarVeiculosView;
import ui.LocarVeiculoPrt;
import ui.LocarVeiculoView;
import ui.MenuPresenter;
import ui.MenuView;
import ui.Presenter;
import usecases.CadastroClienteCtrl;
import usecases.CadastroVeiculoCtrl;
import usecases.ListarClientesCtrl;
import usecases.ListarVeiculosCtrl;
import usecases.ExclusaoClienteCtrl;
import usecases.ExclusaoVeiculoCtrl;
import usecases.LocarVeiculoCtrl;
import usecases.ListarLocacoesCtrl;

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
					   LISTAR_LOCACACOES };
	
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
				var view = new LocarVeiculoView();
				var controller = new LocarVeiculoCtrl(clienteRepository, veiculoRepository);

				return new LocarVeiculoPrt(view, controller);
			}

			// case LISTAR_LOCACACOES -> {
			// 	var repository = new LocacaoRepository(new LocacaoDAO());
			// 	var view = new ListarLocacoesView();
			// 	var controller = new ListarLocacoesCtrl(repository);

			// 	return new ListarLocacoesPrt(view, controller);
			// }
		};
		return null;
	}
}
