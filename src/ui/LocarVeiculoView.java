package ui;

import java.util.Scanner;
import domain.Erro;
import java.util.List;

/**
 * Classe que cuida da entrada e saída de dados via console para locação de veículos
 */
public class LocarVeiculoView {

    /**
     * Lê o CPF do cliente e a placa do veículo a serem usados na locação
     * @return Array de Strings contendo CPF e Placa
     */
    public String[] readData() {
        var input = new Scanner(System.in);
        String cpf, placa;

        System.out.println("\n--------------------");
        System.out.println("Locação de Veículo");
        System.out.println("--------------------");
        
        System.out.print("CPF do cliente: ");
        cpf = input.nextLine();
        
        System.out.print("Placa do veículo: ");
        placa = input.nextLine().toUpperCase();
        
        return new String[] { cpf, placa };
    }
    
    /**
     * Imprime as mensagens de erro de acordo com o código
     * @param erros Lista de códigos de erro
     */
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
    
    /**
     * Imprime mensagem de sucesso
     */
    public void setSucesso() {
        System.out.println("\nLocação realizada com sucesso!");
    }
}
