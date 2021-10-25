package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.exception.RegistroNaoEncontradoException;
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
	@PreAuthorize("isAuthenticated()")
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
	@PreAuthorize("isAuthenticated()")
	public void deleteProduto(Long id) {
		Produto produto = produtoService.buscarProdutoPorId(id);		
		if(produto != null) {
			produtoRepo.delete(produto);
			}
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Produto pesquisarPorNomeProduto(String nome) {
		Produto produto = produtoRepo.findByNomeIgnoreCase(nome);
		if(produto!=null){
			return produto;
		}
		return null;
		//throw new RuntimeException("Produto não encontrado!");		
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Produto buscarProdutoPorId(Long id) {
		Optional<Produto> produtoOp = produtoRepo.findById(id);
		if(produtoOp.isPresent()){
			return produtoOp.get();
		}
		throw new RegistroNaoEncontradoException("Produto não encontrado!");
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Produto> pesquisarTodosProdutos() {
		return produtoRepo.findAll();
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Produto atualizarProduto(Long id,String nome,Long idMarca, BigDecimal preco) {
		Marca marca = marcaService.buscarMarcaPorId(idMarca);
		Produto produto = produtoRepo.findById(id).get();

		if (produto != null){
            produto.setNome(nome);
			produto.setPreco(preco);
			produto.setMarca(marca);
			produtoRepo.save(produto);
			return produto;		
        }
        throw new RegistroNaoEncontradoException("Produto não encontrado!");
    }
}
