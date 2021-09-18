package br.gov.sp.fatec.springbootloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootloja.entity.Marca;
import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.service.ProdutoService;



@RestController
@RequestMapping(value = "/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List<Produto> pesquisarTodosProdutos() {
        return produtoService.pesquisarTodosProdutos();
    }
    
    @GetMapping(value = "/nome")
    public Produto buscarProdutoPorNome(@RequestParam(value = "nome") String nome) {
        return produtoService.pesquisarPorNomeProduto(nome);        
    }

    @PostMapping
    public Produto cadastrarNovoProduto(@RequestBody Produto produto,@RequestBody Marca marca){
        return produtoService.cadastrarNovoProduto(produto.getNome(), marca.getId(),produto.getPreco());   
    }
}
