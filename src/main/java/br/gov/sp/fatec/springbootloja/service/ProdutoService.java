package br.edu.fatecsjc.service;

import java.math.BigDecimal;

import br.edu.fatecsjc.entity.Produto;

public interface ProdutoService {
	
	public Produto cadastrarProduto (String nome, BigDecimal preco, String nomeMarca);
	
	public Produto atualizarProduto (String nome, BigDecimal preco, String nomeMarca);
	
	public Produto excluirPorNomeProduto (String nome);
	
	public Produto excluirPorIdProduto (Long id);
	
	public Produto pesquisarPorNomeProduto (String nome);
	
	public Produto pesquisarPorIdProduto (Long id);
	
	public Produto pesquisarTodosProduto ();
	
}	




