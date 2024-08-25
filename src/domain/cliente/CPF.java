package domain.cliente;

/**
 * Value Object que trata o CPF
 */
public class CPF {
	
	public final String valor;

	/**
	 * Construtor privado obriga a criar o objeto com o método 'create'
	 * @param valor Número do CPF
	 */
	private CPF(String valor) {
		super();
		this.valor = valor;
	}
	
	/**
	 * Valida e cria o CPF
	 * @param numero Número do CPF
	 * @return CPF ou null, se número não é um CPF
	 */
	public static CPF create(String numero) {
		// Verificar se numero é um cpf válido
		// Se for retorna o objeto CPF
		// senão retorna null
		return ehCPFValido(numero) ? new CPF(numero) : null;
	}
	
	/**
	 * Verifica se um número é um CPF
	 * @param valor Número do CPF
	 * @return True, se for válido ou false, caso contrário
	 */
	private static boolean ehCPFValido(String valor) {
		if (valor.equals("00000000000") ||
		valor.equals("11111111111") ||
		valor.equals("22222222222") || valor.equals("33333333333") ||
		valor.equals("44444444444") || valor.equals("55555555555") ||
		valor.equals("66666666666") || valor.equals("77777777777") ||
		valor.equals("88888888888") || valor.equals("99999999999") ||
		(valor.length() != 11))
		return(false);

	char dig10, dig11;
	int sm, i, r, num, peso;

	// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	try {
	// Calculo do 1o. Digito Verificador
		sm = 0;
		peso = 10;
		for (i=0; i<9; i++) {
	// converte o i-esimo caractere do valor em um numero:
	// por exemplo, transforma o caractere "0" no inteiro 0
	// (48 eh a posicao de "0" na tabela ASCII)
		num = (int)(valor.charAt(i) - 48);
		sm = sm + (num * peso);
		peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11))
			dig10 = '0';
		else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

	// Calculo do 2o. Digito Verificador
		sm = 0;
		peso = 11;
		for(i=0; i<10; i++) {
		num = (int)(valor.charAt(i) - 48);
		sm = sm + (num * peso);
		peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11))
			 dig11 = '0';
		else dig11 = (char)(r + 48);

	// Verifica se os digitos calculados conferem com os digitos informados.
		if ((dig10 == valor.charAt(9)) && (dig11 == valor.charAt(10)))
			 return(true);
		else return(false);
			} catch (Exception erro) {
			return(false);
		}

	}

}