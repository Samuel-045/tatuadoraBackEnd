package com.TatuadoraPi.demo.repositorio;

import com.TatuadoraPi.demo.entidades.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    // exemplo de dados
    private static final User user = new User("12345678901", "password");

    public Optional<User> findByCpf(String cpf) {
        if (user.getCpf().equals(cpf)) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
