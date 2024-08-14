package domain;

import java.util.ArrayList;
import java.util.List;

public class VeiculoBuilder {
    private String codigoPlaca;
    private String modelo;
    private int anoFabricacao;
    private double diaria;
    private int quilometragem;

    public VeiculoBuilder(){}

    public VeiculoBuilder withPlaca(String codigoPlaca){
        this.codigoPlaca = codigoPlaca;
        return this;
    }
    public VeiculoBuilder withModelo(String modelo){
        this.modelo = modelo;
        return this;
    }
    public VeiculoBuilder withAnoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
        return this;
    }
    public VeiculoBuilder withDiaria (double diaria){
        this.diaria = diaria;
        return this;
    }
    public VeiculoBuilder withQuilometragem(int quilometragem){
        this.quilometragem = quilometragem;
        return this;
    }


    public Resultado<Veiculo> build(){
        List<Erro> erros = new ArrayList<>();

        var resultVeiculo = Veiculo.create(codigoPlaca, modelo, anoFabricacao, diaria, quilometragem);
        if (resultVeiculo.falha())
            erros.addAll(resultVeiculo.erros);


        return erros.isEmpty() ? Resultado.ok(resultVeiculo.valor) :
                                 Resultado.erro(erros);
    }

}