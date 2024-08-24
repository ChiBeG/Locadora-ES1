package ui;

import java.util.List;
import domain.Erro;
import usecases.ExclusaoClienteCtrl;

/**
 * Classe que controla a entrada de dados e dispara a funcionalidade de exclusão dos clientes
 */
public class ExclusaoClientePrt implements Presenter {

    private ExclusaoClienteView view;
    private ExclusaoClienteCtrl controller;
    
    public ExclusaoClientePrt(ExclusaoClienteView view, ExclusaoClienteCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }
    
    @Override
    public void run() {
        Long cpf;
        List<Erro> erros;
        
        do {
            // 1 - Lê o CPF da view
            cpf = Long.parseLong(view.readCPF());
            
            // 2 - Entrega o CPF para o controller processar a exclusão
            erros = controller.excluirClientePorCPF(cpf);
            
            // 3 - Verificar o status do processamento
            if (erros != null) {
                view.setErros(erros);
            } else {
                view.setSucesso();
            }
        } while (erros != null);
    }
}
