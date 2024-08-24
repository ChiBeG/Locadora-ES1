package domain.veiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Placa {
	public final String codigo;
	
	private Placa(String codigo) {
		super();
		this.codigo = codigo;
	}
	public static Placa create(String codigo) {
		return isValid(codigo) ? new Placa(codigo) : null;
	}
	
	public static boolean isValid(String codigo) {
		Pattern pattern = Pattern.compile("^[A-Za-z]{3}[0-9]{4}$");
		Matcher matcher = pattern.matcher(codigo);
		return matcher.find();
	}
}
