package br.gov.sp.fatec.springbootloja.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Produto;


@SpringBootTest
@Transactional
@Rollback
public class ProdutoServiceTests {
	
	@Autowired
	private ProdutoService produtoService;
	
	/*Conservando o teste anterior
	@Test
	void produtoServiceCadastrarProdutoTestOK() {
		Produto produto = produtoService.cadastrarProduto("Iphone", new BigDecimal("9500.00"), "Apple");
		
	    assertNotNull(produto.getId());		
	}
*/
/*Parando os testes de produto momentaneamente
	@Test
	void produtoServiceCadastrarProdutoTestOK() {
		Produto produto = produtoService.cadastrarProduto("Iphone",1L, new BigDecimal("9500.00"));
		
	    assertNotNull(produto.getId());		
	}

    @Test
	void produtoServicePesquisarPorNomeTestOK(){
		produtoService.cadastrarProduto("Iphone",1L, new BigDecimal("9500.00"));
		assertNotNull(produtoService.pesquisarPorNomeProduto("Iphone"));		
	}
	
	@Test
	void produtoServiceExcluirProdutoTestOK() {
	Produto produto = produtoService.cadastrarProduto("Iphone",1L, new BigDecimal("9500.00"));
	produtoService.excluirPorIdProduto(produto.getId());

	assertNull(produtoService.pesquisarPorNomeProduto("Iphone"));

	}
		
    
	@Test
	void produtoServiceAtualizaTestOK(){
		Produto produto = produtoService.cadastrarProduto("Iphone",1L, new BigDecimal("9500.00"));
		produtoService.atualizarProduto(produto.getId(),"Zenfone", new BigDecimal("3500.00"), "Asus");
		
		assertNull(produtoService.pesquisarPorNomeProduto("Zenfone"));
	}
	*/
}
