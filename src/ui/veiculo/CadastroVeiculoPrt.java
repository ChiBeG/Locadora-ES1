package ui.veiculo;

import java.util.List;

import domain.Erro;
import ui.Presenter;
import usecases.veiculo.CadastroVeiculoCtrl;
import usecases.veiculo.VeiculoRequest;

public class CadastroVeiculoPrt implements Presenter {
    private CadastroVeiculoView view;
    private CadastroVeiculoCtrl controller;

    public CadastroVeiculoPrt(CadastroVeiculoView view, CadastroVeiculoCtrl controller){
        super();
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run(){
        String codigoPlaca, modelo;
        Integer anoFabricacao, quilometragem;
        Double diaria;

        List<Erro> erros;

        do{
            var data = view.readData();

            try{
                codigoPlaca = data.codigoPlaca();
                codigoPlaca = codigoPlaca.toUpperCase();
            }catch (Exception e){
                codigoPlaca = null;
            }

            try{
                modelo = data.modelo();
            }catch (Exception e){
                modelo = null;
            }
            try {
                anoFabricacao = Integer.parseInt(data.anoFabricacao());
            } catch (Exception e){
                anoFabricacao = null;
            }
            try{
                diaria = Double.parseDouble(data.diaria());
            }catch (Exception e){
                diaria = null;
            }
            try{
                quilometragem = Integer.parseInt(data.quilometragem());
            }catch (Exception e){
                quilometragem = null;
            }

            erros = controller.cadastrarVeiculo(new VeiculoRequest(codigoPlaca, modelo, anoFabricacao, diaria, quilometragem));

            if (erros != null)
                view.setErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
