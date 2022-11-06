package ejs.com.br.desconto;

public class CalcularDescontoTerceiraFaixa extends CalcularFaixaDesconto {

	public CalcularDescontoTerceiraFaixa(CalcularFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 1000) {
			return valorTotal * 0.08;
		}
		return -1;
	}

}
