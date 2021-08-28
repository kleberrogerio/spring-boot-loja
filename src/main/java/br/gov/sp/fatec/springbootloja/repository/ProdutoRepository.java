package br.gov.sp.fatec.springbootloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootloja.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Produto findByNome(String nome);
}
