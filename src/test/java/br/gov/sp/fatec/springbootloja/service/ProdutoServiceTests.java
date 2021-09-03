package br.gov.sp.fatec.springbootloja.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	@Test
	void produtoServiceCadastrarProdutoTestOK() {
		Produto produto = produtoService.cadastrarProduto("Iphone", new BigDecimal("9500.00"), "Apple");
		
	    assertNotNull(produto.getId());
		
	}
    @Test
	void produtoServicePesquisarPorNomeTestOK(){
		Produto produto = produtoService.cadastrarProduto("Iphone", new BigDecimal("9500.00"), "Apple");
		assertNotNull(produtoService.pesquisarPorNomeProduto("Iphone"));		
	}
	
	@Test
	void produtoServiceExcluirProdutoTestOK() {
	Produto produto = produtoService.cadastrarProduto("Iphone", new BigDecimal("9500.00"), "Apple");
	produtoService.excluirPorIdProduto(produto.getId());

	assertNull(produtoService.pesquisarPorNomeProduto("Iphone"));

	}
		
    
	/* Implementar
	@Test
	void produtoServiceAtualizaTestOK(){
		Marca marca = new Marca();
		marca.setNome("IBM");
		marcaRepo.save(marca);

		marcaService.atualizarMarca(marca.getId(), "Oracle");

		assertEquals("Oracle",marca.getNome());
	}


	*/
}
