package br.gov.sp.fatec.springbootloja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.springbootloja.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByNome(String nome);

    public List<Usuario> findByNomeContainsOrSenhaContains(String nome,String senha);

    public List<Usuario> findByAutorizacoesNome(String nome);
    
}
