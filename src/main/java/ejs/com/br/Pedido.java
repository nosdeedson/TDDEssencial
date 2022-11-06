package ejs.com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

import ejs.com.br.desconto.CalcularFaixaDesconto;

public class Pedido {

	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	private CalcularFaixaDesconto calcularFaixaDesconto;
	
	public Pedido() {}
	
	public Pedido(CalcularFaixaDesconto calcularFaixaDesconto) {
		this.calcularFaixaDesconto = calcularFaixaDesconto;
	}

	public void adicionarItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}
	
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(new ToDoubleFunction<ItemPedido>() {
			public double applyAsDouble(ItemPedido i) {
				return i.getValorUnitario() * i.getQuantidade();
			}
		}).sum();
		double desconto = calcularFaixaDesconto.desconto(valorTotal);
		
		return new ResumoPedido(valorTotal, desconto);
	}
	
	
}
