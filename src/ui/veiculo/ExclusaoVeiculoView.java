package ui.veiculo;

import java.util.List;
import java.util.Scanner;
import domain.Erro;


public class ExclusaoVeiculoView {

 
    public String readPlaca() {
        var input = new Scanner(System.in);

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Veículo");
        System.out.println("--------------------");
        
        System.out.print("Placa: ");
        return input.nextLine();
    }
    

    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na exclusão:");
        for (var erro : erros) {
            switch (erro) {
                case VEICULO_NAO_ENCONTRADO -> System.out.println("- Veículo não encontrado!");
                case ERRO_BD        -> System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
            }
        }
        System.out.println();
    }
    

    public void setSucesso() {
        System.out.println("\nExclusão realizada com sucesso!");
    }
}
