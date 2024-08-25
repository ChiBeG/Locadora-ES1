package ui.locacao;

import java.util.List;

import domain.Resultado;
import domain.locacao.Locacao;
import ui.Presenter;
import usecases.locacao.ListarLocacoesCtrl;

/**
 * Classe que controla a entrada de dados e dispara a funcionalidade de listagem de locações
 */
public class ListarLocacoesPrt implements Presenter {

    private ListarLocacoesView view;
    private ListarLocacoesCtrl controller;

    public ListarLocacoesPrt(ListarLocacoesView view, ListarLocacoesCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        // 1 - Solicita ao controller a lista de locações
        Resultado<List<Locacao>> resultado = controller.recuperarTodasLocacoes();

        // 2 - Verifica o status do processamento e exibe a lista ou mensagem de erro
        if (resultado.sucesso()) {
            view.mostrarLocacoes(resultado.valor);
        } else {
            view.mostrarErro();
        }
    }
}