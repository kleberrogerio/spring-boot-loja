package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;

@SpringBootTest
@Transactional
//@Rollback
public class ProdutoRepositoryTests {

    @Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private MarcaRepository marcaRepo;

	@BeforeAll
	static void init(@Autowired JdbcTemplate JdbcTemplate){
		JdbcTemplate.update(
			"insert into mar_marca (mar_nome) values(?)",
			"DELL");
		JdbcTemplate.update(
		"insert into pro_produto (pro_nome,mar_id,pro_preco) values(?,?,?)",
		"DESKTOP",1L,9500.00);
	}
	
	
	
	@Test
	void testaProdutoInsercaoTestOk() {
		Marca marca = new Marca();
		Produto produto = new Produto();
		marca.setNome("DELL");
		marcaRepo.save(marca);
		produto.setNome("DESKTOP");
		produto.setPreco(new BigDecimal("9500.00"));
		produto.setMarca(marca);
		produtoRepo.save(produto);
		assertNotNull(produto.getId());
	}
	
	@Test
	void testaBuscaProdutoPorNomeAndMarcaQueryTestOK() {
		List<Produto> produto = produtoRepo.buscaProdutoPorNomeEMarca("DESKTOP", "DELL");
		assertFalse(produto.isEmpty());
	}

	@Test
	void testaBuscaNomeOrPrecoTestOk() {
		List<Produto> produto = produtoRepo.findByNomeOrPreco("DESKTOP", new BigDecimal("9500.00"));
		assertFalse(produto.isEmpty());
	}
    
}
