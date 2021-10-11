package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;

@SpringBootTest
@Transactional
//@Rollback
public class MarcaRepositoryTests {

    @Autowired
	private MarcaRepository marcaRepo;	

	@BeforeAll
	static void init(@Autowired JdbcTemplate JdbcTemplate){
		JdbcTemplate.update(
			"insert into mar_marca (mar_nome) values(?)",
			"Acer");		
	}
	
	
	@Test
	void testaMarcaInsercaoTestoOK() {
		Marca marca = new Marca();
		marca.setNome("Acer");
		marcaRepo.save(marca);
		assertNotNull(marca.getId());
	}    
}
