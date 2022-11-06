package ejs.com.br;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ejs.com.br.desconto.CalcularDescontoPrimeiraFaixa;
import ejs.com.br.desconto.CalcularDescontoSegundaFaixa;
import ejs.com.br.desconto.CalcularDescontoTerceiraFaixa;
import ejs.com.br.desconto.CalcularFaixaDesconto;
import ejs.com.br.desconto.SemDesconto;

public class PedidoTest {

	private Pedido pedido;
	private CalcularFaixaDesconto calcularFaixaDesconto;
	
	@Before
	public void setUp() {
		calcularFaixaDesconto = new CalcularDescontoTerceiraFaixa(
				new CalcularDescontoSegundaFaixa(
						new CalcularDescontoPrimeiraFaixa(
								new SemDesconto(null))));
		this.pedido = new Pedido(calcularFaixaDesconto);
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = this.pedido.resumo();
		assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(),0.0001);
	}
	
	@Test
	public void devePermitirAdicionarUmItemPedido() {
		this.pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
	}
	
	@Test
	public void deveCalcularTotalEDescontoParaPedidoVazio() {
		assertResumoPedido(0.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() {
		this.pedido.adicionarItem(new ItemPedido("Sabonte", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
		pedido.adicionarItem(new ItemPedido("Pasta dental", 7.0, 3));
		
		assertResumoPedido(30.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));
		
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		
		assertResumoPedido(900.0, 54.0);
	}
	
	@Test
	public void deveAplicarDescontoNa3aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Creme", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Shampoo", 10.0, 30));
		
		assertResumoPedido(1200.0, 96.0);
	}
	
	
	
	
	
	
	
	
	
	
	
}
