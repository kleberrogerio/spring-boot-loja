package br.gov.sp.fatec.springbootloja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootloja.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    public Marca findByNomeIgnoreCase(String nome);
   
}
