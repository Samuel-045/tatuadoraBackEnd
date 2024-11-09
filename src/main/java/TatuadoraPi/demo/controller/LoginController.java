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
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ProdutoService produtoService;

    public Pessoa validarLogin(@RequestBody Pessoa pessoa){
        return pessoa;

        //boolean cpfValido = pessoaService.validacaoCpf(pessoa.getCpf());
        //if(cpfValido){
        //    boolean valido = pessoaService.validarLogin(pessoa.getSenha());
        //    return valido;
        //}else {
        //    return false;
        //}

    }

}
