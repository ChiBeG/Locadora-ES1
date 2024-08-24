package ui;

import java.util.List;
import java.util.Scanner;

import domain.Erro;

/**
 * Classe que cuida da entrada e saída de dados via console para exclusão de clientes
 */
public class ExclusaoClienteView {

    /**
     * Lê o CPF do cliente a ser excluído
     * @return CPF do cliente
     */
    public String readCPF() {
        var input = new Scanner(System.in);

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Cliente");
        System.out.println("--------------------");
        
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        
        return cpf;
    }
    
    /**
     * Imprime as mensagens de erro de acordo com o código
     * @param erros Lista de códigos de erro
     */
    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na exclusão:");
        for (var erro : erros) {
            switch (erro) {
                case CLIENTE_NAO_ENCONTRADO -> System.out.println("- Cliente não encontrado!");
                case ERRO_BD      -> System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
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
}
