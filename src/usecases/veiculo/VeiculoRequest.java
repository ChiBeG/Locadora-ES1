package usecases.veiculo;

public record VeiculoRequest(String codigoPlaca, 
                            String modelo, 
                            Integer anoFabricacao, 
                            Double diaria,
                            Integer quilometragem) {
    
}
