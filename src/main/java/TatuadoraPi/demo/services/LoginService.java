package com.TatuadoraPi.demo.services;

import com.TatuadoraPi.demo.entidades.User;
import com.TatuadoraPi.demo.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// usa userRepository para verificar se o cpf e senha correspondem a um usuário existente
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CpfValidationService cpfValidationService;

    public boolean authenticate(String cpf, String senha) {
        //verifica se o cpf é válido
        if (!cpfValidationService.isValidCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
    // se o cpf for válido, busca o usuário no userRepository e verifica a seha
        return userRepository.findByCpf(cpf)
                .map(user -> user.getSenha().equals(senha))
                .orElse(false);
    }
}
