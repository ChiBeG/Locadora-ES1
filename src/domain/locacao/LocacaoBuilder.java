package domain.locacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.Erro;
import domain.Resultado;
import domain.cliente.Cliente;
import domain.veiculo.Veiculo;

public class LocacaoBuilder {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDateTime data;

    public LocacaoBuilder(){}

    public LocacaoBuilder withCliente(Cliente cliente){
        this.cliente = cliente;
        return this;
    }

    public LocacaoBuilder withVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
        return this;
    }

    public LocacaoBuilder withData(LocalDateTime data){
        this.data = data;
        return this;
    }

    public Resultado<Locacao> build(){
        List<Erro> erros = new ArrayList<>();

        var resultLocacao = Locacao.create(cliente, veiculo, data);
        if (resultLocacao.falha())
            erros.addAll(resultLocacao.erros);

            return erros.isEmpty() ? Resultado.ok(resultLocacao.valor) :
            Resultado.erro(erros);

        
    }
}
