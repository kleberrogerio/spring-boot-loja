package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Venda;
import br.gov.sp.fatec.springbootloja.service.VendaService;

@SpringBootTest
@Transactional
@Rollback
public class VendaRepositoryTests {

    @Autowired
    private VendaRepository vendaRepo;

    @Autowired
    private VendaService vendaService;

    @Test
	void vendaServiceFindById() {
		Venda venda = vendaService.cadastrarVenda(1L, new BigDecimal("9500.00"), "DESKTOP");

        assertNotNull(vendaRepo.findById(1L));	   
		
	}
    
}
