package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.repository.ProdutoRepository;



@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

	//@Autowired
	//private MarcaRepository marcaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;

	@Autowired
    private MarcaService marcaService;
	
	@Override
	@Transactional
    public Produto cadastrarProduto(String nome,Long idMarca, BigDecimal preco) {
        Marca marca = marcaService.buscarMarcaPorId(idMarca);
		//Marca marca = marcaRepo.findById(idMarca);
				
	    //if(marca == null) {
	    //	marca = new Marca();
		  //  marca.setNome(nomeMarca);
		    //marcaRepo.save(marca);
		//}
		Produto produto = new Produto(); 
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setMarca(marca);
		marca.setId(idMarca);
		produto.getMarca().getId();
		produtoRepo.save(produto);
		return produto;		
    }

	/*
	Preservando o método anterior
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
*/

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
		if(produto!=null){
			return produto;
		}
		throw new RuntimeException("Produto não encontrado!");		
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
