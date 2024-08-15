package ui;

import java.util.List;
import java.util.Scanner;

import domain.Erro;

public class CadastroVeiculoView {
    

    public VeiculoData readData(){
        var input = new Scanner(System.in);
        String codigoPlaca, modelo, anoFabricacao, quilometragem, diaria;

        System.out.println("\n--------------------");
		System.out.println("Cadastro de Veículos");
		System.out.println("--------------------");

        System.out.println("Placa: ");
        codigoPlaca = input.nextLine();

        System.out.println("Modelo: ");
        modelo = input.nextLine();

        System.out.println("Ano de fabricação ");
        anoFabricacao = input.nextLine();

        System.out.println("Valor da diária (R$): ");
        diaria = input.nextLine();

        System.out.println("Quilometragem: ");
        quilometragem = input.nextLine();

        return new VeiculoData(codigoPlaca, modelo, anoFabricacao, diaria, quilometragem);
        
    }

    public void setErros(List<Erro> erros){
        
        for(var erro : erros){
            switch (erro) {
                case PLACA_INVALIDA             -> System.out.println("- Placa inválida!");
                case MODELO_INVALIDO            -> System.out.println("- Modelo inválido! Deve ter entre 3 e 30 caracteres.");
                case ANO_FABRICACAO_INVALIDO    -> System.out.println("- Ano de fabricação inválido! Deve estar entre 2000 e o ano atual.");
                case DIARIA_INVALIDA            -> System.out.println("- Diária inválida! Deve ser maior que zero.");
                case QUILOMETRAGEM_INVALIDA     -> System.out.println("- Quilometragem inválida! Deve ser maior que zero.");
                case PLACA_JA_EXISTENTE         -> System.out.println("- Já existe um veículo com essa placa!");
                case ERRO_BD				    -> System.out.println("- Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
            }
        }
        System.out.println();
    }
    public void setSucesso() {
		System.out.println("\nCadastramento realizado com sucesso!");
	}
}
