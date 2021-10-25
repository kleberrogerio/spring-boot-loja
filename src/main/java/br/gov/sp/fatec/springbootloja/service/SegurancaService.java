package br.gov.sp.fatec.springbootloja.service;

import java.util.List;

import br.gov.sp.fatec.springbootloja.entity.Usuario;

public interface SegurancaService {

    public Usuario cadastrarUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}
