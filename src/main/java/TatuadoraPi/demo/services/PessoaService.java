package TatuadoraPi.demo.services;

import TatuadoraPi.demo.entidades.Pessoa;
import TatuadoraPi.demo.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepositorio pessoaRepositorio;

    public boolean validarLogin(String senha){
        Optional<Pessoa> pessoa = pessoaRepositorio.validacaoLogin(senha);
        if(pessoa.isPresent()){
            return true;
        }else{
            return false;
        }

    }

    public boolean validacaoCpf(String cpf){

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

    }

}
