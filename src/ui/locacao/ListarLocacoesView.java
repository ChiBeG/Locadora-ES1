package ui.locacao;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

import domain.locacao.Locacao;

public class ListarLocacoesView {

    /**
     * Exibe a lista de locações formatada conforme o padrão definido
     * 
     * @param locacoes Lista de locações a ser exibida
     */
    public void mostrarLocacoes(List<Locacao> locacoes) {
        if (locacoes.isEmpty()) {
            System.out.println("\nNão há locações registradas.");
        } else {
            System.out.println("\n------------------------------------------------------------------------------------------------------");
            System.out.println("CPF            Nome                           Placa    Modelo                          Data/hora");
            //                 999.999.999-99 xx_30_caracteres_xx AAA-9999 xx_30_caracteres_xx 99/99/9999 99:99
            System.out.println("------------------------------------------------------------------------------------------------------");

            for (var locacao : locacoes) {
                var cliente = locacao.getCliente();
                var veiculo = locacao.getVeiculo();
                var dataHora = locacao.getData();

                System.out.printf("%14s %-30s %-8s %-30s %s\n",
                        formataCPF(cliente.getCpf().valor),
                        cortaTexto(cliente.getNome(), 30),
                        formataPlaca(veiculo.getPlaca().codigo),
                        cortaTexto(veiculo.getModelo(), 30),
                        formataDataHora(dataHora)
                );
            }

            System.out.println("------------------------------------------------------------------------------------------------------");
        }
    }

    /**
     * Exibe uma mensagem de erro em caso de falha ao acessar os dados
     */
    public void mostrarErro() {
        System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
    }

    private String formataCPF(String cpf) {
        return Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})").matcher(cpf).replaceAll("$1.$2.$3-$4");
    }

    private String formataDataHora(java.time.LocalDateTime dataHora) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }

    private String formataPlaca(String codigoPlaca){
        return codigoPlaca.replaceAll("([A-Za-z]{3})([0-9]{4})", "$1-$2");
    }

    private String cortaTexto(String texto, int tamanhoMaximo) {
        if (texto.length() > tamanhoMaximo) {
            return texto.substring(0, tamanhoMaximo);
        } else {
            return String.format("%-" + tamanhoMaximo + "s", texto);
        }
    }
}