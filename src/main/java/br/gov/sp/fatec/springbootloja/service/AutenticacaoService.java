package br.gov.sp.fatec.springbootloja.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.springbootloja.entity.Autorizacao;
import br.gov.sp.fatec.springbootloja.entity.Usuario;

public interface AutenticacaoService extends UserDetailsService {

    public Usuario cadastrarUsuario(String nome,String email,  String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
    public Usuario buscarUsuarioPorNome(String nome);
 
    public Usuario buscarUserById(Long id);

    public void deletarUsuario (Long id);

    public Usuario atualizarUsuario (Long id,String nome,String email,  String senha, String autorizacao);

    public Autorizacao buscarAutorizacaoPorNome(String nome);
}
