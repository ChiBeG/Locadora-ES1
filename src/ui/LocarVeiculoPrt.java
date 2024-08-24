package ui;

import java.util.List;
import domain.Erro;
import usecases.LocarVeiculoCtrl;

/**
 * Classe que controla a entrada de dados e dispara a funcionalidade de locação de veículos
 */
public class LocarVeiculoPrt implements Presenter {

    private LocarVeiculoView view;
    private LocarVeiculoCtrl controller;
    
    public LocarVeiculoPrt(LocarVeiculoView view, LocarVeiculoCtrl controller) {
        super();
        this.view = view;
        this.controller = controller;
    }
    
    @Override
    public void run() {
        List<Erro> erros;
        do {
            // 1 - Lê os dados da view
            var data = view.readData();
            Long cpf;
            String placa;
            
            try {
                cpf = Long.parseLong(data[0]);
            } catch (NumberFormatException e) {
                cpf = null;
            }
            
            placa = data[1];
            
            // 2 - Entrega os dados para o controller processar a locação
            erros = controller.locarVeiculo(cpf, placa);
            
            // 3 - Verificar o status do processamento
            if (erros != null) {
                view.setErros(erros);
            } else {
                view.setSucesso();
            }
        } while (erros != null);
    }
}
