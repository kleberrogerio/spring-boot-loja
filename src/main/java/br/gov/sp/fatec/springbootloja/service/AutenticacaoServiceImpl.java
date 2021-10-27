package br.gov.sp.fatec.springbootloja.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootloja.entity.Autorizacao;
import br.gov.sp.fatec.springbootloja.entity.Usuario;
import br.gov.sp.fatec.springbootloja.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootloja.repository.UsuarioRepository;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autorizacaoRepo;

    @Autowired
    private PasswordEncoder passEncorder;

    @Transactional
    public Usuario cadastrarUsuario(String nome, String senha, String autorizacao) {
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);
        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(passEncorder.encode(senha));
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    public List<Usuario> buscarTodosUsuarios() {

        return usuarioRepo.findAll();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado! ");
        }
        return User.builder().username(username).password(usuario.getSenha())
                .authorities(usuario.getAutorizacoes().stream()
                    .map(Autorizacao::getNome).collect(Collectors.toList())
                    .toArray(new String[usuario.getAutorizacoes().size()]))
                .build();
    }
    

}
