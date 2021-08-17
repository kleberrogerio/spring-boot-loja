package br.edu.fatecsjc.service;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecsjc.entity.Marca;
import br.edu.fatecsjc.entity.Produto;
import br.edu.fatecsjc.repository.MarcaRepository;
import br.edu.fatecsjc.repository.ProdutoRepository;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Override
	@Transactional
	public Produto cadastrarProduto(String nome, BigDecimal preco, String nomeMarca) {
		Marca marca = marcaRepo.findByNome(nomeMarca);
				
	    if(marca == null) {
	    	marca = new Marca();
		    marca.setNome(nomeMarca);
		    marcaRepo.save(marca);
		}
		Produto produto = new Produto(); 
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setMarca(marca);
		produtoRepo.save(produto);
		return produto;		
	}

	@Override
	public Produto atualizarProduto(String nome, BigDecimal preco, String nomeMarca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto excluirPorNomeProduto(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto excluirPorIdProduto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto pesquisarPorNomeProduto(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto pesquisarPorIdProduto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto pesquisarTodosProduto() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
