package br.edu.fatecsjc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecsjc.entity.Marca;
import br.edu.fatecsjc.entity.Produto;
import br.edu.fatecsjc.repository.MarcaRepository;
import br.edu.fatecsjc.repository.ProdutoRepository;

@SpringBootTest
@Transactional
@Rollback
class LojaAppApplicationTests {
	
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testaInsercao() {
		Marca marca = new Marca();
		marca.setNome("Acer");
		marcaRepo.save(marca);
		assertNotNull(marca.getId());
	}
	
	
	@Test
	void testaProdutoInsercao() {
		Marca marca = new Marca();
		Produto produto = new Produto();
		marca.setNome("Acer");
		marcaRepo.save(marca);
		produto.setNome("Desktop");
		produto.setPreco(new BigDecimal("9500.00"));
		produto.setMarca(marca);
		produtoRepo.save(produto);
		assertNotNull(produto.getId());
	}

}
