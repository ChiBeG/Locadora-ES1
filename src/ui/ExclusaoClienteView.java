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
    public Long readCPF() {
        var input = new Scanner(System.in);

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Cliente");
        System.out.println("--------------------");
        
        System.out.print("CPF: ");
        Long cpf = input.nextLong();
        
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
                case CPF_INVALIDO -> System.out.println("- CPF inválido!");
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

    /**
     * Imprime mensagem de cliente não encontrado
     */
    public void setClienteNaoEncontrado() {
        System.out.println("\nCliente não encontrado!");
    }
}
