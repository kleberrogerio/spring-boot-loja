package br.gov.sp.fatec.springbootloja.service;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
//@Rollback
public class VendaServiceTests {
	
	@Autowired
	//private VendaService vendaService;

	@BeforeAll
	static void init(@Autowired JdbcTemplate JdbcTemplate){
		JdbcTemplate.update(
			"insert into mar_marca (mar_nome) values(?)",
			"LENOVO");
		JdbcTemplate.update(
		"insert into pro_produto (pro_nome,mar_id,pro_preco) values(?,?,?)",
		"MOUSE",1L,10000.00);
	}
	
	/* Arrumar Posteriormente
	@Test
	void vendaServiceCadastrarVendaTestOK() {
		Venda venda = vendaService.cadastrarVenda(1L, new BigDecimal("9500.00"), "DESKTOP");
		
	    assertNotNull(venda.getId());
		
	}
	*/

}
