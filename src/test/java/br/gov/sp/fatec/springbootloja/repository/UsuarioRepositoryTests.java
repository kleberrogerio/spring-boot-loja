package br.gov.sp.fatec.springbootloja.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Usuario;

@SpringBootTest
@Transactional
@Rollback
public class UsuarioRepositoryTests {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Test
    void findByNomeTest(){
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setEmail("teste@email.com");
        usuario.setSenha("123");
        usuarioRepo.save(usuario);

        assertNotNull(usuarioRepo.findByNome("Teste"));
    }

    @Test
    void findByNomeContainsOrEmailContains(){
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setEmail("teste@email.com");
        usuario.setSenha("123");
        usuarioRepo.save(usuario);

        assertFalse(usuarioRepo.findByNomeContainsOrEmailContains("est", "lalala").isEmpty());
    }

    
}
