package br.gov.sp.fatec.springbootloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.service.MarcaService;

@RestController
@RequestMapping(value = "/marca")
@CrossOrigin
public class MarcaController{

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> buscarTodos(){
        return marcaService.buscarTodasMarcas();
    }


}