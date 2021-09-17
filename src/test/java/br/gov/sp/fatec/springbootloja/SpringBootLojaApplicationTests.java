package br.gov.sp.fatec.springbootloja;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.repository.ProdutoRepository;
import br.gov.sp.fatec.springbootloja.service.MarcaService;


@SpringBootTest
class LojaAppApplicationTests {
	
	/*Para testar a inserção de Produto
	@Autowired
	private MarcaService marcaService;

	@Autowired
	private ProdutoRepository produtoRepo;	
	
	@Test
	void cadastrarProdutoTest() {
        Marca marca = marcaService.buscarMarcaPorId(1L);
		Produto produto = new Produto(); 
		produto.setNome("Mouse");
		produto.setPreco(new BigDecimal("8500.00"));
		produto.setMarca(marca);
		marca.setId(1L);
		produto.getMarca().getId();
		produtoRepo.save(produto);			
    }
*/
	@Test
	void contextLoads() {
	}
	
}
