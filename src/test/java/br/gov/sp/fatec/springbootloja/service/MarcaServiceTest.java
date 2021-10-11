package br.gov.sp.fatec.springbootloja.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.repository.MarcaRepository;

@SpringBootTest
@Transactional
//@Rollback
public class MarcaServiceTest {

    @Autowired
    private MarcaRepository marcaRepo;

	@Autowired
	private MarcaService marcaService;

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
	void marcaServiceexcluirTestOK() {
		Marca marca = new Marca();
		marca.setNome("IBM");
		marcaRepo.save(marca);
		
		marcaService.excluirMarca(marca);
		
	    assertNull(marcaRepo.findByNomeIgnoreCase("IBM"));
		
	}

	@Test
	void marcaServiceAtualizaTestOK(){
		Marca marca = new Marca();
		marca.setNome("IBM");
		marcaRepo.save(marca);

		marcaService.atualizarMarca(marca.getId(), "Oracle");

		assertEquals("Oracle",marca.getNome());
	}
    
	@Test
	void marcaServicePesquisarPorNomeTestOK(){
		marcaService.cadastrarNovaMarca("LENOVO");
		assertNotNull(marcaService.buscarMarcaPorNome("LENOVO"));
		}
}
