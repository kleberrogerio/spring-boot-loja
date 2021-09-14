package br.gov.sp.fatec.springbootloja.service;

import java.util.List;

import br.gov.sp.fatec.springbootloja.entity.Marca;

public interface MarcaService {
    
    public void excluirMarca (Marca marca);
	
	public Marca pesquisarPorIdMarca (Long id);

    public Marca atualizarMarca (Long id, String nome);
    
    public List<Marca> buscarTodasMarcas();
}
