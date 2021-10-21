package br.gov.sp.fatec.springbootloja.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootloja.entity.Produto;
import br.gov.sp.fatec.springbootloja.service.ProdutoService;



@RestController
@RequestMapping(value = "/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @JsonView(View.ProdutoResumo.class)
    @GetMapping
    public List<Produto> pesquisarTodosProdutos() {
        return produtoService.pesquisarTodosProdutos();
    }
    
    @GetMapping(value = "/{id}")
    public Produto buscarProdutoPorId(@PathVariable("id") Long id) {
        return produtoService.buscarProdutoPorId(id);
    }
    
    @GetMapping(value = "/nome")
    public Produto buscarProdutoPorNome(@RequestParam(value = "nome") String nome) {
        return produtoService.pesquisarPorNomeProduto(nome);        
    }
    
    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }  

    @PostMapping
    public Produto cadastrarNovoProduto(@RequestBody Produto produto){
        return produtoService.cadastrarNovoProduto(produto.getNome(),produto.getMarca().getId(),produto.getPreco());
    }  
}
