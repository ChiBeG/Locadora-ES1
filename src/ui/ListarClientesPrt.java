package ui;

import java.util.List;

import domain.Cliente;
import domain.Resultado;
import usecases.ListarClientesCtrl;

public class ListarClientesPrt implements Presenter {

	private ListarClientesView view;
	private ListarClientesCtrl controller;
	
	public ListarClientesPrt(ListarClientesView view, ListarClientesCtrl controller) {
		super();
		this.view = view;
		this.controller = controller;
	}

	@Override
	public void run() {
		
		var ordenacao = view.readOrdenacao();
		
		switch (ordenacao) {
			case "C" -> ordenacao = "cpf";
			case "N" -> ordenacao = "nome";
		}

		var resultado = controller.recuperarTodosClientes(ordenacao);
		
		if (resultado.sucesso())
			view.mostrarClientes(resultado.valor);
		else
			view.mostrarErro();
	
	}
}





