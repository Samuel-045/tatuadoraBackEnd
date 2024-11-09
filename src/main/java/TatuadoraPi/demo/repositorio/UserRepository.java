package com.TatuadoraPi.demo.repositorio;

import com.example.demo.entidades.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    // Dummy data for demonstration purposes
    private static final User DUMMY_USER = new User("12345678901", "password");

    public Optional<User> findByCpf(String cpf) {
        // Here you would query your database
        if (DUMMY_USER.getCpf().equals(cpf)) {
            return Optional.of(DUMMY_USER);
        }
        return Optional.empty();
    }
}
