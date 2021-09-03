package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.repository.MarcaRepository;
import br.gov.sp.fatec.springbootloja.repository.ProdutoRepository;
import java.util.List;



@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Override
	@Transactional
    public Produto cadastrarProduto(String nome, BigDecimal preco, String nomeMarca) {
        Marca marca = marcaRepo.findByNomeIgnoreCase(nomeMarca);
				
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
	public void excluirPorIdProduto(Long id) {
		Produto produto = produtoRepo.findById(id).get();
		if(produto != null) {
			produtoRepo.delete(produto);
			}
	}

	@Override
	public Produto pesquisarPorNomeProduto(String nome) {
		Produto produto = produtoRepo.findByNomeIgnoreCase(nome);
		return produto;
	}

	@Override
	public Produto pesquisarPorIdProduto(Long id) {
		Produto produto = produtoRepo.findById(id).get();
		return produto;
	}

	@Override
	public List<Produto> pesquisarTodosProdutos() {
		return produtoRepo.findAll();
	}

	@Override
	public Produto atualizarProduto(String nome, BigDecimal preco, String nomeMarca) {
		return null;
	}

	@Override
	public Produto atualizarProduto(Long id, String nome, BigDecimal preco, String nomeMarca) {
		return null;
	}  
	
}
