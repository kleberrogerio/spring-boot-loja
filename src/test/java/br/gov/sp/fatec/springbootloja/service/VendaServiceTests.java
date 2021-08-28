package br.gov.sp.fatec.springbootloja.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Venda;

@SpringBootTest
@Transactional
@Rollback
public class VendaServiceTests {
	
	@Autowired
	private VendaService vendaService;
	
	@Test
	void vendaServiceCadastrarVendaTestOK() {
		Venda venda = vendaService.cadastrarVenda(1L, new BigDecimal("9500.00"), "DESKTOP");
		
	    assertNotNull(venda.getId());
		
	}

}
