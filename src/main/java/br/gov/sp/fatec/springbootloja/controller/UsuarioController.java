package br.gov.sp.fatec.springbootloja.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootloja.entity.Autorizacao;
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

    @JsonView(View.MarcaResumo.class)
    @PostMapping
    public Usuario cadastrarNovoUsuario(@RequestBody Usuario usuario){
        return autenticacaoService.cadastrarUsuario(usuario.getNome(),usuario.getEmail(),usuario.getSenha(),"ROLE_USUARIO");
    }

    @JsonView(View.UsuarioResumo.class)
    @GetMapping(value = "/nome")
    public Usuario buscarPorNome(@RequestParam(value="nome") String nome) {
      return autenticacaoService.buscarUsuarioPorNome(nome);
    }

    @JsonView(View.UsuarioCompleto.class)
    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id) {
      return autenticacaoService.buscarUserById(id);
    }

    @JsonView(View.AutorizacaoResumo.class)
    @GetMapping(value = "/autorizacao/{autorizacao}")
    public Autorizacao buscarAutorizacaoPorNome(@PathVariable("autorizacao") String nome) {
      return autenticacaoService.buscarAutorizacaoPorNome(nome);
    }

    /*@JsonView(View.UsuarioCompleto.class)
    @PutMapping(value="/{id}")
    public Usuario atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario marca){
        return autenticacaoService.atualizarMarca(id,usuario.getNome());
    }
*/
    @JsonView(View.UsuarioCompleto.class)
    @DeleteMapping(value="/{id}")
    public void deletarUsuario(@PathVariable("id") Long id) {
      autenticacaoService.deletarUsuario(id); 
    }

}