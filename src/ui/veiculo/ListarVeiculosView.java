package ui.veiculo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Scanner;

import domain.veiculo.Veiculo;

public class ListarVeiculosView {
    
    public String readOrdenacao(){
		var input = new Scanner(System.in);
		String ordenacao;
		boolean loop;
		do{
			System.out.println("\n--------------------");
			System.out.println("Listagem de Veículos");
			System.out.println("--------------------");

			System.out.println("Insira a ordenação desejada (P-Placa ou M-Modelo): ");
			ordenacao = input.nextLine().trim().toUpperCase();
			
			loop = (!ordenacao.equals("P") && !ordenacao.equals("M"));
			if (loop)
				System.out.println("Ordenação inválida!");
		}while(loop);
		
		return ordenacao;
	}
    
    
    
    public void mostrarVeiculos(List<Veiculo> veiculos){
        
        if (veiculos.isEmpty())
            System.out.println("\nNão há veículos cadastrados");
        else{
            System.out.println("\n------------------------------------------------------------------");
            System.out.println("Placa	 Modelo                  	Ano      Diária         Km");
         //                     AAA-9999 xxxxxxxx_30_caracteres_xxxxxxx 9999 9999,99 999999
            System.out.println("------------------------------------------------------------------");


            for (var v : veiculos){
                System.out.printf("%s %-30s %4d %10s %10d\n",
                                    formataPlaca(v.getPlaca().codigo),
                                    v.getModelo(),
                                    v.getAnoFabricacao(),
                                    formataDiaria(v.getDiaria()),
                                    v.getQuilometragem());
            }
            System.out.println("------------------------------------------------------------------");
        }
    }

	public void mostrarErro() {
		System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
	}

    private String formataPlaca(String codigoPlaca){
        return codigoPlaca.replaceAll("([A-Za-z]{3})([0-9]{4})", "$1-$2");
    }
    private String formataDiaria(double diaria){
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

        // Formatar o valor
        return decimalFormat.format(diaria);
    }
}
