package ui.cliente;

import java.util.List;
import java.util.Scanner;

import domain.Erro;


public class ExclusaoClienteView {


    public String readCPF() {
        var input = new Scanner(System.in);

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Cliente");
        System.out.println("--------------------");
        
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        
        return cpf;
    }
    

    public void setErros(List<Erro> erros) {
        System.out.println("\nErro na exclusão:");
        for (var erro : erros) {
            switch (erro) {
                case CLIENTE_NAO_ENCONTRADO -> System.out.println("- Cliente não encontrado!");
                case ERRO_BD      -> System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
            }
        }
        System.out.println();
    }
    

    public void setSucesso() {
        System.out.println("\nExclusão realizada com sucesso!");
    }
}
