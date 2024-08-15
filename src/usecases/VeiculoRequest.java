package usecases;

public record VeiculoRequest(String codigoPlaca, 
                            String modelo, 
                            int anoFabricacao, 
                            double diaria,
                            int quilometragem) {
    
}
