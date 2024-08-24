package ui.cliente;

import java.util.List;
import domain.Erro;
import ui.Presenter;
import usecases.cliente.ExclusaoClienteCtrl;

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
            cpf = Long.parseLong(view.readCPF());
            
            erros = controller.excluirClientePorCPF(cpf);
            
            if (erros != null) {
                view.setErros(erros);
            } else {
                view.setSucesso();
            }
        } while (erros != null);
    }
}
