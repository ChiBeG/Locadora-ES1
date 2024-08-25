package domain.locacao;

// import java.lang.classfile.instruction.LocalVariable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.Erro;
import domain.Persistent;
import domain.Resultado;
import domain.cliente.Cliente;
import domain.veiculo.Veiculo;

public class Locacao extends Persistent{
    
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime data;

    private Locacao(Veiculo veiculo, Cliente cliente, LocalDateTime data){
        super();
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public LocalDateTime getData() {
        return data;
    }

    public static Resultado<Locacao> create(Cliente cliente, Veiculo veiculo, LocalDateTime data){
        List<Erro> erros = new ArrayList<>();

        if (data == null)
            erros.add(Erro.DATA_INVALIDA);

        return erros.isEmpty() ?
                Resultado.ok(new Locacao(veiculo, cliente, data)) :
                Resultado.erro(erros);

    }

}
