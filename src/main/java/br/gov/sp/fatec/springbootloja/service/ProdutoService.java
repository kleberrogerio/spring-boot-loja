package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;
import java.util.List;
import br.gov.sp.fatec.springbootloja.entity.Produto;


public interface ProdutoService {
	
	public Produto cadastrarNovoProduto (String nome, Long idMarca,BigDecimal preco);
	
	public Produto atualizarProduto (Long id, String nome,Long idMarca, BigDecimal preco);
	
	public void deleteProduto (Long id);
	
	public Produto pesquisarPorNomeProduto (String nome);
	
	public Produto buscarProdutoPorId (Long id);
	
	public List<Produto> pesquisarTodosProdutos ();	   
	
}	




