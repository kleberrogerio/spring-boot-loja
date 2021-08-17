package br.edu.fatecsjc.service;

import java.math.BigDecimal;

import br.edu.fatecsjc.entity.Venda;

public interface VendaService {
	
	public Venda cadastrarVenda (Long qtde, BigDecimal preco, String nomeProduto); 
	
	public Venda atualizarVenda (String nome, BigDecimal preco, String nomeMarca);
	
	public Venda excluirPorIdVenda (Long id);
	
	public Venda pesquisarPorIdVenda (Long id);
	
	public Venda pesquisarTodosVenda ();
}
