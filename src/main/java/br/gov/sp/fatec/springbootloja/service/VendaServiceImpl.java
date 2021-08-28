package br.gov.sp.fatec.springbootloja.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.entity.Venda;
import br.gov.sp.fatec.springbootloja.repository.ProdutoRepository;
import br.gov.sp.fatec.springbootloja.repository.VendaRepository;


@Service("vendaService")
public class VendaServiceImpl implements VendaService {
	
	@Autowired
	private VendaRepository vendaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Override
	@Transactional
	public Venda cadastrarVenda(Long qtde, BigDecimal preco, String nomeProduto) {
		Produto produto = produtoRepo.findByNome(nomeProduto);
		
	    if(produto != null) {
	    	Venda venda = new Venda(); 
	    	Date date = new Date();
			venda.setData(date);
			venda.setPrecoVenda(preco);
			venda.setQtde(qtde);
			venda.setProdutos(new HashSet<Produto>());
			venda.getProdutos().add(produto);
			vendaRepo.save(venda);
			return venda;
	    }
	    return null;
	}

	@Override
	public Venda atualizarVenda(String nome, BigDecimal preco, String nomeMarca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda excluirPorIdVenda(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda pesquisarPorIdVenda(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda pesquisarTodosVenda() {
		// TODO Auto-generated method stub
		return null;
	}
}


