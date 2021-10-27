package br.gov.sp.fatec.springbootloja.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootloja.entity.Usuario;
import br.gov.sp.fatec.springbootloja.service.AutenticacaoService;


@RestController
@CrossOrigin
@RequestMapping(value="/usuario")
public class UsuarioController{

    @Autowired
    private AutenticacaoService autenticacaoService;

    @JsonView(View.UsuarioResumo.class)
    @GetMapping
    public List<Usuario> pesquisarTodosUsuarios() {
        return autenticacaoService.buscarTodosUsuarios();
    }

}