package TatuadoraPi.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;
    @Column(name = "senha")
    String senha;
    @Column(name = "CPF")
    String cpf;

    public Pessoa(String senha, String cpf) {
        this.senha = senha;
        this.cpf = cpf;
    }

    public Pessoa() {

    }

    //o '@data' já faz automaticamente os getters e setters
}
