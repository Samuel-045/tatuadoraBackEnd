package TatuadoraPi.demo.controller;

import TatuadoraPi.demo.entidades.Produto;
import TatuadoraPi.demo.entidades.Pessoa;
import TatuadoraPi.demo.services.PessoaService;
import TatuadoraPi.demo.services.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private ProdutoService produtoService;
    private PessoaService pessoaService;

    @GetMapping("/todosOsProdutos")
    public List<Produto> todosProdutos(){
        List<Produto> produtos = produtoService.todosProdutos();
        return produtos;
    }

    @PostMapping(value="/criarProduto")
    public ResponseEntity<Produto> gravarProduto(
        @RequestBody Produto produto){
        produto = produtoService.gravarProduto(produto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Produto> buscaNome(@PathVariable String nome){
        Produto produto = produtoService.buscaNome(nome);
        return ResponseEntity.ok().body(produto);
    }

   // @GetMapping(value = "/nomeId/{nome}")
   // public ResponseEntity<Produto> buscaNomeId(@PathVariable long id){
        //Produto produto = produtoService.
 //       return ResponseEntity.ok().body(produto);
    //}terminar

    @GetMapping(value = "/nomeParte/{nome}")
    public List <Produto> buscaParteNome(@PathVariable String nome){
        List <Produto> produto = produtoService.encontrarParteNome(nome);
        return produto;
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/atualizarProduto/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id,
                                        @RequestBody Produto produto){
        Produto alterado = produtoService.atualizar(id, produto);
        return ResponseEntity.ok().body(alterado);
    }

}