package br.edu.fatecsjc.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatecsjc.entity.Venda;

@SpringBootTest
@Transactional
@Rollback
public class VendaServiceTests {
	
	@Autowired
	private VendaService vendaService;
	
	@Test
	void vendaServiceCadastrarVendaTestOK() {
		Venda venda = vendaService.cadastrarVenda(1L, new BigDecimal("9500.00"), "notebook");
		
	    assertNotNull(venda.getId());
		
	}

}
