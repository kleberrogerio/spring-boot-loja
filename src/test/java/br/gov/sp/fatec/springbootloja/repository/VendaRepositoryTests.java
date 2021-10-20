package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.entity.Venda;

@SpringBootTest
@Transactional
//@Rollback
public class VendaRepositoryTests {

    @Autowired
    private VendaRepository vendaRepo;

    @Autowired
    private ProdutoRepository produtoRepo;

    @BeforeAll
	static void init(@Autowired JdbcTemplate JdbcTemplate){
		JdbcTemplate.update(
			"insert into mar_marca (mar_nome) values(?)",
			"DELL");
		JdbcTemplate.update(
		"insert into pro_produto (pro_nome,mar_id,pro_preco) values(?,?,?)",
		"DESKTOP",1L,9500.00);
	}
	

   // @Autowired
    //private MarcaRepository marcaRepo;

   // @Autowired
    //private VendaService vendaService;

    /*Arrumar método cadastrar venda
    @Test
	void vendaServiceFindById() {
		Venda venda = vendaService.cadastrarVenda(1L, new BigDecimal("9500.00"), "DESKTOP");

        assertNotNull(vendaRepo.findById(venda.getId()));	   
		
	}
    */
  /* 
    @Test
	void testaVendaInsercaoTestOk() {
		Venda venda = new Venda();

        Marca marca = new Marca();

		Produto produto = new Produto();

        Date date = new Date();

		marca.setNome("DELL");
		marcaRepo.save(marca);

		produto.setNome("DESKTOP");
		produto.setPreco(new BigDecimal("9500.00"));
		produto.setMarca(marca);
        produtoRepo.save(produto);

        venda.setData(date);
        venda.setPrecoVenda(new BigDecimal("10180.00"));
        venda.setQtde(2L);
        venda.setProdutos(new HashSet<Produto>());
        venda.getProdutos().add(produto);
        vendaRepo.save(venda);

		assertNotNull(venda.getId());
    }
  
    Teste retirado por utilizar o banco de dados H2
    @Test
	void testaVendaInsercaoTestNoOk() {
        Assertions.assertThrows(DataIntegrityViolationException.class, ()->
        	{
                Venda venda = new Venda();
                vendaRepo.save(venda);
            });
    }
 */   
}
