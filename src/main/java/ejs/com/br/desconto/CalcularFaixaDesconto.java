package ejs.com.br.desconto;

public abstract class CalcularFaixaDesconto {

	private CalcularFaixaDesconto proximo;
	
	public CalcularFaixaDesconto(CalcularFaixaDesconto proximo) {
		this.proximo = proximo;
	}
	
	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		
		if(desconto == -1 ) {
			return proximo.desconto(valorTotal);
		}
		return desconto;
	}
	
	protected abstract double calcular(double valorTotal);
}
