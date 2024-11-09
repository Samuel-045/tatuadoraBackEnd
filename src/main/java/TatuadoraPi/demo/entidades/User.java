package TatuadoraPi.demo.entidades;


//Apresenta um usuário com os atributos cpf e senha
public class User {
    private String cpf;
    private String senha;

    // Constructors
    public User() {}

    public User(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    // Getters and Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
