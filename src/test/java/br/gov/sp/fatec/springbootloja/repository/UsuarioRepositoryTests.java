package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Autorizacao;
import br.gov.sp.fatec.springbootloja.entity.Usuario;

@SpringBootTest
@Transactional
@Rollback
public class UsuarioRepositoryTests {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

    @Test
    void findByNomeTest(){
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setSenha("123");
        usuarioRepo.save(usuario);

        assertNotNull(usuarioRepo.findByNome("Teste"));
    }

    @Test
    void findByNomeContainsOrEmailContains(){
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setSenha("123");
        usuarioRepo.save(usuario);

        assertFalse(usuarioRepo.findByNomeContainsOrSenhaContains("est", "lalala").isEmpty());
    }

    @Test
    void findByAutorizacoesNomeTest(){
        Autorizacao autorizacao = new Autorizacao();
        autorizacao.setNome("Teste");
        autorizacaoRepo.save(autorizacao);


        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setSenha("123");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(autorizacao);
        usuarioRepo.save(usuario);

        assertFalse(usuarioRepo.findByAutorizacoesNome("Teste").isEmpty());
    }

    
}
