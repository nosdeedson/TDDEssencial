package ejs.com.br.desconto;

public class CalcularDescontoSegundaFaixa extends CalcularFaixaDesconto {

	public CalcularDescontoSegundaFaixa(CalcularFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 800 && valorTotal <= 1000) {
			return valorTotal * 0.06;
		}
		return -1;
	}

}
