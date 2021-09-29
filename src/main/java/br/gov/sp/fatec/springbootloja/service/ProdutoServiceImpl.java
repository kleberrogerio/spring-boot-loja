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

	@Autowired
	private ProdutoRepository produtoRepo;

	@Autowired
    private MarcaService marcaService;

	@Autowired
	private ProdutoService produtoService;    
	
	@Override
	@Transactional
    public Produto cadastrarNovoProduto(String nome,Long idMarca, BigDecimal preco) {
        Marca marca = marcaService.buscarMarcaPorId(idMarca);
		Produto produto = new Produto(); 
		produto.setNome(nome);
		produto.setPreco(preco);
		produto.setMarca(marca);
		produtoRepo.save(produto);
		return produto;		
    }

    @Override
	public void excluirPorIdProduto(Long id) {
		Produto produto = produtoService.pesquisarPorIdProduto(id);		
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
		return null;
		//throw new RuntimeException("Produto não encontrado!");		
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
