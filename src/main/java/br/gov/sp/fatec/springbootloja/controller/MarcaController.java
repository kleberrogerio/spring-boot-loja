package br.gov.sp.fatec.springbootloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.service.MarcaService;

@RestController
@RequestMapping(value = "/marca")
@CrossOrigin
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> buscarTodos() {
        return marcaService.buscarTodasMarcas();
    }

    @GetMapping(value = "/{id}")
    public Marca buscarPorId(@PathVariable("id") Long id) {
        return marcaService.buscarMarcaPorId(id);
    }

    @GetMapping(value = "/nome")
    public Marca buscarMarcaPorNome(@RequestParam(value = "nome") String nome) {
        return marcaService.buscarMarcaPorNome(nome);
    }

    @PostMapping
    public Marca cadastrarNovaMarca(@RequestBody Marca marca){
        return marcaService.cadastrarNovaMarca(marca.getNome());
    }

    @PutMapping(value="/{id}")
    public Marca atualizarMarca(@PathVariable("id") Long id, @RequestBody Marca marca){
        return marcaService.atualizarMarca(id, marca.getNome());
    }

    @DeleteMapping(value="/{id}")
    public void deletaMarca(@PathVariable("id") Long id) {
        marcaService.deleteMarca(id);    
    }

}