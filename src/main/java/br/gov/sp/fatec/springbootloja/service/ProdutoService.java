package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;
import java.util.List;
import br.gov.sp.fatec.springbootloja.entity.Produto;


public interface ProdutoService {
	
	public Produto cadastrarProduto (String nome, BigDecimal preco, String nomeMarca);
	
	public Produto atualizarProduto (String nome, BigDecimal preco, String nomeMarca);
	
	public void excluirPorIdProduto (Long id);
	
	public Produto pesquisarPorNomeProduto (String nome);
	
	public Produto pesquisarPorIdProduto (Long id);
	
	public List<Produto> pesquisarTodosProdutos ();

	public Produto atualizarProduto(Long id, String nome, BigDecimal preco, String nomeMarca);    
	
}	




