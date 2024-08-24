package ui.locacao;

import java.util.Scanner;
import domain.Erro;
import java.util.List;


public class LocarVeiculoView {


    public LocacaoData readData() {
        var input = new Scanner(System.in);
        String cpf, placa;

        System.out.println("\n--------------------");
        System.out.println("Locação de Veículo");
        System.out.println("--------------------");
        
        System.out.print("CPF do cliente: ");
        cpf = input.nextLine();
        
        System.out.print("Placa do veículo: ");
        placa = input.nextLine().toUpperCase();
        
        return new LocacaoData(cpf, placa);
    }
    

    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na locação:");
        for (var erro : erros) {
            switch (erro) {
                case CLIENTE_NAO_ENCONTRADO    -> System.out.println("- Cliente não encontrado!");
                case VEICULO_NAO_ENCONTRADO  -> System.out.println("- Veículo não encontrado!");
                case ERRO_BD         -> System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
            }
        }
        System.out.println();
    }
    

    public void setSucesso() {
        System.out.println("\nLocação realizada com sucesso!");
    }
}
