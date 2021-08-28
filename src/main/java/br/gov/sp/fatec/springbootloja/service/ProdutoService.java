package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;

import br.gov.sp.fatec.springbootloja.entity.Produto;


public interface ProdutoService {
	
	public Produto cadastrarProduto (String nome, BigDecimal preco, String nomeMarca);
	
	public Produto atualizarProduto (String nome, BigDecimal preco, String nomeMarca);
	
	public Produto excluirPorNomeProduto (String nome);
	
	public Produto excluirPorIdProduto (Long id);
	
	public Produto pesquisarPorNomeProduto (String nome);
	
	public Produto pesquisarPorIdProduto (Long id);
	
	public Produto pesquisarTodosProduto ();
	
}	




