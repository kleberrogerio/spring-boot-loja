package br.gov.sp.fatec.springbootloja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.repository.MarcaRepository;


@Service("marcaService")
public class MarcaServiceImpl implements MarcaService{

    @Autowired
	private MarcaRepository marcaRepo;

    @Override
    public void excluirMarca (Marca marca){
		marcaRepo.delete(marca);	
    }
	
    @Override
    public Marca atualizarMarca (Long id, String nome){
        Marca marca = marcaRepo.findById(id).get();
        marca.setNome(nome);
        marcaRepo.save(marca);
        return marca;
    }

    @Override
    public List<Marca> buscarTodasMarcas(){
        return marcaRepo.findAll();
    }

    @Override
    public Marca buscarMarcaPorId(Long id){
        Optional<Marca> marcaOp = marcaRepo.findById(id);
        if(marcaOp.isPresent()){
            return marcaOp.get();
        }
        throw new RuntimeException("Marca não encontrada!");
    }

    @Override
    public Marca buscarMarcaPorNome(String nome){
        Marca marca = marcaRepo.findByNomeIgnoreCase(nome);
        if(marca !=null){
           return marca; 
        }
        throw new RuntimeException("Marca não encontrada");
    }

    public Marca cadastrarNovaMarca(String nome){
        Marca marca = new Marca();
		marca.setNome(nome);
        marcaRepo.save(marca);
        return marca; 
    }   

    @Override
    public void deleteMarca (Long id){
        Optional<Marca> marcaOp = marcaRepo.findById(id);
        if(marcaOp.isPresent()) {
            marcaRepo.deleteById(id);
        }else{
        throw new RuntimeException("Marca não encontrado!"); 
        }
			
    }
}
