package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.entity.Venda;
import br.gov.sp.fatec.springbootloja.service.VendaService;

@SpringBootTest
@Transactional
@Rollback
public class VendaRepositoryTests {

    @Autowired
    private VendaRepository vendaRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private MarcaRepository marcaRepo;

    @Autowired
    private VendaService vendaService;

    @Test
	void vendaServiceFindById() {
		Venda venda = vendaService.cadastrarVenda(1L, new BigDecimal("9500.00"), "DESKTOP");

        assertNotNull(vendaRepo.findById(venda.getId()));	   
		
	}

    @Test
	void testaVendaInsercaoTestOk() {
		Venda venda = new Venda();

        Marca marca = new Marca();

		Produto produto = new Produto();

        Date date = new Date();

		marca.setNome("Logitech");
		marcaRepo.save(marca);

		produto.setNome("Mouse");
		produto.setPreco(new BigDecimal("150.00"));
		produto.setMarca(marca);
        produtoRepo.save(produto);

        venda.setData(date);
        venda.setPrecoVenda(new BigDecimal("180.00"));
        venda.setQtde(2L);
        venda.setProdutos(new HashSet<Produto>());
        venda.getProdutos().add(produto);
        vendaRepo.save(venda);

		assertNotNull(venda.getId());
    }
    @Test
	void testaVendaInsercaoTestNoOk() {
        Assertions.assertThrows(DataIntegrityViolationException.class, ()->
        	{
                Venda venda = new Venda();
                vendaRepo.save(venda);
            });
    }
    
}
