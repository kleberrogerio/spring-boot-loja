package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;

import br.gov.sp.fatec.springbootloja.entity.Venda;

public interface VendaService {
	
	public Venda cadastrarVenda (Long qtde, BigDecimal preco, String nomeProduto); 
	
	public Venda atualizarVenda (String nome, BigDecimal preco, String nomeMarca);
	
	public Venda excluirPorIdVenda (Long id);
	
	public Venda pesquisarPorIdVenda (Long id);
	
	public Venda pesquisarTodosVenda ();
}
