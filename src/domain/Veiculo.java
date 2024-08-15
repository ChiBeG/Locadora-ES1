package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Veiculo extends Persistent{
	private Placa placa;
	private String modelo;
	private int anoFabricacao;
	private double diaria;
	private int quilometragem;
	
	private Veiculo(Placa placa, String modelo, int anoFabricacao, double diaria, int quilometragem) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.diaria = diaria;
		this.quilometragem = quilometragem;
	}
	
	public static Resultado<Veiculo> create(String codigoPlaca, String modelo, int anoFabricacao, double diaria, int quilometragem){
		
		List<Erro> erros = new ArrayList<>();
		Placa placa = null;

		if (codigoPlaca == null){
			erros.add(Erro.PLACA_INVALIDA);
		}
		else{
			placa = Placa.create(codigoPlaca);
			if (placa == null)
				erros.add(Erro.PLACA_INVALIDA);
		}

		if (modelo == null || !(modelo.length() >= 3 && modelo.length() <= 30))
			erros.add(Erro.MODELO_INVALIDO);

		int currentYear = LocalDate.now().getYear();
		if (!(anoFabricacao >= 2000 && anoFabricacao <= currentYear))
			erros.add(Erro.ANO_FABRICACAO_INVALIDO);

		if (diaria <= 0)
			erros.add(Erro.DIARIA_INVALIDA);
		
		if (quilometragem <= 0)
			erros.add(Erro.QUILOMETRAGEM_INVALIDA);

		return erros.isEmpty() ? Resultado.ok(new Veiculo(placa, modelo, anoFabricacao, diaria, quilometragem)) :
								 Resultado.erro(erros);
	}
	
	
	

	public Placa getPlaca() {
		return this.placa;
	}
	
	public String getModelo() {
		return this.modelo;
	}

	public int getAnoFabricacao() {
		return this.anoFabricacao;
	}

	public double getDiaria() {
		return this.diaria;
	}

	public int getQuilometragem() {
		return this.quilometragem;
	}
	
}
