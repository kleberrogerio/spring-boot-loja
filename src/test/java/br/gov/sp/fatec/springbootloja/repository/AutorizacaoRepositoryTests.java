package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashSet;

//import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.springbootloja.entity.Autorizacao;
import br.gov.sp.fatec.springbootloja.entity.Usuario;

@SpringBootTest
@Transactional
@Rollback
public class AutorizacaoRepositoryTests {
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

    @Test
    void findByAutorizacoesNomeTest(){
        Autorizacao autorizacao = new Autorizacao();
        autorizacao.setNome("Teste");
        autorizacaoRepo.save(autorizacao);


        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setEmail("teste@email.com");
        usuario.setSenha("123");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(autorizacao);
        usuarioRepo.save(usuario);

        assertFalse(autorizacaoRepo.findByUsuariosNome("Teste").isEmpty());
    }

}
