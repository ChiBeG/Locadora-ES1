package ui;

import usecases.ListarVeiculosCtrl;

public class ListarVeiculosPrt implements Presenter{
    private ListarVeiculosView view;
    private ListarVeiculosCtrl controller;

    public ListarVeiculosPrt(ListarVeiculosView view, ListarVeiculosCtrl controller){
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run(){
        
        var ordenacao = view.readOrdenacao();

        switch (ordenacao) {
			case "P" -> ordenacao = "placa";
			case "M" -> ordenacao = "modelo";
		}

        var resultado = controller.recuperarTodosVeiculos(ordenacao);

        if(resultado.sucesso())
            view.mostrarVeiculos(resultado.valor);
        else
            view.mostrarErro();
    }
}
