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
    
    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

   /* public static class ProdutoMarca {
        Produto produto;
        Marca marca;
        public Produto getProduto() {
            return produto;
        }
        public void setProduto(Produto produto) {
            this.produto = produto;
        }
        public Marca getMarca() {
            return marca;
        }
        public void setMarca(Marca marca) {
            this.marca = marca;
        }
}
  

    @PostMapping
    public Produto cadastrarNovoProduto(@RequestBody ProdutoMarca produtoMarca){
   //     return produtoService.cadastrarNovoProduto(produtoMarca.getProduto().getNome(),produtoMarca.getMarca().getId(),produtoMarca.getProduto().getPreco());
        return produtoService.cadastrarNovoProduto(produtoMarca.produto.getNome(),produtoMarca.marca.getId(),produtoMarca.produto.getPreco());
            //produto.getNome(), marca.getId(),produto.getPreco());   
    }
    
*/
    @PostMapping
    public Produto cadastrarNovoProduto(@RequestBody Produto produto, Marca marca){
   //     return produtoService.cadastrarNovoProduto(produtoMarca.getProduto().getNome(),produtoMarca.getMarca().getId(),produtoMarca.getProduto().getPreco());
        return produtoService.cadastrarNovoProduto(produto.getNome(),marca.getId(),produto.getPreco());
            //produto.getNome(), marca.getId(),produto.getPreco());   
    }
   

  
}
