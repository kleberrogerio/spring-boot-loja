package br.gov.sp.fatec.springbootloja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootloja.repository.MarcaRepository;


@Service("marcaService")
public class MarcaServiceImpl implements MarcaService{

    @Autowired
	private MarcaRepository marcaRepo;

    @Override
    @PreAuthorize("isAuthenticated()")
    public void excluirMarca (Marca marca){
		marcaRepo.delete(marca);	
    }
	
    @Override
    @PreAuthorize("isAuthenticated()")
	public Marca pesquisarPorIdMarca (Long id){
        Marca marca = marcaRepo.findById(id).get();
        return marca;
    }
 
    @Override
    @PreAuthorize("isAuthenticated()")
    public Marca atualizarMarca (Long id, String nome){
        Marca marca = marcaRepo.findById(id).get();
        if (marca != null){
            marca.setNome(nome);
            marcaRepo.save(marca);
            return marca;
        }
        throw new RegistroNaoEncontradoException("Marca não encontrada!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")  
    public List<Marca> buscarTodasMarcas(){
        return marcaRepo.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Marca buscarMarcaPorId(Long id){
        Optional<Marca> marcaOp = marcaRepo.findById(id);
        if(marcaOp.isPresent()){
            return marcaOp.get();
        }
        throw new RegistroNaoEncontradoException("Marca não encontrada!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Marca buscarMarcaPorNome(String nome){
        Marca marca = marcaRepo.findByNomeIgnoreCase(nome);
        if(marca !=null){
           return marca; 
        }
        throw new RegistroNaoEncontradoException("Marca não encontrada");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Marca cadastrarNovaMarca(String nome){
        Marca marca = new Marca();
		marca.setNome(nome);
        marcaRepo.save(marca);
        return marca; 
    }    
   

     @Override
     @PreAuthorize("isAuthenticated()")
    public void deleteMarca (Long id){
        Optional<Marca> marcaOp = marcaRepo.findById(id);
       
        if(marcaOp.isPresent()) {
            Boolean semProduto = marcaOp.get().getProdutos().isEmpty();
           
            if(semProduto) {
                marcaRepo.deleteById(id);
            }else{
                throw new RegistroNaoEncontradoException("Tem um produto cadastrado com está marca, exclua o produto primeiro!");
            }
        }else{
        throw new RegistroNaoEncontradoException("Marca não encontrado!"); 
        }
			
    }
}
