package TatuadoraPi.demo.services;
import java.util.List;
import java.util.Optional;

import TatuadoraPi.demo.entidades.Produto;
import TatuadoraPi.demo.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepositorio produtoRepositorio;

    public Produto encontrarId(long id) {
        Optional<Produto> produto = produtoRepositorio.findById((id));
        return produto.orElse(null);
    }

    public List<Produto> todosProdutos() {
        List<Produto> produto = produtoRepositorio.listarTodos();
        return produto;
    }

    public Produto buscaNome(String nome) {
        Optional<Produto> produto = produtoRepositorio.findByNome(nome);
        return produto.orElse(null);
    }

    public Produto gravarProduto(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    public void deletar(long id) {
        produtoRepositorio.deleteById(id);
    }

    public Produto atualizar(Integer id, Produto produto) {
        Produto alterado = encontrarId(id);
        if(alterado!=null){
            alterado.setNome(produto.getNome());
            alterado.setUrl(produto.getUrl());
            alterado.setQuantidade(produto.getQuantidade());
            alterado.setQuantidadeDisponivel(produto.getQuantidadeDisponivel());
            return produtoRepositorio.save(alterado);
        }
        return null;
    }

    public List<Produto> encontrarParteNome(String nome) {
        List<Produto> produto = produtoRepositorio.findByParteNome(nome);
        return produto;
    }

    public Produto buscaId(long id){
        Optional<Produto> produto = produtoRepositorio.findById(id);
        return produto;
    }

}
