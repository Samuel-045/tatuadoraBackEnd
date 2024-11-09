package TatuadoraPi.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@Data
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;
    @Column(name = "nome")
    String nome;
    @Column(name= "url")
    String url;
    @Column(name = "quantidade")
    int quantidade;
    @Column(name = "quantidadeDisponível")
    int quantidadeDisponivel;

    public Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Nome = " + nome +
                ", Url Imagem = " + url+
                ", Quantidade = " + quantidade +
                ", Quantidade disponível = '" + quantidadeDisponivel + '\'' +
                '}';
    }
}
