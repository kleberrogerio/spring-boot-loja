package br.edu.fatecsjc.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecsjc.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public Produto findByNome(String nome);
}
