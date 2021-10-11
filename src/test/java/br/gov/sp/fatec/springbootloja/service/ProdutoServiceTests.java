package br.gov.sp.fatec.springbootloja.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Produto;


@SpringBootTest
@Transactional
//@Rollback
public class ProdutoServiceTests {
	
	@Autowired
	private ProdutoService produtoService;	

	/*@BeforeAll
	static void init(@Autowired JdbcTemplate JdbcTemplate){
		JdbcTemplate.update(
			"insert into mar_marca (mar_nome) values(?)",
			"LENOVO");
		JdbcTemplate.update(
		"insert into pro_produto (pro_nome,mar_id,pro_preco) values(?,?,?)",
		"MOUSE",1L,10000.00);
	}
	*/

	@Test
	void produtoServiceCadastrarProdutoTestOK() {
		Produto produto = produtoService.cadastrarNovoProduto("Iphone",1L, new BigDecimal("9500.00"));
		
	    assertNotNull(produto.getId());		
	}

	@Test
	void produtoServicePesquisarPorNomeTestOK(){
		produtoService.cadastrarNovoProduto("Iphone",1L, new BigDecimal("9500.00"));
		assertNotNull(produtoService.pesquisarPorNomeProduto("Iphone"));		
	}
	
	@Test
	void produtoServiceExcluirProdutoTestOK() {
	Produto produto = produtoService.cadastrarNovoProduto("Iphone",1L, new BigDecimal("9500.00"));
	produtoService.excluirPorIdProduto(produto.getId());

	assertNull(produtoService.pesquisarPorNomeProduto("Iphone"));

	}
		
    
	@Test
	void produtoServiceAtualizaTestOK(){
		Produto produto = produtoService.cadastrarNovoProduto("Iphone",1L, new BigDecimal("9500.00"));
		produtoService.atualizarProduto(produto.getId(),"Zenfone", new BigDecimal("3500.00"), "Asus");
		
		assertNull(produtoService.pesquisarPorNomeProduto("Zenfone"));
	}

}
