package br.gov.sp.fatec.springbootloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootloja.entity.Venda;


public interface VendaRepository extends JpaRepository<Venda, Long> {

}
