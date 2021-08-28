package br.gov.sp.fatec.springbootloja.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
