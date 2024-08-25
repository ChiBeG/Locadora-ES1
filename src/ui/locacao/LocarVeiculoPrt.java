package ui.locacao;

import java.util.List;
import domain.Erro;
import ui.Presenter;
import usecases.locacao.LocacaoRequest;
import usecases.locacao.LocarVeiculoCtrl;


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
        
        String placa, cpf;
        
        List<Erro> erros;
        do {
            var data = view.readData();
            try {
                cpf = data.cpf();
            } catch (Exception e) {
                cpf = null;
            }
            
            try{
                placa = data.placa().toUpperCase();
            }catch(Exception e){
                placa = null;
            }
            
            erros = controller.locarVeiculo(new LocacaoRequest(cpf, placa));
            
            if (erros != null) {
                view.setErros(erros);
            } else {
                view.setSucesso();
            }
        } while (erros != null);
    }
}
