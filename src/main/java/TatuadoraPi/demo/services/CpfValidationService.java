package com.TatuadoraPi.demo.services;

import org.springframework.stereotype.Service;

@Service
public class CpfValidationService {

    public boolean isValidCpf(String cpf) {

        //cod samuka (pessoaService)
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {

            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int primeiroDigitoVerificador = 11 - (soma % 11);
            if (primeiroDigitoVerificador >= 10) primeiroDigitoVerificador = 0;


            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int segundoDigitoVerificador = 11 - (soma % 11);
            if (segundoDigitoVerificador >= 10) segundoDigitoVerificador = 0;


            return (cpf.charAt(9) - '0') == primeiroDigitoVerificador &&
                    (cpf.charAt(10) - '0') == segundoDigitoVerificador;
        } catch (NumberFormatException e) {
            return false;
        }
        return true
    }
}
