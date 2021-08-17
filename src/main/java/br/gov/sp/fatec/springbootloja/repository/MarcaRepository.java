package br.edu.fatecsjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecsjc.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
