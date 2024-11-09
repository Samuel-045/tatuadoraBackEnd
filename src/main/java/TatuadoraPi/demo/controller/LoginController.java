package com.TatuadoraPi.demo.controller;

import com.TatuadoraPi.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> logar(@RequestBody LoginRequest request) {
        try {
            boolean authenticated = loginService.authenticate(request.getCpf(), request.getSenha());

            //se a autentificação for bem sucedida, o token é retornado ao cliente
            if (authenticated) {
                String token = "dummyToken";
                return ResponseEntity.ok().body(new TokenResponse(token));
            } else { //se não envia uma mensagem de erro
                return ResponseEntity.status(401).body(new ErrorResponse("Credenciais inválidas."));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    //capturar os dados enviados na requisição de login
    private static class LoginRequest {
        private String cpf;
        private String senha;

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

    //enviar o token de volta ao cliente.
    private static class TokenResponse {
        public String token;

        public TokenResponse(String token) {
            this.token = token;
        }
    }

    //enviar mensagens de erro em caso de falha.
    private static class ErrorResponse {
        public String erro;

        public ErrorResponse(String erro) {
            this.erro = erro;
        }
    }
}
