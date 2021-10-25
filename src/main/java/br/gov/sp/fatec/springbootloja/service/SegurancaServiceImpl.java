package br.gov.sp.fatec.springbootloja.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Autorizacao;
import br.gov.sp.fatec.springbootloja.entity.Usuario;
import br.gov.sp.fatec.springbootloja.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootloja.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autorizacaoRepo;

    @Transactional
    public Usuario cadastrarUsuario(String nome, String senha, String autorizacao){
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);
        if (aut==null){
            aut = new Autorizacao();   
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }


        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    public List<Usuario> buscarTodosUsuarios(){

        return usuarioRepo.findAll();
        
    }
    
}
