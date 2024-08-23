package ui;

import java.util.List;
import java.util.Scanner;
import domain.Erro;

/**
 * Classe que cuida da entrada e saída de dados via console para exclusão de veículos
 */
public class ExclusaoVeiculoView {

    /**
     * Lê a placa do veículo a ser excluído
     * @return Código da placa do veículo
     */
    public String readPlaca() {
        var input = new Scanner(System.in);

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Veículo");
        System.out.println("--------------------");
        
        System.out.print("Placa: ");
        return input.nextLine().toUpperCase();
    }
    
    /**
     * Imprime as mensagens de erro de acordo com o código
     * @param erros Lista de códigos de erro
     */
    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na exclusão:");
        for (var erro : erros) {
            switch (erro) {
                case PLACA_INVALIDA -> System.out.println("- Placa inválida!");
                case ERRO_BD        -> System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
                // Adicione outros erros que sejam relevantes para exclusão
            }
        }
        System.out.println();
    }
    
    /**
     * Imprime mensagem de sucesso
     */
    public void setSucesso() {
        System.out.println("\nExclusão realizada com sucesso!");
    }

    /**
     * Imprime mensagem de veículo não encontrado
     */
    public void setVeiculoNaoEncontrado() {
        System.out.println("\nVeículo não encontrado!");
    }
}
