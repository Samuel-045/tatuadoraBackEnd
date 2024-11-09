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
    @Column(name = "nome")
    String nome;
    @Column(name = "senha")
    String senha;
    @Column(name= "RG")
    String rg;
    @Column(name = "CPF")
    String cpf;
    @Column(name = "CNPJ")
    String cnpj;
    @Column(name = "IE")
    String ie;

    public Pessoa(String nome,String senha, String rg, String cpf, String cnpj, String ie) {

    }

    public Pessoa() {

    }

    //o '@data' já faz automaticamente os getters e setters
}
