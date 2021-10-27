package br.gov.sp.fatec.springbootloja.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.springbootloja.entity.Usuario;

public interface AutenticacaoService extends UserDetailsService {

    public Usuario cadastrarUsuario(String nome,String email,  String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}
