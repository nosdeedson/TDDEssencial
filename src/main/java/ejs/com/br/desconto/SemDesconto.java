package ejs.com.br.desconto;

public class SemDesconto extends CalcularFaixaDesconto {

	public SemDesconto(CalcularFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}
