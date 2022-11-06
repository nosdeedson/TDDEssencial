package ejs.com.br.desconto;

public class CalcularDescontoPrimeiraFaixa extends CalcularFaixaDesconto {
	
	public CalcularDescontoPrimeiraFaixa(CalcularFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if( valorTotal > 300 && valorTotal <= 800) {
			return valorTotal * 0.04;
		}
		return -1;
	}

}
