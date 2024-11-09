package TatuadoraPi.demo.services;

import java.text.ParseException;

import TatuadoraPi.demo.entidades.Pessoa;
import TatuadoraPi.demo.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @Bean
    public void instanciarDB() throws ParseException {

        Pessoa pessoa1 = new Pessoa("12341","111.111.111-11");
        Pessoa pessoa2 = new Pessoa("1234","111.111.111-22");
        //trocar os dados quando iniciar o programa

        pessoaRepositorio.saveAll(Arrays.asList(pessoa1, pessoa2));
    }

}
