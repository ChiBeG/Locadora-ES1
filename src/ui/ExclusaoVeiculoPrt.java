package ui;

import java.util.List;
import domain.Erro;
import usecases.ExclusaoVeiculoCtrl;

/**
 * Classe que controla a entrada de dados e dispara a funcionalidade de exclusão de veículos
 */
public class ExclusaoVeiculoPrt implements Presenter {

    private ExclusaoVeiculoView view;
    private ExclusaoVeiculoCtrl controller;
    
    public ExclusaoVeiculoPrt(ExclusaoVeiculoView view, ExclusaoVeiculoCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }
    
    @Override
    public void run() {
        String placa;
        List<Erro> erros;
        
        do {
            // 1 - Lê a placa da view
            placa = view.readPlaca().toUpperCase();
            
            // 2 - Entrega a placa para o controller processar a exclusão
            erros = controller.excluirVeiculoPorPlaca(placa);
            
            // 3 - Verificar o status do processamento
            if (erros != null) {
                view.setErros(erros);
            } else {
                view.setSucesso();
            }
        } while (erros != null);
    }
}
